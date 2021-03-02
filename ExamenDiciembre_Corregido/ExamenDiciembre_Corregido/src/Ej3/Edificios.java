package Ej3;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="listaEdificios")
public class Edificios {	
	private ArrayList<Edificio> listaEdificios;

	public void setListaEdificios(ArrayList<Edificio> listaEdificios) {
		this.listaEdificios = listaEdificios;
	}
	
	@XmlElement(name="edificio")
	public ArrayList<Edificio> getListaEdificios() {
		return this.listaEdificios;
	}
}
