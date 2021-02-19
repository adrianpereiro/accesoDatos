package datos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import datos.configuracion.UtilHibernate;
import modelo.entidades.Ejemplar;

public class EjemplarDao {
	public void insertar(Ejemplar e) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(e);
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
			Ejemplar e = (Ejemplar) sesion.get(Ejemplar.class, id);
			sesion.delete(e);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void modificar(Ejemplar e) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Ejemplar e2 = (Ejemplar)sesion.get(Ejemplar.class, e.getIdEjemplar());
			e2.setEstado(e.getEstado());
			e2.setLibro(e.getLibro());
			e2.setNumEjemplar(e.getNumEjemplar());
			e2.setPrestamos(e.getPrestamos());
			sesion.saveOrUpdate(e2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public Ejemplar buscar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Ejemplar e = (Ejemplar) sesion.get(Ejemplar.class, id);
		sesion.close();
		return e;
	}
}
