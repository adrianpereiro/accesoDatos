package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(propOrder={"tituloLibro", "editorial", "autor","fechaPublicacion","genero","personajesPrincipales"})
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
	
	public Libro() {
		
	}

	public String getTituloLibro() {
		return tituloLibro;
	}
	@XmlElement(name="Titulo")
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getEditorial() {
		return Editorial;
	}
	@XmlElement (name="Editorial")
	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getAutor() {
		return Autor;
	}
	@XmlElement (name="Autor")
	public void setAutor(String autor) {
		Autor = autor;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	@XmlElement (name="FechaDePublicacion") @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getGenero() {
		return Genero;
	}
	@XmlElement (name="Genero")
	public void setGenero(String genero) {
		Genero = genero;
	}

	public ArrayList<Personaje> getPersonajesPrincipales() {
		return personajesPrincipales;
	} 
	 @XmlElementWrapper(name="personajesPrincipales")
	    @XmlElement(name="personaje")
	public void setPersonajesPrincipales(ArrayList<Personaje> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}
	@Override
	public String toString() {
		return "Libro \n-Titulo Libro=" + tituloLibro +"\n"+ "-Editorial=" + Editorial +"\n"+ "-Autor=" + Autor
				+"\n"+ "-Fecha de Publicacion=" + fechaPublicacion +"\n"+ "-Genero=" + Genero; //+"\n"+ "-Personajes Principales="
				//+ personajesPrincipales.toString();
	}


}
