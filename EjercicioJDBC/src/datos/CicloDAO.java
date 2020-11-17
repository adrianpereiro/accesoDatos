package datos;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.ICicloDAO;
import modelo.Entidades.Asignatura;
import modelo.Entidades.Ciclo;

public class CicloDAO implements ICicloDAO {
	ConexionMySQL conexion = new ConexionMySQL();
	Connection con = conexion.creacionConexion();
	
	@Override
	public void insertar(Ciclo ciclo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertarMultiple(ArrayList<Ciclo> listaCiclos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminar(Ciclo ciclo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificar(Ciclo ciclo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificarMultiple(ArrayList<Ciclo> listaCiclos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas) {
		// TODO Auto-generated method stub
		
	}
}