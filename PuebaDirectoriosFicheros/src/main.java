import java.io.File;
import java.io.IOException;

public class main {

	public static void main(String[] args) {
		
		
		crearDirectorio("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Directorio1","Directorio 1");
		crearDirectorio("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Directorio2","Directorio 2");
		
		crearFichero("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Directorio1\\Fichero1.txt","Fichero 1","Directorio 1");
		crearFichero("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Directorio1\\Fichero2.txt","Fichero 2","Directorio 1");
		crearFichero("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Directorio2\\Fichero1.txt","Fichero 1","Directorio 2");
		crearFichero("C:\\Users\\PC33\\Desktop\\PruebaDirectFich\\Fichero1.txt","Fichero 1","");
		
	}
	
	private static void crearDirectorio(String ruta, String nombre) {
		File d= new File(ruta);
		if(d.exists()) {
			System.out.println("No se creo el " + nombre + " porque ya existe");
		}else {
			d.mkdir();
		}
	}
	
	private static void crearFichero(String ruta, String nombre,String nombreDir) {
		File f= new File(ruta);
		if(f.exists()) {
			if(nombreDir.isEmpty()) {
				System.out.println("No se creo el "+ nombre + " porque ya existe");
			}else {
				System.out.println("No se creo el "+ nombre + " en el " + nombreDir + " porque ya existe");
			}
		}else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
