package vista;

import java.util.ArrayList;

import datos.AsignaturaDAO;
import modelo.Entidades.Asignatura;

public class Programa {

	public static void main(String[] args) {
		Asignatura asig = new Asignatura("Acceso a datos", 160, 1);
		Asignatura asig2 = new Asignatura("Interfaces", 100, 1);
		ArrayList<Asignatura> listaAsignatura = new ArrayList<>();
		listaAsignatura.add(asig);
		listaAsignatura.add(asig2);
		AsignaturaDAO proc = new AsignaturaDAO();
//		proc.insertar(asig);
//		proc.eliminar(asig);
//		proc.insertarMultiple(listaAsignatura);
//		proc.eliminarMultiple(listaAsignatura);

//		Asignatura asig3 = new Asignatura("Acceso a datos", 180, 1);
//		proc.modificar(asig3);

	}

}
