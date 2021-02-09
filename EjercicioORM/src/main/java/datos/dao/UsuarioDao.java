package datos.dao;

import org.hibernate.*;


import datos.configuracion.UtilHibernate;
import modelo.entidades.Usuario;

public class UsuarioDao {
	public void insertar(Usuario usuario) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(usuario);
		tx.commit();
		sesion.close();
	}
	
	public void eliminar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		Usuario usuario = (Usuario)sesion.get(Usuario.class, id);
		sesion.delete(usuario);
		tx.commit();
		sesion.close();
	}
	
	public void modificar(Usuario usuario) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Transaction tx = sesion.beginTransaction();
		sesion.saveOrUpdate(usuario);
		tx.commit();
		sesion.close();
	}
	
	public Usuario buscar(int id) {
		SessionFactory sf = UtilHibernate.getSessionFactory();
		Session sesion = sf.openSession();
		Usuario usuario = (Usuario)sesion.get(Usuario.class, id);
		sesion.close();
		return usuario;
	}
}
