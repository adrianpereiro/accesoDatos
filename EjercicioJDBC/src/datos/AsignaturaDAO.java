package datos;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.IAsignaturaDAO;
import modelo.Entidades.Asignatura;

public class AsignaturaDAO implements IAsignaturaDAO{
	ConexionMySQL conexion = new ConexionMySQL();
	Connection con = conexion.creacionConexion();
	
	@Override
	public void insertar(Asignatura asignatura) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Asignatura asignatura) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificar(Asignatura asignatura) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		// TODO Auto-generated method stub
		
	}
}
