package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonajeGSON {
	@SerializedName("nombre")
	@Expose
	private String nombre;
	@SerializedName("importancia")
	@Expose
	private String importancia;
		
	public PersonajeGSON(String nombre, String importancia) {
		this.nombre = nombre;
		this.importancia = importancia;
	}
	
	public PersonajeGSON() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	@Override
	public String toString() {
		return "(Nombre=" + nombre + ", Importancia=" + importancia + ")";
	}

}
