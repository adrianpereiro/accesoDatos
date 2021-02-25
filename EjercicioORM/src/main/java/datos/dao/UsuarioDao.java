package datos.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.*;

import datos.configuracion.Conexion;
import modelo.entidades.Prestamo;
import modelo.entidades.Usuario;

@SuppressWarnings({ "deprecation" })
public class UsuarioDao {
	public void insertar(Usuario usuario) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(usuario);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
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
			if (t != null) {
				t.rollback();
			}
		}
	}

	public void modificar(Usuario usuario) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Usuario usuario2 = (Usuario) sesion.get(Usuario.class, usuario.getIdUsuario());
			usuario2.setNombre(usuario.getNombre());
			usuario2.setApellidos(usuario.getApellidos());
			usuario2.setContactousuario(usuario.getContactousuario());
			usuario2.setFechaNacimiento(usuario.getFechaNacimiento());
			usuario2.setPrestamos(usuario.getPrestamos());
			sesion.saveOrUpdate(usuario2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
		}
	}

	public Usuario buscar(int id) {
		Session sesion = Conexion.obtenerSesion();
		Usuario usuario = (Usuario) sesion.get(Usuario.class, id);
		sesion.close();
		return usuario;
	}

	@SuppressWarnings({ "unchecked"})
	public void buscarDNI() {
		Usuario u = new Usuario();
		try (Session sesion = Conexion.obtenerSesion()) {
			System.out.println("Introduce el DNI del usuario a buscar");
			Scanner sc = new Scanner(System.in);
			String Dni = sc.next();
			Query<Usuario> q = sesion.createQuery("FROM Usuario WHERE dni=:dniUsuario");
			q.setParameter("dniUsuario", Dni);

			u = (Usuario) q.getSingleResult();
			System.out.println("El usuario con Dni: " + Dni + " es: \n " + u);

			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void usuarios_con_prestamos() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Query<Prestamo> q = sesion.createQuery("FROM Prestamo WHERE idUsuario is not null");
			List<Prestamo> listaPrestamos = (List<Prestamo>) q.getResultList();
			for (Prestamo p : listaPrestamos) {
				System.out.println(p.getUsuario() + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void menoresEdad() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Query<Usuario> q = sesion.createQuery("FROM Usuario WHERE current_date()-FechaNAcimiento>=18");
			List<Usuario> listaUsuarios = (List<Usuario>) q.getResultList();
			for (Usuario u : listaUsuarios) {
				System.out.println(u + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
