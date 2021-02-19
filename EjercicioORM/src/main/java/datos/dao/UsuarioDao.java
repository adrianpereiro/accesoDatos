package datos.dao;

import org.hibernate.*;

import datos.configuracion.Conexion;
import modelo.entidades.Usuario;

public class UsuarioDao {
	public void insertar(Usuario usuario) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(usuario);
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
			Usuario usuario = (Usuario) sesion.get(Usuario.class, id);
			sesion.delete(usuario);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();}
		}
	}

	public void modificar(Usuario usuario) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Usuario usuario2 = (Usuario)sesion.get(Usuario.class,usuario.getIdUsuario());
			usuario2.setNombre(usuario.getNombre());
			usuario2.setApellidos(usuario.getApellidos());
			usuario2.setContactousuario(usuario.getContactousuario());
			usuario2.setFechaNacimiento(usuario.getFechaNacimiento());
			usuario2.setPrestamos(usuario.getPrestamos());
			sesion.saveOrUpdate(usuario2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {t.rollback();
			}
		}
	}

	public Usuario buscar(int id) {
		Session sesion = Conexion.obtenerSesion();
		Usuario usuario = (Usuario) sesion.get(Usuario.class, id);
		sesion.close();
		return usuario;
	}
}
