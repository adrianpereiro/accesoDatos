package Negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Modelo.Libro;
import Modelo.LibroJAXB;

public class ProcesamientoFicheroXMLJAXB extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		String ruta = "";
		File f = new File(ruta);
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		if (ProcesamientoFichero.existeFichero(f) == false) {
			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(LibroJAXB.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				LibroJAXB libros = (LibroJAXB) jaxbUnmarshaller.unmarshal(f);
				listaLibros = (libros != null ? libros.getListaLibros() : new ArrayList<>());

			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Fichero no encontrado");
		}
		return listaLibros;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		File f = new File("C:\\Users\\PC33\\Desktop\\xmlJAXBLibros.txt");
		try {
			if (ProcesamientoFichero.existeFichero(f) == false) {
				f.createNewFile();
			}
			JAXBContext jaxbContext;

			jaxbContext = JAXBContext.newInstance(LibroJAXB.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			LibroJAXB l = new LibroJAXB();
			l.setListaLibros(listaLibros);
			jaxbMarshaller.marshal(l, f);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
