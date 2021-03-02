package Ej3;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"numero", "puerta", "metros_cuadrados"})
public class Piso {
	
	private int id;
	private int numero;
	private String puerta;
	private int metros_cuadrados;
	
	
	//Getters y Setters
	@XmlTransient
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="numero_piso")
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	@XmlElement(name="metros")
	public int getMetros_cuadrados() {
		return metros_cuadrados;
	}
	public void setMetros_cuadrados(int metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}
	
	public Piso() {}
	
	//Constructor
	public Piso(int id, int numero, String puerta, int metros_cuadrados) {
		super();
		this.id = id;
		this.numero = numero;
		this.puerta = puerta;
		this.metros_cuadrados = metros_cuadrados;
	}
	@Override
	public String toString() {
		return "Piso [id=" + id + ", numero=" + numero + ", puerta=" + puerta + ", metros_cuadrados=" + metros_cuadrados
				+ "]";
	}
	
}//Piso