package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Libro;

public class LibroDao {
	public void insertar(Libro l) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(l);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void eliminar(String codLibro) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Libro l = (Libro) sesion.get(Libro.class, codLibro);
			sesion.delete(l);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void modificar(Libro l) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Libro l2 = (Libro)sesion.get(Libro.class, l.getCodLibro());
			l2.setAutors(l.getAutors());
			l2.setEditorial(l.getEditorial());
			l2.setEjemplars(l.getEjemplars());
			l2.setPrecio(l.getPrecio());
			l2.setTitulo(l.getTitulo());
			sesion.saveOrUpdate(l2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public Libro obtenerID(int codLibro) {
		Session sesion = Conexion.obtenerSesion();
		Libro l = (Libro) sesion.get(Libro.class, codLibro);
		sesion.close();
		return l;
	}
}
