package Negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Libro;

public class ProcesamientoFicheroXMLDOM extends ProcesamientoFichero{

	@Override
	public ArrayList<Libro> leerFichero() {
		try {
		ArrayList<Libro> listaLibros= new ArrayList<>();
		File f = new File("");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(f);
			NodeList nodeList = document.getDocumentElement().getChildNodes();
			
			for(int i=0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element elemnt = (Element) node;
				
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		// TODO Auto-generated method stub
		
	}

}
