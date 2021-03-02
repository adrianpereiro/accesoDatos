package Ej4;

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

public class ProcesamientoDOM {

	//Método que llamará a obtenerDatos e imprimirá los objetos por pantalla
	public void procesarEImprimir() {
		String ruta="src\\Ej4\\ListadoEdificios.xml";
		try {
			ArrayList<Edificio> datos = obtenerDatos(ruta);
			for(Edificio e:datos) {
				System.out.println(e);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//procesarEImprimir
	
	//Método de obtención de los datos del xml mediante DOM y construcción del listado
	private ArrayList<Edificio> obtenerDatos(String ruta) throws ParserConfigurationException, SAXException, IOException{
		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();

		// Creación del builder de XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		NodeList nodeList;

		builder = factory.newDocumentBuilder();
		document = builder.parse(new File(ruta));
		nodeList = document.getDocumentElement().getChildNodes();
		// Recorrido del documento
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				// Obtención de los elementos del XML
				Element elEdificio = (Element) nNode;
				String id = elEdificio.getElementsByTagName("id").item(0).getTextContent();
				String calle = elEdificio.getElementsByTagName("calle").item(0).getTextContent();
				String poblacion = elEdificio.getElementsByTagName("poblacion").item(0).getTextContent();
				String cp = elEdificio.getElementsByTagName("cp").item(0).getTextContent();
				Node pisos = elEdificio.getElementsByTagName("pisos").item(0);
				Edificio e = null;
				ArrayList<Piso> listaPisos= new ArrayList<Piso>();
				if (pisos != null) {
					NodeList nodeListPisos= pisos.getChildNodes();
					for (int j = 0; j < nodeListPisos.getLength(); j++) {
						Node nNodePiso = nodeListPisos.item(j);
						if (nNodePiso.getNodeType() == Node.ELEMENT_NODE) {
							Element elPiso = (Element) nNodePiso;
							String idP = elPiso.getElementsByTagName("id").item(0).getTextContent();
							String numeroP = elPiso.getElementsByTagName("numero").item(0).getTextContent();
							String puertaP = elPiso.getElementsByTagName("puerta").item(0).getTextContent();
							String metrP = elPiso.getElementsByTagName("m2").item(0).getTextContent();
							Piso p= new Piso(Integer.parseInt(idP), Integer.parseInt(numeroP), puertaP,Integer.parseInt(metrP));
							listaPisos.add(p);
						}
					}
				}
				Edificio as = new Edificio(Integer.parseInt(id), calle, poblacion, Integer.parseInt(cp), listaPisos);
				listaEdificios.add(as);
			}
		}

		return listaEdificios;
	}
	
	
	
	//TEORIA
	//Indica si para lectura de XML el método de procesamiento por DOM es el más idóneo y por qué
	
	
	
}//ProcesamientoDOM
