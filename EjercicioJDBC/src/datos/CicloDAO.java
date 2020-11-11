package datos;

import java.sql.Connection;

public class CicloDAO {
	ConexionMySQL conexion = new ConexionMySQL();
	Connection con = conexion.creacionConexion();
}
