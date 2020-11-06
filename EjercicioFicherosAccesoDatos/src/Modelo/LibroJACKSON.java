package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class LibroJACKSON {

	@JsonProperty(value = "titulo")
	private String tituloLibro;
	@JsonProperty(value = "editorial")
	private String Editorial;
	@JsonProperty(value = "autor")
	private String Autor;
	@JsonProperty(value = "fechaDePublicacion")
	private LocalDate fechaPublicacion;
	@JsonProperty(value = "genero")
	private String Genero;
	@JsonProperty(value = "personajesPrincipales")
	//@JsonUnwrapped
	private ArrayList<PersonajeJACKSON> personajesPrincipales;

	public LibroJACKSON(String tituloLibro, String Editorial, String Autor, LocalDate fechaPublicacion, String Genero, ArrayList<PersonajeJACKSON> personajesPrincipales) {
			this.tituloLibro = tituloLibro;
			this.Editorial = Editorial;
			this.Autor = Autor;
			this.fechaPublicacion = fechaPublicacion;
			this.Genero = Genero;
			this.personajesPrincipales = personajesPrincipales;

		}

	public LibroJACKSON() {
			
		}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public ArrayList<PersonajeJACKSON> getPersonajesPrincipales() {
		return personajesPrincipales;
	}

	public void setPersonajesPrincipales(ArrayList<PersonajeJACKSON> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}

	@Override
	public String toString() {
		return "Libro \n-Titulo Libro=" + tituloLibro + "\n" + "-Editorial=" + Editorial + "\n" + "-Autor=" + Autor
				+ "\n" + "-Fecha de Publicacion=" + fechaPublicacion + "\n" + "-Genero=" + Genero  +"\n"+ "-Personajes Principales="+ personajesPrincipales.toString();
	}

}
