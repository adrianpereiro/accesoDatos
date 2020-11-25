package vista.Presentacion;

public class AsignaturaVO {
	private String nombre;
	private int horasSemanales;
	private int idCiclo;

	public AsignaturaVO(String nombre, int horasSemanales, int idCiclo) {
		this.nombre = nombre;
		this.horasSemanales = horasSemanales;
		this.idCiclo = idCiclo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getHorasSemanales() {
		return horasSemanales;
	}
	
	public void setHorasSemanales(int horasSemanales) {
		this.horasSemanales = horasSemanales;
	}
	
	public int getIdCiclo() {
		return idCiclo;
	}
	
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}

	@Override
	public String toString() {
		return "AsignaturaVO [nombre=" + nombre + ", horasSemanales=" + horasSemanales + ", idCiclo="
				+ idCiclo + "]";
	}
}
