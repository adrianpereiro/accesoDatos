package datos;

import java.sql.Connection;

public interface IConexion {
	
	public Connection creacionConexion();
	
	public void cerrarConexion(Connection con);
}
