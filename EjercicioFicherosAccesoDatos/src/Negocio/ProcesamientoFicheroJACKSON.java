package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Modelo.Libro;
import Modelo.LibroJACKSON;
import Modelo.Personaje;

import Modelo.PersonajeJACKSON;

public class ProcesamientoFicheroJACKSON extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		ArrayList<Libro> listaLibros = new ArrayList<>();
		BufferedReader br;
		String ruta = "C:\\Users\\PC33\\Desktop\\librosJSON.txt";
		ObjectMapper JSON_MAPPER = new ObjectMapper();
		JSON_MAPPER.registerModule(new JavaTimeModule());
		try {
			FileInputStream fis = new FileInputStream(new File(ruta));
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String jsonString = "";
			String lineaJSON;
			while ((lineaJSON = br.readLine()) != null) {
				jsonString = jsonString + lineaJSON;
			}
			LibroJACKSON[] libros = JSON_MAPPER.readValue(jsonString, LibroJACKSON[].class);
			for (LibroJACKSON lJ : libros) {

				ArrayList<Personaje> personajesPrincipales = new ArrayList<>();
				String tituloLibro = lJ.getTituloLibro();
				String Editorial = lJ.getEditorial();
				String Autor = lJ.getAutor();
				LocalDate fechaPublicacion = lJ.getFechaPublicacion();
				String Genero = lJ.getGenero();
				ArrayList<PersonajeJACKSON> personajesPrincipalesJACKSON = lJ.getPersonajesPrincipales();
				for (PersonajeJACKSON pJ : personajesPrincipalesJACKSON) {
					String nombre = pJ.getNombre();
					String importancia = pJ.getImportancia();
					Personaje p = new Personaje(nombre, importancia);
					personajesPrincipales.add(p);
				}

				Libro l = new Libro(tituloLibro, Editorial, Autor, fechaPublicacion, Genero, personajesPrincipales);
				listaLibros.add(l);

			}
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibros;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		String ruta = "C:\\Users\\PC33\\Desktop\\librosJACKSON.txt";
		File f = new File(ruta);
		
	    ObjectMapper JSON_MAPPER = new ObjectMapper();
	    JSON_MAPPER.registerModule(new JavaTimeModule());

	    try {
			JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValue(f, listaLibros);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
