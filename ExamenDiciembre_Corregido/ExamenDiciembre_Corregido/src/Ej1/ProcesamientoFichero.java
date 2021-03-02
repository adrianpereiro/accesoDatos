package Ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesamientoFichero {

	// Crear un método que, recibiendo una ruta de un fichero, sustituya el caracter
	// ; por el caracter . y guarde el resultado en otro fichero con mismo nombre
	// pero terminado en _mod por ejemplo Carta.txt -> Carta.txt_mod
	public void procesarFichero(String ruta) throws IOException {
		
		File f= new File(ruta);
		if(f.exists()) {
			File f2= new File(ruta+"_mod");
			FileReader fr= new FileReader(f);
			FileWriter fw= new FileWriter(f2);
			int car;
			while((car=fr.read())!=-1) {
				System.out.println("Caracter "+ car + (char)car);
				if(car==59) {
					car=46;
				}
				fw.write(car);
				
			}
			f.getName();
			fw.close();
			fr.close();
			
		}else {
			System.out.println("El fichero "+ ruta + " no existe");
		}
		
	}
}
