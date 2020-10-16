package Negocio;
import java.util.ArrayList;

import Modelo.Libro;

public interface IProcesamientoFichero {
	
	public ArrayList<Libro> leerFichero();
	
	public void guardarFichero();
}

