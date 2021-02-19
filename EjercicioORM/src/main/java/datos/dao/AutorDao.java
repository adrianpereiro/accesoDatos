package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;

public class AutorDao {
	Transaction t = null;

	public void insertar(Autor aut) {
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(aut);
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
			Autor aut = (Autor) sesion.get(Autor.class, id);
			sesion.delete(aut);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void modificar(Autor aut) {
		try (Session sesion = Conexion.obtenerSesion()) {
			Transaction t = sesion.beginTransaction();
			Autor a2 =(Autor)sesion.get(Autor.class, aut.getIdAutor());
			a2.setNombre(aut.getNombre());
			a2.setApellidos(aut.getApellidos());
			a2.setLibros(aut.getLibros());
			sesion.saveOrUpdate(a2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public Autor buscar(int id) {
		Session sesion = Conexion.obtenerSesion();
		Autor aut = (Autor) sesion.get(Autor.class, id);
		sesion.close();
		return aut;
	}

}
