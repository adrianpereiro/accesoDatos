package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ICicloDAO;
import modelo.Entidades.Asignatura;
import modelo.Entidades.Ciclo;

public class CicloDAO implements ICicloDAO {
	
	@Override
	public void insertar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO ciclo (nombre, grado) " + "VALUES (?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(insertar);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
		
	}
	@Override
	public void insertarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO ciclo (nombre, grado) " + "VALUES (?,?);";

		try {
			PreparedStatement ps = con.prepareStatement(insertar);
			for (Ciclo ciclo : listaCiclos) {

				ps.setString(1, ciclo.getNombre());
				ps.setString(2, ciclo.getGrado());
				ps.addBatch();
			}
			ps.executeBatch();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conexion.cerrarConexion(con);
		
	}
	@Override
	public void eliminar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM ciclo WHERE (nombre = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			ps.setString(1, ciclo.getNombre());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conexion.cerrarConexion(con);
		
	}
	@Override
	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM ciclo WHERE (nombre = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			for (Ciclo ciclo : listaCiclos) {
				ps.setString(1, ciclo.getNombre());
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
		
	}
	@Override
	public void modificar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String modificar = "UPDATE ciclo SET nombre = ?, grado = ? WHERE nombre = ?;";

		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			ps.setString(3, ciclo.getNombre());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conexion.cerrarConexion(con);
		
	}
	@Override
	public void modificarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
		String modificar = "UPDATE ciclo SET nombre = ?, grado = ? WHERE nombre = ?";
		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			for(Ciclo ciclo : listaCiclos) {
				ps.setString(1, ciclo.getNombre());
				ps.setString(2, ciclo.getGrado());
				ps.setString(3, ciclo.getNombre());
				ps.addBatch();
			}
			ps.executeBatch();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conexion.cerrarConexion(con);
		
	}
	@Override
	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas) {
		// TODO Auto-generated method stub
		
	}
}