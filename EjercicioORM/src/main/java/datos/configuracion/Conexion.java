package datos.configuracion;

import org.hibernate.Session;

public class Conexion {
	public static Session obtenerSesion() {
		return UtilHibernate.getSessionFactory().openSession();
	}
}
