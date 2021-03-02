package Ej6;

import java.sql.SQLException;

public class Ejercicio6 {

	public static void main(String[] args) {
		LibroDAO lib= new LibroDAO();
		
		try {
			lib.eliminarAutorLibrosEditorial(1);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
