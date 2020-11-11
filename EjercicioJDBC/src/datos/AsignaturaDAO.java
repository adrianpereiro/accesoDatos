package datos;

import java.sql.Connection;

public class AsignaturaDAO {
	ConexionMySQL conexion = new ConexionMySQL();
	Connection con = conexion.creacionConexion();
}
