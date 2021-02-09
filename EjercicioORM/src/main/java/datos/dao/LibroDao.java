package datos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.configuracion.UtilHibernate;
import modelo.entidades.Contactousuario;
import modelo.entidades.Libro;

public class LibroDao {
	public void insertar(Libro l) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(l);
		tx.commit();
		sesion.close();
	}
	
	public void eliminar(int codLibro) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Libro l = (Libro)sesion.get(Libro.class, codLibro);
		sesion.delete(l);
		tx.commit();
		sesion.close();
	}
	
	public void modificar(Libro l) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(l);
		tx.commit();
		sesion.close();
	}
	
	public Libro buscar(int codLibro) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Libro l = (Libro)sesion.get(Libro.class, codLibro);
		sesion.close();
		return l;
	}
}