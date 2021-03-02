package Ej7;

public class ResultadoProcesamiento {
	//Clase para modelizar el resultado de la llamada al procedimiento
	//Podéis hacer propiedades públicas para facilitar su llamada.
	public String autor;
	public String  titulo;
	public String  genero;
	public String  editorial;
	@Override
	public String toString() {
		return "ResultadoProcesamiento [autor=" + autor + ", titulo=" + titulo + ", genero=" + genero + ", editorial="
				+ editorial + "]";
	}
}
