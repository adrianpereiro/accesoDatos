package datos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.configuracion.UtilHibernate;
import modelo.entidades.Prestamo;

public class PrestamoDao {
	public void insertar(Prestamo p) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(p);
		tx.commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Prestamo p = (Prestamo)sesion.get(Prestamo.class, id);
		sesion.delete(p);
		tx.commit();
		sesion.close();
	}
	
	public void modificar(Prestamo p) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(p);
		tx.commit();
		sesion.close();
	}
}
