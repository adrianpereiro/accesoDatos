package datos.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.configuracion.UtilHibernate;
import modelo.entidades.Contactousuario;

public class ContactousuarioDao {
	public void insertar(Contactousuario contacto) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(contacto);
		tx.commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Contactousuario contacto = (Contactousuario)sesion.get(Contactousuario.class, id);
		sesion.delete(contacto);
		tx.commit();
		sesion.close();
	}
	
	public void modificar(Contactousuario contacto) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(contacto);
		tx.commit();
		sesion.close();
	}
}
