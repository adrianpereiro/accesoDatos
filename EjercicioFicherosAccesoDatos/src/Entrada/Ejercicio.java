package Entrada;
	
import java.time.LocalDate;
import java.util.ArrayList;
		
import Modelo.Libro;
import Modelo.Personaje;
import Negocio.IProcesamientoFichero;
import Negocio.ProcesamientoFicheroJACKSON;
import Negocio.ProcesamientoFicheroJSON;
import Negocio.ProcesamientoFicheroPlano;
import Negocio.ProcesamientoFicheroXMLDOM;
import Negocio.ProcesamientoFicheroXMLJAXB;
		
public class Ejercicio {
	public static void main(String[] args) {
//		procesarFicheroPlano();
//		procesarFicheroXMLDOM();
//		procesarFicheroXMLJAXB();
//		procesarFicheroJSON();
		procesarFicheroJACKSON();
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
		proc.leerFichero();
	}	
		
	public static void procesarFicheroXMLDOM() {
		IProcesamientoFichero proc = new ProcesamientoFicheroXMLDOM();
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
		
		ArrayList<Libro> listaLibros2 = proc.leerFichero();
		System.out.println("\nDOM\n");
		for(Libro libro : listaLibros2) {
			System.out.println(libro.toString());
		}
		
	}	
		
	public static void procesarFicheroXMLJAXB() {
		IProcesamientoFichero proc = new ProcesamientoFicheroXMLJAXB();
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
		System.out.println("\nJAXB\n");
		ArrayList<Libro> listaLibros2 = proc.leerFichero();
		for(Libro libro : listaLibros2) {
			System.out.println(libro.toString());
		}
		
	}

	public static void procesarFicheroJSON() {
		IProcesamientoFichero proc = new ProcesamientoFicheroJSON();
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
		System.out.println("\nJSON\n");
		ArrayList<Libro> listaLibros2 = proc.leerFichero();
		for(Libro libro : listaLibros2) {
			System.out.println(libro.toString());
		}
		
		
	}	
		
	public static void procesarFicheroJACKSON() {
		IProcesamientoFichero proc = new ProcesamientoFicheroJACKSON();
		/*ArrayList<Libro> listaLibros = new ArrayList<>();
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
		proc.guardarFichero(listaLibros);*/
		System.out.println("\nJSON\n");
		ArrayList<Libro> listaLibros2 = proc.leerFichero();
		for(Libro libro : listaLibros2) {
			System.out.println(libro.toString());
		}
	}	
		
}		
	