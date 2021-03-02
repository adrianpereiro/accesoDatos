package Ej7;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ejercicio7 {

	public static void main(String[] args) {
		UtilProcedimientos util= new UtilProcedimientos();
		ArrayList<ResultadoProcesamiento> res;
		try {
			res = util.ejecutarProcedimiento("kent");
			for(ResultadoProcesamiento r:res) {
				System.out.println(r);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
