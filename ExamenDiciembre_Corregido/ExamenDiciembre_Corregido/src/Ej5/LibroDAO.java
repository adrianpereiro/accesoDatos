package Ej5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibroDAO {
	private Connection obtenerConexion() throws SQLException, ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3306/examendiciembredam";
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}

	// leer libros por autor

	public ArrayList<Libro> leerLibro(String nombreAutor) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		String consulta = "Select Libro.id, titulo, anho_publicacion,genero,editorial_id,autor_id "
				+ "from Libro inner join Autor on Libro.autor_id=Autor.id where Autor.nombre=? ";
		PreparedStatement ps = con.prepareStatement(consulta);
		ps.setString(1, nombreAutor);
		ResultSet rs = ps.executeQuery();

		ArrayList<Libro> lista = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt(1);
			String titulo = rs.getString(2);
			int anho = rs.getInt(3);
			String genero = rs.getString(4);
			int editorialId = rs.getInt(5);
			int autorId = rs.getInt(6);

			Libro l = new Libro(id, titulo, genero, anho, editorialId, autorId);
			lista.add(l);
		}
		return lista;
	}// leerLibro

	// leer todos los libros
	public ArrayList<Libro> leerLibros() throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		String consulta = "Select Libro.id, titulo, anho_publicacion,genero,editorial_id,autor_id from Libro ";
		PreparedStatement ps = con.prepareStatement(consulta);
		ResultSet rs = ps.executeQuery();

		ArrayList<Libro> lista = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt(1);
			String titulo = rs.getString(2);
			int anho = rs.getInt(3);
			String genero = rs.getString(4);
			int editorialId = rs.getInt(5);
			int autorId = rs.getInt(6);

			Libro l = new Libro(id, titulo, genero, anho, editorialId, autorId);
			lista.add(l);
		}
		return lista;
	}

	// insertar libros por lotes

	public void insertarLibros(ArrayList<Libro> libros) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		String consulta = "INSERT INTO Libro (titulo,genero,anho_publicacion,editorial_id,autor_id) VALUES (?,?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);

		for (Libro l : libros) {
			ps.setString(1, l.getTitulo());
			ps.setString(2, l.getGenero());
			ps.setInt(3, l.getAnho_publicacion());
			ps.setInt(4, l.getEditorial_id());
			ps.setInt(5, l.getAutor_id());
			ps.addBatch();
		}
		ps.executeBatch();

		ResultSet rs = ps.getGeneratedKeys();
		int cont = 0;
		while (rs.next()) {
			int id = rs.getInt(1);
			libros.get(cont).setId(id);
			cont++;
		}
	}

	// modificar libro y autor

	public void modificarLibro(Libro libro, Autor autor) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		try {
			con.setAutoCommit(false);

			String consulta = "UPDATE Libro set titulo=?,genero=?,anho_publicacion=?,editorial_id=?,autor_id=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(consulta);

			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getGenero());
			ps.setInt(3, libro.getAnho_publicacion());
			ps.setInt(4, libro.getEditorial_id());
			ps.setInt(5, libro.getAutor_id());
			ps.setInt(6, libro.getId());

			ps.execute();

			consulta = "UPDATE Autor set nombre=?,apellido=? WHERE id=?";
			ps = con.prepareStatement(consulta);
			ps.setString(1, autor.getNombre());
			ps.setString(2, autor.getApellido());
			ps.setInt(3, autor.getId());
			ps.execute();

			con.commit();
		} catch (SQLException ex) {
			con.rollback();
		} finally {
			con.close();
		}
	}

	// borrar libro (solo el libro, si puede)

	public void borrarLibro(Libro libro) throws ClassNotFoundException, SQLException {
		Connection con = obtenerConexion();
		try {
			String consulta = "DELETE FROM Libro WHERE id=?";
			PreparedStatement ps = con.prepareStatement(consulta);
			ps.setInt(1, libro.getId());
			ps.execute();
		}
		finally {
			con.close();
		}
	}

}// LibroDAO
