package Negocio;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Libro;
import Modelo.Personaje;

public abstract class ProcesamientoFichero implements IProcesamientoFichero{
	
	@SuppressWarnings("deprecation")
	@Override
	public ArrayList<Libro> leerFichero() {
		File f = new File("");
		ArrayList<Libro> listaLibros = new ArrayList<>();
		ArrayList<Personaje> listaPersonajes = new ArrayList<>();
			
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
			
			@SuppressWarnings("resource")
			InputStreamReader leer= new InputStreamReader(fis);
			BufferedReader br= new BufferedReader(leer);
				String linea;
				while((linea = br.readLine())!= null)  {
					String[] datos = linea.split(";");
					String tituloLibro= datos[0];
					String Editorial=datos[1];
					String Autor=datos[2];
					LocalDate fechaPublicacion=LocalDate.parse(datos[3]);
					String Genero= datos[4];
					String listaDatosPersonajes= datos[5];
					String[] datosPersonajes= listaDatosPersonajes.split("-");
					for(int i=0;i<datosPersonajes.length;i++) {
						String personaje=datosPersonajes[i];
						String[] datosPersonaje2= personaje.split(",");
						String nombrePersonaje= datosPersonaje2[0];
						String importancia=datosPersonaje2[1];
						Personaje personajes= new Personaje(nombrePersonaje,importancia);
						listaPersonajes.add(personajes);
					}
					Libro libro= new Libro(tituloLibro, Editorial,libro.setAutor(autor), fechaPublicacion, Genero, listaPersonajes);
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
				
				//Libro p = (Libro) entrada.readObject();
				//libros.add(p);
			
		
		return libros;
	}
	
	public static Boolean existeFichero(){
		return null;
		
	}
	
	public static Boolean borrarFichero() {
		return null;
		
	}

}
