package vista.vo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import datos.dao.AutorDao;
import datos.dao.ContactousuarioDao;
import datos.dao.LibroDao;
import datos.dao.UsuarioDao;
import modelo.entidades.Autor;
import modelo.entidades.Contactousuario;
import modelo.entidades.Libro;
import modelo.entidades.Usuario;

public class Ejercicio {

	public static void main(String[] args) {
/*		Ejercicio 7.1
 		Libro l = new Libro("1", "ola que tal", "folja", 20);
		LibroDao lDao = new LibroDao();
		lDao.insertar(l);
		Autor a = new Autor(0, "Juan", "Gadid", null);
		AutorDao aDao = new AutorDao();
		aDao.insertar(a);
		
		l.getAutors().add(l);
*/
		
/*		Ejercicio 7.2
		Libro l = new Libro("1", "ola que tal", "folja", 20);
		LibroDao lDao = new LibroDao();
		lDao.insertar(l);
		
		lDao.eliminar("1");
		
		lDao.eliminar("1");
 */
/* 		Ejercicio 7.3 a
		Date current = new java.sql.Date(new java.util.Date().getTime());
		Usuario u = new Usuario("Adrian", "Pereiro Miguel", current);
		Contactousuario cu = new Contactousuario(u, "a@g.com");
		UsuarioDao uDao = new UsuarioDao();
		uDao.insertar(u);
		ContactousuarioDao cuDao = new ContactousuarioDao();
		cuDao.insertar(cu);
*/
/* 		Ejercicio 7.3 b
		UsuarioDao uDao = new UsuarioDao();
		uDao.eliminar(8);
*/
	}

}
