package Negocio;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import Modelo.Libro;
import Modelo.LibroJACKSON;
import Modelo.PersonajeGSON;

public class ProcesamientoFicheroJACKSON extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		ArrayList<Libro> listaLibros = new ArrayList<>();	
		String ruta="C:\\Users\\PC33\\Desktop\\librosJSON.txt";
		ObjectMapper JSON_MAPPER = new ObjectMapper();
		//JSON_MAPPER.registerModule(new JSR310Module());
		//JSON_MAPPER.registerModule(new SimpleModule().addSerializer(new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE)));
		JSON_MAPPER.registerModule(new JavaTimeModule());
		String jsonString ="[\r\n"
				+ "  {\r\n"
				+ "    \"titulo\": \"Hola\",\r\n"
				+ "    \"editorial\": \"Que tal\",\r\n"
				+ "    \"autor\": \"Buenas\",\r\n"
				+ "    \"fechaDePublicacion\": \"2001-05-20\",\r\n"
				+ "    \"genero\": \"Neutro\",\r\n"
				+ "    \"personajesPrincipales\": [\r\n"
				+ "      {\r\n"
				+ "        \"nombre\": \"Javier\",\r\n"
				+ "        \"importancia\": \"Nula\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"nombre\": \"Zaida\",\r\n"
				+ "        \"importancia\": \"Principal\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"titulo\": \"EY\",\r\n"
				+ "    \"editorial\": \"Que tal\",\r\n"
				+ "    \"autor\": \"Buenas\",\r\n"
				+ "    \"fechaDePublicacion\": \"2001-05-20\",\r\n"
				+ "    \"genero\": \"Neutro\",\r\n"
				+ "    \"personajesPrincipales\": [\r\n"
				+ "      {\r\n"
				+ "        \"nombre\": \"Javier\",\r\n"
				+ "        \"importancia\": \"Nula\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"nombre\": \"Zaida\",\r\n"
				+ "        \"importancia\": \"Principal\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "]";
		try {
			LibroJACKSON[] libros = JSON_MAPPER.readValue(jsonString, LibroJACKSON[].class);
			for(LibroJACKSON lJ : libros) {
			ArrayList<PersonajeGSON> pJ = lJ.getPersonajesPrincipales();
			System.out.println(lJ.toString());
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
		//JSON_MAPPER.writeValue(new File(ruta), listaLibros);
		
	}

}
