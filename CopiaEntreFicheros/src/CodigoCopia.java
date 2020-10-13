import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class CodigoCopia {

	public static File abrirFichero(String rutaOrigen) {
		File f= new File(rutaOrigen);
		if(f.exists()) {
			JOptionPane.showMessageDialog(null, "El primer fichero existe");
		}else {
			JOptionPane.showMessageDialog(null, "El primer fichero no existe","Error primer fichero", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		return f;
	}
	
	public static File crearFichero(String ruta, String nombre) {
		File f= new File(ruta);
		if(f.exists()) {
			JOptionPane.showMessageDialog(null, "No se creo el "+ nombre + " porque ya existe esa dirección", "Error al crear el fichero", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}else {
			try {
				f.createNewFile();
				JOptionPane.showMessageDialog(null, "Fichero creado correctamente");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return f;
	}
	
	public static void copiarFichero(File f1, File f2, String codDestino) {
		try {
			int a;
			FileInputStream input = new FileInputStream(f1); //abre un canal de conexion con el archivo del que copiar
			InputStreamReader lectura = new InputStreamReader(input,StandardCharsets.UTF_8);
			BufferedReader br= new BufferedReader(lectura); 
			FileOutputStream output = new FileOutputStream(f2); //abre un canal de conexion con el archivo en el que copiar 
			OutputStreamWriter escritura = new OutputStreamWriter(output,codDestino);
			BufferedWriter bw = new BufferedWriter(escritura);
			
			while((a = br.read()) != -1) { //lectura.read devuelve un -1 cuando no hay nada mas que leer en el archivo f1
				bw.write(a); 	//escribe en el archivo que conecta a traves del canal 'output', es decir f2
			}
			
			bw.close();
			escritura.close();
			lectura.close();
			output.close();
			br.close();
			lectura.close();
			input.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
