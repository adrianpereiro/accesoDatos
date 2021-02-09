package datos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.configuracion.UtilHibernate;
import modelo.entidades.Autor;

public class AutorDao {
	public void insertar(Autor aut) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(aut);
		tx.commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Autor aut = (Autor)sesion.get(Autor.class, id);
		sesion.delete(aut);
		tx.commit();
		sesion.close();
	}
	
	public void modificar(Autor aut) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(aut);
		tx.commit();
		sesion.close();
	}
}
