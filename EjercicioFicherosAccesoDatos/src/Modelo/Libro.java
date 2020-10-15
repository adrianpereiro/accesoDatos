package Modelo;

import java.time.LocalDate;

public class Libro {
	private String tituloLibro;
	private String Editorial;
	private String Autor;
	private LocalDate fechaPublicacion;
	private String Genero;
	private String personajesPrincipales;
	
	Libro(String tituloLibro, String Editorial, String Autor, LocalDate fechaPublicacion, String Genero, String personajesPrincipales){
		this.tituloLibro=tituloLibro;
		this.Editorial=Editorial;
		this.Autor=Autor;
		this.fechaPublicacion=fechaPublicacion;
		this.Genero=Genero;
		this.personajesPrincipales=personajesPrincipales;
		
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

	public String getPersonajesPrincipales() {
		return personajesPrincipales;
	}

	public void setPersonajesPrincipales(String personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}
	
}
