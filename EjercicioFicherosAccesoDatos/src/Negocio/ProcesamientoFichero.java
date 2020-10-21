package Negocio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import Modelo.Libro;
import Modelo.Personaje;

public abstract class ProcesamientoFichero implements IProcesamientoFichero {

	public static Boolean existeFichero(File f) {
		Boolean existe;
		if(f.exists()) {
			existe=true;
		}else {
			existe=false;
		}
		return existe;
	}

	public static Boolean borrarFichero() {
		return null;

	}

}
