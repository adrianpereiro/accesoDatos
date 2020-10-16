package Negocio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import Modelo.Libro;

public abstract class ProcesamientoFichero implements IProcesamientoFichero{
	
	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<Libro> leerFichero() {
		File f = new File("");
		ArrayList<Libro> libros = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			FileInputStream is = new FileInputStream(f);
			InputStreamReader leer= new InputStreamReader(is);

				int fin;
				while((fin = leer.read())!=-1) {
					
				}
				
				
				
				
				//Libro p = (Libro) entrada.readObject();
				//libros.add(p);
			}
		
		return libros;
	}
	
	public static Boolean existeFichero(){
		return null;
		
	}
	
	public static Boolean borrarFichero() {
		return null;
		
	}

}
