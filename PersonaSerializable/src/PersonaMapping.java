import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PersonaMapping {

	public static void guardarPersonas(ArrayList<Persona> personas) {
		File f = new File("C:\\Users\\PC33\\Desktop\\Acceso a datos\\PersonasSerializable\\Personas.txt");
		try {
			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(f));
			for (Persona p : personas) {
				ficheroSalida.writeObject(p);
			}

			ficheroSalida.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}

	}

	public static ArrayList<Persona> leerFichero(ArrayList<Persona> personas) {
		File f = new File("C:\\Users\\PC33\\Desktop\\Acceso a datos\\PersonasSerializable\\Personas.txt");
		ArrayList<Persona> personas2 = new ArrayList<>();
		try {
			@SuppressWarnings("resource")
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
			for (;;) {
				Persona p = (Persona) entrada.readObject();
				personas2.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("Llego al final del fichero");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return personas2;
	}

	public static void mostrarDatos(ArrayList<Persona> personasPrint) {
		for (int a = 0; a < personasPrint.size(); a++) {
			System.out.println(personasPrint.get(a).toString());
		}
	}

}
