package Negocio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Libro;
import Modelo.Personaje;

public class ProcesamientoFicheroObjetos extends ProcesamientoFichero {
	
	@Override
	public ArrayList<Libro> leerFichero() {
		File f = new File("");
		ArrayList<Libro> listaLibros = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
			for (;;) {
				Libro l = (Libro) entrada.readObject();
				listaLibros.add(l);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("Llego al final del fichero");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listaLibros;
	}
		

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		File f = new File("");
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(f));
			for (Libro libro : listaLibros) {
				String tituloLibro = libro.getTituloLibro();
				String Editorial = libro.getEditorial();
				String Autor = libro.getAutor();
				LocalDate fechaPublicacion = libro.getFechaPublicacion();
				String cadenaFechaPublicacion = fechaPublicacion.toString();
				String Genero = libro.getGenero();
				String libroGuardar = tituloLibro + ";" + Editorial + ";" + Autor + ";" + cadenaFechaPublicacion + ";"
						+ Genero + ";";
				ArrayList<Personaje> listaPersonajes = libro.getPersonajesPrincipales();
				for (Personaje personajes : listaPersonajes) {
					String nombre = personajes.getNombre();
					String importancia = personajes.getImportancia();
					libroGuardar = libroGuardar + "-" + nombre + "," + importancia;
				}
				ficheroSalida.writeObject(libroGuardar+"\n");
			}

			ficheroSalida.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
		
	}

}
