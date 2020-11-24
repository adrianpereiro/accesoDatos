package datos;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ICicloDAO;
import modelo.Entidades.Asignatura;
import modelo.Entidades.Ciclo;

public class CicloDAO implements ICicloDAO {

	@Override
	public void insertar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO ciclo (nombre, grado) " + "VALUES (?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			ciclo.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);
		
	}

	@Override
	public void insertarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO ciclo (nombre, grado) " + "VALUES (?,?);";

		try {
			PreparedStatement ps = con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
			for (Ciclo ciclo : listaCiclos) {

				ps.setString(1, ciclo.getNombre());
				ps.setString(2, ciclo.getGrado());
				ps.addBatch();
			}
			ps.executeBatch();
			ResultSet rs = ps.getGeneratedKeys();
			int i = 0;
			while (rs.next()) {
				int id = rs.getInt(1);
				listaCiclos.get(i).setId(id);
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		conexion.cerrarConexion(con);

	}

	@Override
	public void eliminar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM ciclo WHERE (id = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			ps.setInt(1, ciclo.getId());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ciclo.toString() + " eliminado");
		conexion.cerrarConexion(con);

	}

	@Override
	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String eliminar = "DELETE FROM ciclo WHERE (id = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(eliminar);
			for (Ciclo ciclo : listaCiclos) {
				ps.setInt(1, ciclo.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);

	}

	@Override
	public void modificar(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String modificar = "UPDATE ciclo SET nombre = ?, grado = ? WHERE id = ?;";

		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			ps.setInt(3, ciclo.getId());
			
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrarConexion(con);

	}

	@Override
	public void modificarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String modificar = "UPDATE ciclo SET nombre = ?, grado = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(modificar);
			for (Ciclo ciclo : listaCiclos) {
				ps.setString(1, ciclo.getNombre());
				ps.setString(2, ciclo.getGrado());
				ps.setInt(3, ciclo.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conexion.cerrarConexion(con);

	}

	@Override
	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();

		String insertar = "INSERT INTO ciclo (nombre, grado) " + "VALUES (?,?);";
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(insertar, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int idCiclo = rs.getInt(1);
			ciclo.setId(idCiclo);

			String insertarAsignatura = "INSERT INTO asignatura (nombre, horas, idCiclo) " + "VALUES (?,?,?);";

			PreparedStatement ps2 = con.prepareStatement(insertarAsignatura, Statement.RETURN_GENERATED_KEYS);
			for (Asignatura asignatura : listaAsignaturas) {
				asignatura.setIdCiclo(idCiclo);
				ps2.setString(1, asignatura.getNombre());
				ps2.setInt(2, asignatura.getHorasSemanales());
				ps2.setInt(3, idCiclo);
				ps2.addBatch();
			}
			ps2.executeBatch();
			
			ResultSet rs2 = ps2.getGeneratedKeys();

			int i = 0;
			while (rs2.next()) {
				int idAsignatura = rs2.getInt(1);
				listaAsignaturas.get(i).setId(idAsignatura);
				i++;
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		conexion.cerrarConexion(con);

	}
	public void eliminarAsignaturasCiclo(Ciclo ciclo) {
		ConexionMySQL conexion = new ConexionMySQL();
		Connection con = conexion.creacionConexion();
		
		try {
			CallableStatement st = con.prepareCall("{ call eliminarAsignaturasCiclo(?) }");
			st.setInt(1, ciclo.getId());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}