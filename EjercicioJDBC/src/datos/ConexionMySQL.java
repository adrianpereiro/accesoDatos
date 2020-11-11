package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexion {

	@Override
	public Connection creacionConexion() {
		String url="jdbc:mysql://localhost:3306/prueba";
		String usuario="root";
		String pass="";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;

	}

	@Override
	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CargarDriver() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
