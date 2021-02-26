package datos.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;

@SuppressWarnings("deprecation")
public class LibroDao {
	public void insertar(Libro l) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			sesion.saveOrUpdate(l);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
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
			if (t != null) {
				t.rollback();
			}
		}
	}

	public void modificar(Libro l) {
		Transaction t = null;
		try (Session sesion = Conexion.obtenerSesion()) {
			t = sesion.beginTransaction();
			Libro l2 = (Libro) sesion.get(Libro.class, l.getCodLibro());
			l2.setAutors(l.getAutors());
			l2.setEditorial(l.getEditorial());
			l2.setEjemplars(l.getEjemplars());
			l2.setPrecio(l.getPrecio());
			l2.setTitulo(l.getTitulo());
			sesion.saveOrUpdate(l2);
			t.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null) {
				t.rollback();
			}
		}
	}

	public Libro obtenerID(int codLibro) {
		Session sesion = Conexion.obtenerSesion();
		Libro l = (Libro) sesion.get(Libro.class, codLibro);
		sesion.close();
		return l;
	}

	@SuppressWarnings("unchecked")
	public void librosPrestados() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Indica dos fechas: \nFecha 1: \n");
			String Sfecha1 = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = sdf.parse(Sfecha1);
			System.out.println("Fecha 2: \n");
			String Sfecha2 = sc.nextLine();
			Date fecha2 = sdf.parse(Sfecha2);
			
			Query<Prestamo> q = sesion.createQuery("FROM Prestamo p WHERE p.fechaPrestamo between :fecha and :fecha2");
			q.setDate("fecha", fecha);
			q.setDate("fecha2", fecha2);
			List<Prestamo> listaPrestamos = (List<Prestamo>) q.getResultList();

			for (Prestamo p : listaPrestamos) {
				Libro l = p.getEjemplar().getLibro();
				System.out.println(l + "\n");
			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public void autorLibro() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Indica el nombre del autor");
			String nombre = sc.nextLine();
			
			Query<Autor> q = sesion.createQuery("FROM Autor WHERE nombre like :nombreAutor");
			q.setParameter("nombreAutor", nombre);
			List<Autor> listaAutores = (List<Autor>) q.getResultList();
			
			for(Autor a : listaAutores) {
				Set<Libro> listaLibros = a.getLibros();
				for(Libro l : listaLibros) {
					System.out.println(l + "\n");
				}
			}
			sc.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public void precioLibro() {
		try(Session sesion = Conexion.obtenerSesion()){
			Query<Libro> q = sesion.createQuery("FROM Libro WHERE precio is null OR precio<20");
			List<Libro> listaLibros = (List<Libro>) q.getResultList();
			
			for(Libro l : listaLibros) {
				System.out.println(l + "\n");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}	

}
