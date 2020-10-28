package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Libro;
import Modelo.Personaje;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		ArrayList<Libro> listaLibros = new ArrayList<>();
		String ruta = "";
		File f = new File(ruta);
		if (ProcesamientoFichero.existeFichero(f) == false) {
			ArrayList<Personaje> listaPersonajes = new ArrayList<>();
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);

				InputStreamReader leer = new InputStreamReader(fis);
				@SuppressWarnings("resource")
				BufferedReader br = new BufferedReader(leer);
				String linea;
				while ((linea = br.readLine()) != null) {
					String[] datos = linea.split(";");
					String tituloLibro = datos[0];
					String Editorial = datos[1];
					String Autor = datos[2];
					LocalDate fechaPublicacion = LocalDate.parse(datos[3]);
					String Genero = datos[4];
					String listaDatosPersonajes = datos[5];
					String[] datosPersonajes = listaDatosPersonajes.split("-");
					for (int i = 0; i < datosPersonajes.length; i++) {
						String personaje = datosPersonajes[i];
						String[] datosPersonaje2 = personaje.split(",");
						String nombrePersonaje = datosPersonaje2[0];
						String importancia = datosPersonaje2[1];
						Personaje personajes = new Personaje(nombrePersonaje, importancia);
						listaPersonajes.add(personajes);
					}
					Libro libro = new Libro(tituloLibro, Editorial, Autor, fechaPublicacion, Genero, listaPersonajes);
					listaLibros.add(libro);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Fichero no encontrado");
		}
		return listaLibros;
	}

	public void guardarFichero(ArrayList<Libro> listaLibros) {
		File f = new File("C:\\Users\\PC33\\Desktop\\prueba.txt");
		if (ProcesamientoFichero.existeFichero(f) == false) {
			FileWriter fiw = null;
			try {
				fiw = new FileWriter(f);

				for (Libro libro : listaLibros) {
					String tituloLibro = libro.getTituloLibro();
					String Editorial = libro.getEditorial();
					String Autor = libro.getAutor();
					LocalDate fechaPublicacion = libro.getFechaPublicacion();
					String cadenaFechaPublicacion = fechaPublicacion.toString();
					String Genero = libro.getGenero();
					String libroGuardar = tituloLibro + ";" + Editorial + ";" + Autor + ";" + cadenaFechaPublicacion + ";" + Genero + ";";
					ArrayList<Personaje> listaPersonajes = libro.getPersonajesPrincipales();
					for (Personaje personajes : listaPersonajes) {
						String nombre = personajes.getNombre();
						String importancia = personajes.getImportancia();
						libroGuardar = libroGuardar + "-" + nombre + "," + importancia;
					}
					fiw.write(libroGuardar + "\n");
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fiw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Boolean borrarFichero() {
		return null;

	}

}
