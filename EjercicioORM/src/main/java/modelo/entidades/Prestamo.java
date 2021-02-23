package modelo.entidades;
// default package
// Generated 2 feb. 2021 13:38:13 by Hibernate Tools 5.2.12.Final

import java.util.Date;

/**
 * Prestamo generated by hbm2java
 */
public class Prestamo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPrestamo;
	private Ejemplar ejemplar;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;

	public Prestamo() {
	}

	public Prestamo(Ejemplar ejemplar, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
		this.ejemplar = ejemplar;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Integer getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Ejemplar getEjemplar() {
		return this.ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return this.fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

}
