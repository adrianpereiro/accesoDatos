package Ej2;

import java.io.Serializable;

public class Piso implements Serializable{
	//Modelizar la clase Piso con atibutos id, numero, puerta y metros_cuadrados (tendrán esos nombres)
	private int id;
	private int numero;
	private String puerta;
	private int metros_cuadrados;
	
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "\n\tPiso [id=" + id + ", numero=" + numero + ", puerta=" + puerta + ", metros_cuadrados=" + metros_cuadrados
				+ "]";
	}
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
	public int getMetros_cuadrados() {
		return metros_cuadrados;
	}
	public void setMetros_cuadrados(int metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}
	
	
	//Constructor
	public Piso(int id, int numero, String puerta, int metros_cuadrados) {
		super();
		this.id = id;
		this.numero = numero;
		this.puerta = puerta;
		this.metros_cuadrados = metros_cuadrados;
	}
	
}//Piso
