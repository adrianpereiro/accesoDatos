package modelo.entidades;
// default package
// Generated 2 feb. 2021 13:38:13 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Libro generated by hbm2java
 */
public class Libro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codLibro;
	private String titulo;
	private String editorial;
	private float precio;
	private Set<Ejemplar> ejemplars = new HashSet<Ejemplar>(0);
	private Set<Autor> autors = new HashSet<Autor>(0);

	public Libro() {
	}

	public Libro(String codLibro, String titulo, String editorial, float precio) {
		this.codLibro = codLibro;
		this.titulo = titulo;
		this.editorial = editorial;
		this.precio = precio;
	}

	public Libro(String codLibro, String titulo, String editorial, float precio, Set<Ejemplar> ejemplars, Set<Autor> autors) {
		this.codLibro = codLibro;
		this.titulo = titulo;
		this.editorial = editorial;
		this.precio = precio;
		this.ejemplars = ejemplars;
		this.autors = autors;
	}

	public String getCodLibro() {
		return this.codLibro;
	}

	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Set<Ejemplar> getEjemplars() {
		return this.ejemplars;
	}

	public void setEjemplars(Set<Ejemplar> ejemplars) {
		this.ejemplars = ejemplars;
	}

	public Set<Autor> getAutors() {
		return this.autors;
	}

	public void setAutors(Set<Autor> autors) {
		this.autors = autors;
	}

	@Override
	public String toString() {
		return "Libro [codLibro=" + codLibro + ", titulo=" + titulo + ", editorial=" + editorial + ", precio=" + precio
				+ ", ejemplars=" + ejemplars + ", autors=" + autors + "]";
	}

}
