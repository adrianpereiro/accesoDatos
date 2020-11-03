package Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonajeJACKSON {
	
	@JsonProperty(value = "nombre")
	private String nombre;
	@JsonProperty(value = "importancia")
	private String importancia;
		
	public PersonajeJACKSON(String nombre, String importancia) {
		this.nombre = nombre;
		this.importancia = importancia;
	}
	
	public PersonajeJACKSON() {
		
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

}
