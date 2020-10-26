package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;


public class Libro  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tituloLibro;
	private String Editorial;
	private String Autor;
	private LocalDate fechaPublicacion;
	private String Genero;
	private ArrayList<Personaje> personajesPrincipales;

	public Libro(String tituloLibro, String Editorial, String Autor, LocalDate fechaPublicacion, String Genero, ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.Editorial = Editorial;
		this.Autor = Autor;
		this.fechaPublicacion = fechaPublicacion;
		this.Genero = Genero;
		this.personajesPrincipales = personajesPrincipales;

	}

	public String getTituloLibro() {
		return tituloLibro;
	}
	@XmlElement
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getEditorial() {
		return Editorial;
	}
	@XmlElement
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getAutor() {
		return Autor;
	}
	@XmlElement
	public void setAutor(String autor) {
		Autor = autor;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	@XmlElement
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return Genero;
	}
	@XmlElement
	public void setGenero(String genero) {
		Genero = genero;
	}

	public ArrayList<Personaje> getPersonajesPrincipales() {
		return personajesPrincipales;
	}
	@XmlElement
	public void setPersonajesPrincipales(ArrayList<Personaje> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}
	@Override
	public String toString() {
		return "Libro \n-Titulo Libro=" + tituloLibro +"\n"+ "-Editorial=" + Editorial +"\n"+ "-Autor=" + Autor
				+"\n"+ "-Fecha de Publicacion=" + fechaPublicacion +"\n"+ "-Genero=" + Genero +"\n"+ "-Personajes Principales="
				+ personajesPrincipales.toString();
	}


}
