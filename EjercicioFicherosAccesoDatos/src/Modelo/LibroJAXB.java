package Modelo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="libros")
public class LibroJAXB {
	private ArrayList<Libro> listaLibros;
	
	public void setListaLibros(ArrayList<Libro> listaLibro) {
		this.listaLibros = listaLibro;
	}
	
	@XmlElement(name="libro")
	public ArrayList<Libro> getListaLibros(){
		return this.listaLibros;
	}
}
