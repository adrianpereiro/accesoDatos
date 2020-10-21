package Negocio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Modelo.Libro;

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
			for (Libro p : listaLibros) {
				ficheroSalida.writeObject(p);
			}

			ficheroSalida.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
		
	}

}
