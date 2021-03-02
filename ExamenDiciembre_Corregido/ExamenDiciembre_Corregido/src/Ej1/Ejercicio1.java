package Ej1;

import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ProcesamientoFichero pr= new ProcesamientoFichero();
			try {
				pr.procesarFichero("src\\Ej1\\Carta.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
