package vista.vo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import datos.dao.AutorDao;
import datos.dao.LibroDao;
import datos.dao.UsuarioDao;
import modelo.entidades.Autor;
import modelo.entidades.Libro;
import modelo.entidades.Usuario;

public class Ejercicio {

	public static void main(String[] args) {
		Libro l = new Libro("1", "ola que tal", "folja", 20);
		LibroDao lDao = new LibroDao();
		lDao.insertar(l);
		
		Autor a = new Autor(0, "Juan", "Gadid", null);
		AutorDao aDao = new AutorDao();
		aDao.insertar(a);
		
		l.getAutors().add(l);
		
		LocalDate localDate = LocalDate.of(2016, 8, 19);
		Date current = new java.sql.Date(new java.util.Date().getTime());
		Usuario u = new Usuario("a", "d", current);
		UsuarioDao uDao = new UsuarioDao();
		uDao.insertar(u);
	}

}
