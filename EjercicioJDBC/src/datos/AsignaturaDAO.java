package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			PreparedStatement ps = con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getHorasSemanales());
			ps.setInt(3, asignatura.getIdCiclo());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			asignatura.setId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
	}

	@Override
	public void insertarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO asignatura (nombre, horas, idCiclo) " + "VALUES (?,?,?);";

		try {
			PreparedStatement ps = con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
			for (Asignatura asignatura : listaAsignaturas) {

				ps.setString(1, asignatura.getNombre());
				ps.setInt(2, asignatura.getHorasSemanales());
				ps.setInt(3, asignatura.getIdCiclo());
				ps.addBatch();

			}
			ps.executeBatch();
			ResultSet rs = ps.getGeneratedKeys();
			int i = 0;
			while (rs.next()) {
				int id = rs.getInt(1);
				listaAsignaturas.get(i).setId(id);
				i++;
			}
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

		String eliminar = "DELETE FROM asignatura WHERE (id = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			ps.setInt(1, asignatura.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
	}

	@Override
	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM asignatura WHERE (id = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			for (Asignatura asignatura : listaAsignaturas) {
				ps.setInt(1, asignatura.getId());
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

		String modificar = "UPDATE asignatura SET nombre = ?, horas = ?, idCiclo = ? WHERE id = ?;";

		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getHorasSemanales());
			ps.setInt(3, asignatura.getIdCiclo());
			ps.setInt(4, asignatura.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
	}

	@Override
	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String modificar = "UPDATE asignatura SET nombre = ?, horas = ?, idCiclo = ? WHERE id = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			for (Asignatura asignatura : listaAsignaturas) {

				ps.setString(1, asignatura.getNombre());
				ps.setInt(2, asignatura.getHorasSemanales());
				ps.setInt(3, asignatura.getIdCiclo());
				ps.setInt(4, asignatura.getId());
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
