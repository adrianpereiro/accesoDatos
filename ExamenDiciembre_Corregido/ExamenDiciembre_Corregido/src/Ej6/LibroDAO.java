package Ej6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO {

	private Connection obtenerConexion() throws SQLException, ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3306/examendiciembredam";
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}
	
	//Método de eliminación SIN TRANSACCIONES
	public void eliminarAutorLibros(int idAutor) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		try {
			

			String consulta = "DELETE FROM LIBRO WHERE LIBRO.AUTOR_ID=?";
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, idAutor);
			
			ps.execute();

			consulta = "DELETE FROM AUTOR WHERE id=?";
			ps = con.prepareStatement(consulta);
			ps.setInt(1, idAutor);
			
			ps.execute();

		} catch (SQLException ex) {
			
		} finally {
			con.close();
		}
	}
	
	//Metodo de eliminación CON TRANSACCIONES
	public void eliminarAutorLibrosEditorial(int idEditorial) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		try {
			
			con.setAutoCommit(false);
			
			String consulta = "SELECT distinct(autor_id) FROM LIBRO WHERE editorial_id=?";
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, idEditorial);
			
			ResultSet rs= ps.executeQuery();
			ArrayList<Integer> listaIds=new ArrayList<Integer>();
			while(rs.next()) {
				listaIds.add(rs.getInt(1));	
			}
			
			consulta = "DELETE FROM LIBRO WHERE editorial_id=?";
			ps = con.prepareStatement(consulta);
			ps.setInt(1, idEditorial);
			ps.execute();

			for(int idAutor:listaIds) {
				consulta = "DELETE FROM AUTOR WHERE id=?";
				ps = con.prepareStatement(consulta);
				ps.setInt(1, idAutor);
				ps.execute();
			}
			
			
			consulta = "DELETE FROM EDITORIAL WHERE id=?";
			ps = con.prepareStatement(consulta);
			ps.setInt(1, idEditorial);
			
			ps.execute();
			
			con.commit();

		} catch (SQLException ex) {
			con.rollback();
			ex.printStackTrace();
		} finally {
			con.close();
		}
	}
	
}
