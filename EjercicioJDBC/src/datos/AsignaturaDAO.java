package datos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.IAsignaturaDAO;
import modelo.Entidades.Asignatura;

public class AsignaturaDAO implements IAsignaturaDAO{
	
	@Override
	public void insertar(Asignatura asignatura) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
		String nombre = asignatura.getNombre();
		int id = asignatura.getId();
		int idCiclo = asignatura.getIdCiclo();
		String insertar= "INSERT INTO ALUMNOS (nombre, horas, idCiclo)"
				+ "VALUES ('" + nombre +"'," + id + ", " + idCiclo + ");"; 
		try {
			Statement s = con.createStatement();
			s.execute(insertar);
			s.close();
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
		
		String insertar= "INSERT INTO ALUMNOS (nombre, horas, idCiclo)\r\n";
		for(Asignatura asignatura : listaAsignaturas) {
			String nombre = asignatura.getNombre();
			int id = asignatura.getId();
			int idCiclo = asignatura.getIdCiclo();
			insertar = insertar
					+ "VALUES ('" + nombre +"'," + id + ", " + idCiclo + ")";
		}
		insertar = insertar +";";
		
		Statement s;
		try {
			s = con.createStatement();
			s.execute(insertar);
			s.close();
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
		
		String eliminar = "DELETE FROM asignatura"
				+"WHERE id = " + asignatura.getId();
		
		Statement s;
		try {
			s = con.createStatement();
			s.execute(eliminar);
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
	}
	@Override
	public void modificar(Asignatura asignatura) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
	}
	@Override
	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
	}
}
