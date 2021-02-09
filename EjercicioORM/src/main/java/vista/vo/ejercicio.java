package vista.vo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import modelo.entidades.Usuario;

public class ejercicio {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2016, 8, 19);
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = format.format( new Date()   );
		Date date = format.parse("2009-12-31");   
		Usuario u = new Usuario("a", "d", date);

	}

}
