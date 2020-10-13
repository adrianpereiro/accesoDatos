import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		LocalDate fecha = LocalDate.of(1999, 4, 25);
		LocalDate fecha2 = LocalDate.of(1985, 1, 15);
		Persona p= new Persona("Jose","Fernandez",fecha);
		Persona p2= new Persona("Luis","Ruiz",fecha2);
		ArrayList<Persona> personas= new ArrayList<>();
		personas.add(p);
		personas.add(p2);
		PersonaMapping.guardarPersonas(personas);
		ArrayList<Persona> personas2 =PersonaMapping.leerFichero(personas);
		PersonaMapping.mostrarDatos(personas2);
		
		
	}

}
