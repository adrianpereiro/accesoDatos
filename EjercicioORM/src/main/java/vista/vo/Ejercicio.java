package vista.vo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import datos.dao.AutorDao;
import datos.dao.ContactousuarioDao;
import datos.dao.EjemplarDao;
import datos.dao.LibroDao;
import datos.dao.PrestamoDao;
import datos.dao.UsuarioDao;
import modelo.entidades.Autor;
import modelo.entidades.Contactousuario;
import modelo.entidades.Ejemplar;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;
import modelo.entidades.Usuario;

@SuppressWarnings("unused")
public class Ejercicio {

	public static void main(String[] args) {
/*		Ejercicio 7.1
 		Libro l = new Libro("1", "ola que tal", "folja", 20);
		LibroDao lDao = new LibroDao();
		lDao.insertar(l);
		Autor a = new Autor(0, "Juan", "Gadid", null);
		AutorDao aDao = new AutorDao();
		aDao.insertar(a);
		
		a.getLibros().add(l);
		
		aDao.modificar(a);
*/		
		
/*	Ejercicio 7.2
		Libro l = new Libro("1", "ola que tal", "folja", 20);
		LibroDao lDao = new LibroDao();
		
		EjemplarDao eDao = new EjemplarDao();
		Ejemplar e = new Ejemplar(1, l, 2, "ASFASFD");
		
		eDao.insertar(e);
		
		lDao.eliminar("1");
*/
		
/*		Ejercicio 7.3 a
		Date current = new java.sql.Date(new java.util.Date().getTime());
		Usuario u = new Usuario("Adrian", "Pereiro Miguel", current, "54131324L");
		Contactousuario cu = new Contactousuario(u, "a@g.com");
		UsuarioDao uDao = new UsuarioDao();
		uDao.insertar(u);
		ContactousuarioDao cuDao = new ContactousuarioDao();
		cuDao.insertar(cu);
*/

/* 		Ejercicio 7.3 b
		UsuarioDao uDao = new UsuarioDao();
		uDao.eliminar(12);
*/
		
/*		Ejercicio 7.4 
		Date current = new java.sql.Date(new java.util.Date().getTime());
		Usuario u = new Usuario("Adrian", "Pereiro Miguel", current);
		UsuarioDao uDao = new UsuarioDao();
		
		Contactousuario cu = new Contactousuario(u, "a@g.com");
		ContactousuarioDao cuDao = new ContactousuarioDao();

		Libro l = new Libro("10", "Un titulo", "Una editoral", (float)20);
		LibroDao lDao = new LibroDao();
		
		Ejemplar e = new Ejemplar(1, l, 1, "estado");
		EjemplarDao eDao = new EjemplarDao();
		
		Date datePrestamo = new java.sql.Date(2021, 1, 10);
		Prestamo p =  new Prestamo(e, u, datePrestamo, current);
		PrestamoDao pDao = new PrestamoDao();
		
		uDao.insertar(u);
		cuDao.insertar(cu);
		lDao.insertar(l);
		eDao.insertar(e);
		pDao.insertar(p);
		
		Date current = new java.sql.Date(new java.util.Date().getTime());
		PrestamoDao pDao = new PrestamoDao();
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.buscar(11);
		Set<Prestamo> listaPrestamos =  u.getPrestamos();
		for(Prestamo p : listaPrestamos) {
			p.setFechaPrestamo(current);
			pDao.modificar(p);
		}
*/		
		UsuarioDao uDao = new UsuarioDao();
/*		Ejercicio 8.1
		uDao.buscarDNI();
*/

/*		Ejercicio 8.2
		uDao.usuarios_con_prestamos();
*/
/*		Ejercicio 8.3		
		uDao.menoresEdad();
*/	
		
		LibroDao lDao = new LibroDao();
		
/*		Ejercicio 8.4
		lDao.librosPrestados();
*/
/*		Ejercicio 8.5
		 lDao.autorLibro();
*/
/*		Ejercicio 8.6
		lDao.precioLibro();
*/
	}

}
