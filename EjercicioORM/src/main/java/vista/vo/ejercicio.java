package vista.vo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import datos.dao.UsuarioDao;
import modelo.entidades.Usuario;

public class ejercicio {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2016, 8, 19);
		Date current = new java.sql.Date( new java.util.Date().getTime());
		Usuario u = new Usuario("a", "d", current);
		UsuarioDao uDao = new UsuarioDao();
		uDao.insertar(u);
	}

}
