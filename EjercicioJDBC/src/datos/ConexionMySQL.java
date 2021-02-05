package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexion {

	@Override
	public Connection creacionConexion() {
		CargarDriver();
		String url="jdbc:mysql://localhost:3306/ejerciciojdbc";
		//String url="jdbc:mysql://localhost:3306/ejemplohibernate";
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
	public void cerrarConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void CargarDriver() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
