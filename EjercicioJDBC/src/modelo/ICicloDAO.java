package modelo;

import java.util.ArrayList;

import modelo.Entidades.Asignatura;
import modelo.Entidades.Ciclo;

public interface ICicloDAO {
	public void insertar(Ciclo ciclo);
	
	public void insertarMultiple(ArrayList<Ciclo> listaCiclos);
	
	public void eliminar(Ciclo ciclo);
	
	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos);
	
	public void modificar(Ciclo ciclo);
	
	public void modificarMultiple(ArrayList<Ciclo> listaCiclos);
	
	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas);
}
