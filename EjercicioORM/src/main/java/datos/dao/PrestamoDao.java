package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Prestamo;

public class PrestamoDao {
	public void insertar(Prestamo p) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(p);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void eliminar(int id) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Prestamo p = (Prestamo) sesion.get(Prestamo.class, id);
			sesion.delete(p);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void modificar(Prestamo p) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Prestamo p2 =(Prestamo)sesion.get(Prestamo.class, p.getIdPrestamo());
			p2.setEjemplar(p.getEjemplar());
			p2.setFechaDevolucion(p.getFechaDevolucion());
			p2.setFechaPrestamo(p.getFechaPrestamo());
			p2.setUsuario(p.getUsuario());
			sesion.saveOrUpdate(p2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public Prestamo buscar(int id) {
		Session sesion = Conexion.obtenerSesion();
		Prestamo p = (Prestamo) sesion.get(Prestamo.class, id);
		sesion.close();
		return p;
	}
}
