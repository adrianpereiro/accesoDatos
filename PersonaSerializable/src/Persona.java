import java.io.Serializable;
import java.time.LocalDate;

public class Persona extends Main implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Nombre;
	private String Apellidos;
	private LocalDate fechaNacimiento;
	
	
	Persona(String Nombre, String Apellidos, LocalDate fechaNacimiento) {
		this.Apellidos=Apellidos;
		this.fechaNacimiento=fechaNacimiento;
		this.Nombre=Nombre;  
		
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return "Persona Nombre:" + Nombre + ", Apellidos:" + Apellidos + ", Fecha de nacimiento:" + fechaNacimiento ;
	}

	
}
