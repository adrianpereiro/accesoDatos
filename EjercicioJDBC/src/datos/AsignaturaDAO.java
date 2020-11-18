package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.IAsignaturaDAO;
import modelo.Entidades.Asignatura;

public class AsignaturaDAO implements IAsignaturaDAO {

	@Override
	public void insertar(Asignatura asignatura) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO asignatura (nombre, horas, idCiclo) " + "VALUES (?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(insertar);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getHorasSemanales());
			ps.setInt(3, asignatura.getIdCiclo());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(asignatura.toString());
		conexion.cerrarConexion(con);
	}

	@Override
	public void insertarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO asignatura (nombre, horas, idCiclo) " + "VALUES (?,?,?);";

		try {
			PreparedStatement ps = con.prepareStatement(insertar);
			for (Asignatura asignatura : listaAsignaturas) {

				ps.setString(1, asignatura.getNombre());
				ps.setInt(2, asignatura.getHorasSemanales());
				ps.setInt(3, asignatura.getIdCiclo());
				System.out.println(asignatura.toString());
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
	public void eliminar(Asignatura asignatura) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM asignatura WHERE (nombre = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			ps.setString(1, asignatura.getNombre());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(asignatura.toString() + " ha sido eliminado" );
		conexion.cerrarConexion(con);
	}

	@Override
	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM asignatura WHERE (nombre = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			for (Asignatura asignatura : listaAsignaturas) {
				ps.setString(1, asignatura.getNombre());
				System.out.println(asignatura.toString() + " ha sido eliminado" );
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
	public void modificar(Asignatura asignatura) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String modificar = "UPDATE asignatura SET nombre = ?, horas = ?, idCiclo = ? WHERE nombre = ?;";

		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getHorasSemanales());
			ps.setInt(3, asignatura.getIdCiclo());
			ps.setString(4, asignatura.getNombre());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(asignatura.toString() + " ha sido modificado" );
		conexion.cerrarConexion(con);
	}

	@Override
	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
		String modificar = "UPDATE asignatura SET nombre = ?, horas = ?, idCiclo = ? WHERE nombre = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			for(Asignatura asignatura : listaAsignaturas) {
			
				
				ps.setString(1, asignatura.getNombre());
				ps.setInt(2, asignatura.getHorasSemanales());
				ps.setInt(3, asignatura.getIdCiclo());
				ps.setString(4, asignatura.getNombre());
				System.out.println(asignatura.toString() + " ha sido modificado" );
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conexion.cerrarConexion(con);
	}
}
