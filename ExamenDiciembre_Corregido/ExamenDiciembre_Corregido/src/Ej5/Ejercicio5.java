package Ej5;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ejercicio5 {

	public static void main(String[] args) {
		LibroDAO libDAO= new LibroDAO();
		System.out.println("LIBROS DE KENT");
		try {
			ArrayList<Libro>libros = libDAO.leerLibro("kent");
			for(Libro l:libros) {
				System.out.println(l);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("TODOS LOS LIBROS");
		try {
			ArrayList<Libro>libros = libDAO.leerLibros();
			for(Libro l:libros) {
				System.out.println(l);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("INSERTAR LIBROS");
		
		ArrayList<Libro> librosInsertar= new ArrayList<>();
		librosInsertar.add(new Libro(0, "Prueba1", "pr", 1925, 1, 1));
		librosInsertar.add(new Libro(0, "Prueba2", "pr2", 1925, 1, 1));
		try {
			libDAO.insertarLibros(librosInsertar);
			for(Libro l:librosInsertar) {
				System.out.println(l);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("BORRAR LIBROS");
		/*
		try {
			libDAO.borrarLibro(new Libro(5, "Prueba1", "pr", 1925, 1, 1));
			libDAO.borrarLibro(new Libro(6, "Prueba1", "pr", 1925, 1, 1));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		System.out.println("MODIFICAR LIBRO Y AUTOR");
		try {
			libDAO.modificarLibro(new Libro(9, "PruebaMod", "prMod", 2001, 1, 1), new Autor(1, "KENT", "FOLLET"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
