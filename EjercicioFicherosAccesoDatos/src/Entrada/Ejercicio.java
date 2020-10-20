package Entrada;

import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Libro;
import Modelo.Personaje;
import Negocio.IProcesamientoFichero;
import Negocio.ProcesamientoFicheroPlano;

public class Ejercicio {
	public static void main(String[] args) {
		procesarFicheroPlano();
	}

	public static void procesarFicheroPlano() {
		IProcesamientoFichero proc = new ProcesamientoFicheroPlano();
		ArrayList<Libro> listaLibros = new ArrayList<>();
		ArrayList<Personaje> listaPersonaje = new ArrayList<>();
		Personaje p1 = new Personaje("Javier", "Nula");
		Personaje p2 = new Personaje("Zaida", "Principal");
		listaPersonaje.add(p1);
		listaPersonaje.add(p2);
		LocalDate fecha = LocalDate.of(2001, 05, 20);
		Libro l1 = new Libro("Hola", "Que tal", "Buenas", fecha, "Neutro", listaPersonaje);
		Libro l2 = new Libro("EY", "Que tal", "Buenas", fecha, "Neutro", listaPersonaje);
		listaLibros.add(l1);
		listaLibros.add(l2);
		proc.guardarFichero(listaLibros);

	}
}
