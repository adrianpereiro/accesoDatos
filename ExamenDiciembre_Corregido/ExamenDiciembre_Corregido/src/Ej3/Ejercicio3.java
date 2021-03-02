package Ej3;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;


public class Ejercicio3 {

	public static void main(String[] args) {
		ProcesamientoXML pro= new ProcesamientoXML();
		
		String ruta="src\\Ej3\\JAXB.xml";
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
			pro.escribirJAXB(edificios, ruta);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ArrayList<Edificio> edificiosLeidos= pro.leerJAXB(ruta);
			for(Edificio e: edificiosLeidos) {
				System.out.println(e);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
