package Negocio;

import java.io.File;

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
