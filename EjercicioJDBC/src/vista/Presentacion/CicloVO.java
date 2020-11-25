package vista.Presentacion;

public class CicloVO {
	private String nombre;
	private String grado;
	
	public CicloVO(String nombre, String grado) {
		this.nombre = nombre;
		this.grado = grado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "CicloVO [nombre=" + nombre + ", grado=" + grado + "]";
	}
}
