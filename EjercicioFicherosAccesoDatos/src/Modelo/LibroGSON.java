package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LibroGSON{
	@SerializedName("titulo")
	@Expose
	private String tituloLibro;
	@SerializedName("editorial")
	@Expose
	private String Editorial;
	@SerializedName("autor")
	@Expose
	private String Autor;
	@SerializedName("fechaDePublicacion")
	@Expose
	private LocalDate fechaPublicacion;
	@SerializedName("genero")
	@Expose
	private String Genero;
	@SerializedName("personajesPrincipales")
	@Expose
	private ArrayList<PersonajeGSON> personajesPrincipales;

	public LibroGSON(String tituloLibro, String Editorial, String Autor, LocalDate fechaPublicacion, String Genero, ArrayList<PersonajeGSON> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.Editorial = Editorial;
		this.Autor = Autor;
		this.fechaPublicacion = fechaPublicacion;
		this.Genero = Genero;
		this.personajesPrincipales = personajesPrincipales;

	}
	
	public LibroGSON() {
		
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

	public ArrayList<PersonajeGSON> getPersonajesPrincipales() {
		return personajesPrincipales;
	} 

	public void setPersonajesPrincipales(ArrayList<PersonajeGSON> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}
	@Override
	public String toString() {
		return "Libro \n-Titulo Libro=" + tituloLibro +"\n"+ "-Editorial=" + Editorial +"\n"+ "-Autor=" + Autor
				+"\n"+ "-Fecha de Publicacion=" + fechaPublicacion +"\n"+ "-Genero=" + Genero; //+"\n"+ "-Personajes Principales="
				//+ personajesPrincipales.toString();
	}


}

