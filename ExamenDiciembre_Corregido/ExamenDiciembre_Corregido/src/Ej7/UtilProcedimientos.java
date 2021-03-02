package Ej7;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilProcedimientos {
	
	private Connection obtenerConexion() throws SQLException, ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3306/examendiciembredam";
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}
	
	//Llamada que haga uso del procedimiento almacenado, procese los datos de vuelta (convirtiéndolos a 
	//tipo ResultadoProcesamiento y los imprima por pantalla
	public ArrayList<ResultadoProcesamiento> ejecutarProcedimiento(String nombre) throws ClassNotFoundException, SQLException {
		ResultadoProcesamiento res= new ResultadoProcesamiento();
		
		Connection con=obtenerConexion();
		CallableStatement st= con.prepareCall("{call obtener_datos_autor(?)}");
		st.setString(1, nombre);
		
		ArrayList<ResultadoProcesamiento> retorno = new ArrayList<>();
		
		if(!st.execute()) {
			System.out.println("Sin resultados");
		}
		else {
			ResultSet rs= st.getResultSet();
			
			
			while(rs.next()) {
				//autor.nombre,libro.titulo,libro.genero,editorial.nombre
				String autor=rs.getString(1);
				String titulo=rs.getString(2);
				String genero =rs.getString(3);
				String editorial=rs.getString(4);
				ResultadoProcesamiento rp= new ResultadoProcesamiento();
				rp.autor=autor;
				rp.titulo=titulo;
				rp.genero=genero;
				rp.editorial=editorial;
				retorno.add(rp);
			}
		}
		con.close();
		
		
		return retorno;
	}
}
