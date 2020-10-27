package Modelo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"nombre","importancia"})
public class Personaje  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String importancia;
		
	public Personaje(String nombre, String importancia) {
		this.nombre = nombre;
		this.importancia = importancia;
	}
	
	public Personaje() {
		
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
