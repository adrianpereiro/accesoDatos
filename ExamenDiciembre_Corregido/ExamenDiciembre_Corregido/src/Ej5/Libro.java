package Ej5;

public class Libro {
	private int id;
	private String titulo;
	private String genero;
	private int anho_publicacion;
	
	private int editorial_id;
	private int autor_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAnho_publicacion() {
		return anho_publicacion;
	}
	public void setAnho_publicacion(int anho_publicacion) {
		this.anho_publicacion = anho_publicacion;
	}
	public int getEditorial_id() {
		return editorial_id;
	}
	public void setEditorial_id(int editorial_id) {
		this.editorial_id = editorial_id;
	}
	public int getAutor_id() {
		return autor_id;
	}
	public void setAutor_id(int autor_id) {
		this.autor_id = autor_id;
	}
	
	public Libro(int id, String titulo, String genero, int anho_publicacion, int editorial_id, int autor_id) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.anho_publicacion = anho_publicacion;
		this.editorial_id = editorial_id;
		this.autor_id = autor_id;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", anho_publicacion="
				+ anho_publicacion + ", editorial_id=" + editorial_id + ", autor_id=" + autor_id + "]";
	}
	
	
	
}
