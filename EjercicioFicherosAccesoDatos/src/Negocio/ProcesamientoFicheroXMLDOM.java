package Negocio;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import Modelo.Personaje;

public class ProcesamientoFicheroXMLDOM extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero() {
		ArrayList<Libro> listaLibros = new ArrayList<>();
		try {
			ArrayList<Personaje> listaPersonajes = new ArrayList<>();
			File f = new File("C:\\Users\\PC33\\Desktop\\xmlLibros.txt");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(f);
			NodeList nodeList = document.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element libro = (Element) node;
					String titulo = libro.getElementsByTagName("Titulo").item(0).getChildNodes().item(0).getNodeValue();
					String editorial = libro.getElementsByTagName("Editorial").item(0).getChildNodes().item(0)
							.getNodeValue();
					String autor = libro.getElementsByTagName("Autor").item(0).getChildNodes().item(0).getNodeValue();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaPublicacion = LocalDate.parse((libro.getElementsByTagName("FechaDePublicacion")
							.item(0).getChildNodes().item(0).getNodeValue()), formatter);
					String genero = libro.getElementsByTagName("Genero").item(0).getChildNodes().item(0).getNodeValue();
					String nombre;
					String importancia;
					Element personajes = (Element) libro.getElementsByTagName("PersonajesPrincipales").item(0);
					if (personajes != null) {
						NodeList nodePersonaje = personajes.getChildNodes();
						for (int x = 0; x < nodePersonaje.getLength(); x++) {
							Node nodePers = nodePersonaje.item(x);
							if (nodePers.getNodeType() == Node.ELEMENT_NODE) {
							Element personaje = (Element) nodePers;

							nombre = personaje.getElementsByTagName("Nombre").item(0).getChildNodes().item(0)
									.getNodeValue();
							importancia = personaje.getElementsByTagName("Importancia").item(0).getChildNodes().item(0)
									.getNodeValue();
							Personaje p = new Personaje(nombre, importancia);
							listaPersonajes.add(p);
							}
						}
						Libro l = new Libro(titulo, editorial, autor, fechaPublicacion, genero, listaPersonajes);
						listaLibros.add(l);
					}

				}

			}
		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}
		return listaLibros;
	}

	@Override
	public void guardarFichero(ArrayList<Libro> listaLibros) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc =dBuilder.newDocument();
			Element rootElement = doc.createElementNS(null, "Libros");
			doc.appendChild(rootElement);
			
			for(Libro l:listaLibros) {
				Element libro = doc.createElement("Libro");
				Element node = doc.createElement("Titulo");
				node.appendChild(doc.createTextNode(l.getTituloLibro()));
				libro.appendChild(node);
				node = doc.createElement("Editorial");
				node.appendChild(doc.createTextNode(l.getEditorial()));
				libro.appendChild(node);
				
				node = doc.createElement("Autor");
				node.appendChild(doc.createTextNode(l.getAutor()));
				libro.appendChild(node);
				
				node = doc.createElement("FechaPublicacion");
				node.appendChild(doc.createTextNode(l.getFechaPublicacion().toString()));
				libro.appendChild(node);
				
				node = doc.createElement("Genero");
				node.appendChild(doc.createTextNode(l.getGenero()));
				libro.appendChild(node);
				
				
				Element personajesPrincipales = doc.createElement("PersonajesPrincipales");
				libro.appendChild(personajesPrincipales);
				ArrayList<Personaje> listaPersonajes = new ArrayList<>();
				for(Personaje p:listaPersonajes) {
					Element personaje = doc.createElement("Personaje");
					personajesPrincipales.appendChild(personaje);
					
					node = doc.createElement("Nombre");
					node.appendChild(doc.createTextNode(p.getNombre()));
					personaje.appendChild(node);
					
					node = doc.createElement("Importancia");
					node.appendChild(doc.createTextNode(p.getImportancia()));
					personaje.appendChild(node);
					
				}
				
			}
		
		}catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
