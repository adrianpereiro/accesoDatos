package Ej2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializarEdificio ser= new SerializarEdificio();
		String ruta="src\\Ej2\\Edificios2.bin";
		ArrayList<Edificio> edificios= new ArrayList<Edificio>();
		ArrayList<Piso> pisos= new ArrayList<Piso>();
		pisos.add(new Piso(1,12,"A",2));
		pisos.add(new Piso(2,124,"B",2));
		pisos.add(new Piso(3,130,"C",2));
		Edificio ed1= new Edificio(1, "Barcelona", "Coruña ", 15008, pisos);
		Edificio ed2= new Edificio(2, "Pontevedra", "Coruña ", 15003, new ArrayList<>());
		edificios.add(ed1);
		edificios.add(ed2);
		
		
		
		try {
			ser.guardarEdificios(edificios, ruta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		ArrayList<Edificio> leidos= null;
		try {
			leidos = ser.leerEdificios(ruta);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Edificio e:leidos) {
			System.out.println(e);
		}
	}

}
