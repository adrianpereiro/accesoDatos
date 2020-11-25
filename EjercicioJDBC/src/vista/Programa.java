package vista;

import java.util.ArrayList;

import datos.AsignaturaDAO;
import datos.CicloDAO;
import modelo.Entidades.Asignatura;
import modelo.Entidades.Ciclo;

public class Programa {

	public static void main(String[] args) {
		//Las clases VO estan creadas pero no las use para probar
		//------------------------------Ciclos------------------------------
		Ciclo ciclo1 = new Ciclo("DAM", "medio");
		Ciclo ciclo2 = new Ciclo("DAW", "Medio");
		ArrayList<Ciclo> listaCiclos = new ArrayList<>();
		listaCiclos.add(ciclo1);
		listaCiclos.add(ciclo2);
		CicloDAO procCiclo = new CicloDAO();
		
		//insertar
		procCiclo.insertar(ciclo1);
		System.out.println(ciclo1 + " añadido");
		
		//elminiar
		procCiclo.eliminar(ciclo1);
		
		//insertar varios
		procCiclo.insertarMultiple(listaCiclos);
		for(Ciclo ciclo : listaCiclos) {
			System.out.println(ciclo + " añadido");
		}
		
		//eliminar varios
		procCiclo.eliminarMultiple(listaCiclos);
		for(Ciclo ciclo : listaCiclos) {
			System.out.println(ciclo + " eliminado");
		}
		
		//modificar 
		ciclo1.setNombre("prueba");
		procCiclo.modificar(ciclo1);
		System.out.println(ciclo1 + " modificado");	
		
		//modificar varios
		ArrayList<Ciclo> listaCiclosModificar = new ArrayList<>();
		ciclo1.setNombre("pruebaMultiple");
		ciclo2.setNombre("pruebaMultiple2");
		listaCiclosModificar.add(ciclo1);
		listaCiclosModificar.add(ciclo2);
		procCiclo.modificarMultiple(listaCiclosModificar);
		for(Ciclo ciclo : listaCiclos) {
			System.out.println(ciclo + " modificado");
		}
		
		//------------------------------Asignaturas------------------------------
		Asignatura asig = new Asignatura("Acceso a datos", 160, 101);
		Asignatura asig2 = new Asignatura("Interfaces", 100, 101);
		ArrayList<Asignatura> listaAsignatura = new ArrayList<>();
		listaAsignatura.add(asig);
		listaAsignatura.add(asig2);
		AsignaturaDAO proc = new AsignaturaDAO();
		
		proc.insertar(asig);
		System.out.println(asig + " añadido");

		proc.eliminar(asig);
		System.out.println(asig + " eliminado");
		
		proc.insertarMultiple(listaAsignatura);
		for(Asignatura asignatura : listaAsignatura) {
			System.out.println(asignatura + " añadido");
		}
		
		proc.eliminarMultiple(listaAsignatura);
		for(Asignatura asignatura : listaAsignatura) {
		System.out.println(asignatura + " eliminado");
		}
		
		Asignatura asig3 = new Asignatura("Acceso a datos", 180, 7);
		proc.modificar(asig3);
		System.out.println(asig + " modificado");
		
		//------------------------------Ciclos y asignaturas------------------------------
		procCiclo.crearCicloAsignaturas(ciclo1, listaAsignatura);
		System.out.println(ciclo1);
		for(Asignatura a:listaAsignatura) {
			System.out.println(a);
		}
		
		ciclo1 = new Ciclo(101,"prueba", "medio");
		procCiclo.eliminarAsignaturasCiclo(ciclo1);
	}

}
