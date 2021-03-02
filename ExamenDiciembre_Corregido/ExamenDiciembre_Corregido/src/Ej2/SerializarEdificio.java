package Ej2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializarEdificio {

	//Crear un método para serializar un objeto Edificio dado con todos sus datos.
	// (usando ObjectStream)
	
	public void guardarEdificios(ArrayList<Edificio> edificios, String ruta) throws FileNotFoundException, IOException {
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(ruta));
		for(Edificio e: edificios) {
			oos.writeObject(e);
		}
		oos.close();
	}
	
	/*public void guardarFichero(ArrayList<Edificio> listaEdificios, String ruta) {
		File f = new File(ruta);

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			for (Edificio edificio : listaEdificios) {
				oos.writeObject(edificio);
				for(Piso piso : edificio.getListaPisos()) {
					oos.writeObject(piso);
				}
			}

			oos.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Error: El fichero no existe. ");
		} catch (IOException ioe) {
			System.out.println("Error: Fallo en la escritura en el fichero. ");
		}
	}*/
	
	
	public ArrayList<Edificio> leerEdificios(String ruta) throws FileNotFoundException, IOException {
		ObjectInputStream ois= new ObjectInputStream(new FileInputStream(ruta));
		ArrayList<Edificio> lista= new ArrayList<>();
		while(true) {
			Edificio e;
			try {
				e = (Edificio)ois.readObject();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				break;
			}
			lista.add(e);
		}
		ois.close();
		return lista;
	}
}
