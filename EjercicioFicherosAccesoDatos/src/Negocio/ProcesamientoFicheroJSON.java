package Negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Modelo.Libro;
import Modelo.LibroGSON;
import Modelo.LocalDateAdapterJSON;
import Modelo.Personaje;
import Modelo.PersonajeGSON;

public class ProcesamientoFicheroJSON extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		LibroGSON[] libros = null;
		String ruta="";
		ArrayList<Libro> listaLibro = new ArrayList<Libro>();
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapterJSON())
				.excludeFieldsWithoutExposeAnnotation().create();
		try {
			FileReader fr = new FileReader(new File(ruta));
			if (ProcesamientoFichero.existeFichero(new File(ruta)) == false) {
				libros = gson.fromJson(fr, LibroGSON[].class);

				ArrayList<LibroGSON> listaGSON = new ArrayList<LibroGSON>(Arrays.asList(libros));

				for (LibroGSON lGSON : listaGSON) {
					ArrayList<PersonajeGSON> listaPersonajesGSON = lGSON.getPersonajesPrincipales();
					ArrayList<Personaje> listaPersonajes = new ArrayList<>();
					for (PersonajeGSON pGSON : listaPersonajesGSON) {
						String nombre = null, importancia = null;
						Personaje p = new Personaje(nombre, importancia);
						p.setNombre(pGSON.getNombre());
						p.setImportancia(pGSON.getImportancia());
						listaPersonajes.add(p);
					}
					Libro nl = new Libro(lGSON.getTituloLibro(), lGSON.getEditorial(), lGSON.getAutor(),
							lGSON.getFechaPublicacion(), lGSON.getGenero(), listaPersonajes);
					listaLibro.add(nl);
				}
			}else {
				System.out.println("El fichero no existe");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return listaLibro;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		ArrayList<LibroGSON> listaLibrosGSON = new ArrayList<>();
		String ruta="";
		for (Libro l : listaLibros) {
			ArrayList<PersonajeGSON> listaPersonajesGSON = new ArrayList<>();
			ArrayList<Personaje> listaPersonajes = l.getPersonajesPrincipales();
			for (Personaje p : listaPersonajes) {
				String nombre = null, importancia = null;
				PersonajeGSON pGSON = new PersonajeGSON(nombre, importancia);
				pGSON.setNombre(p.getNombre());
				pGSON.setImportancia(p.getImportancia());
				listaPersonajesGSON.add(pGSON);
			}
			LibroGSON lGSON = new LibroGSON(l.getTituloLibro(), l.getEditorial(), l.getAutor(), l.getFechaPublicacion(),
					l.getGenero(), listaPersonajesGSON);
			listaLibrosGSON.add(lGSON);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting()
				.registerTypeAdapter(LocalDate.class, new LocalDateAdapterJSON()).create();
		String json = gson.toJson(listaLibrosGSON);
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File(ruta));
			fw.write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
