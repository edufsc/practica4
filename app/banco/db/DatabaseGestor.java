package app.banco.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import app.banco.entidades.Gestor;

public class DatabaseGestor {

	private Connection conexion;

	// al conectar la base de datos en el constructor (como atributo),
	// la podemos utilizar desde todos los métodos de la clase
	public DatabaseGestor() {
		this.conexion = new DatabaseConnection().getConexion();
	}

	// si inserta el gestor devuelve true, si no, false
	public boolean insertarGestor(Gestor gestor) {
		PreparedStatement instruccion = null;
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.prepareStatement("INSERT INTO gestor(usuario, password, correo) VALUES (?,?,?)");
			instruccion.setString(1, gestor.getUsuario());

			// se sustituye la segunda aparición del carácter ? con el valor gestor10
			instruccion.setString(2, gestor.getPassword());
			// lo mismo, pero cifrando la contraseña
			// ps.setString(2, Criptografia.SHA3(gestor.getPassword()));

			// se sustituye la tercera aparición del carácter ? con el valor
			// gestor10@correo.com
			instruccion.setString(3, gestor.getCorreo());

			// ejecuta sentencia SQL
			instruccion.executeUpdate();

			// cierra la sentencia
			instruccion.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	// obtener todos los gestores como lista de Gestor
	public ArrayList<Gestor> getGestores() {
		Statement instruccion = null;
		ArrayList<Gestor> gestores = new ArrayList<Gestor>();
		try {
			// obtiene un objeto de tipo Statement
			instruccion = conexion.createStatement();
			// ejecuta sentencia SQL
			ResultSet resultados = instruccion.executeQuery("SELECT * from gestor");
			while (resultados.next()) {
				int id = resultados.getInt("id");
				String usuario = resultados.getString("usuario");
				String password = resultados.getString("password");
				String correo = resultados.getString("correo");
				Gestor gestor = new Gestor(id, usuario, password, correo);
				gestores.add(gestor);
			}
			// cierra la sentencia
			instruccion.close();
			return gestores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	// obtener un gestor por id como Gestor
	public Gestor getGestor(int id) {
		// fuera del try para poder cerrarla en finally
		PreparedStatement instruccion = null;
		Gestor gestor = null;
		try {
			String query = "SELECT * FROM gestor WHERE id = ?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);

			ResultSet resultados = instruccion.executeQuery();
			// next() devuelve true si hay fila para leer,
			if (resultados.next()) {
				gestor = new Gestor();
				gestor.setId(resultados.getInt("id"));
				gestor.setUsuario(resultados.getString("usuario"));
				gestor.setPassword(resultados.getString("password"));
				gestor.setCorreo(resultados.getString("correo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// si no había gestor en BD, gestor es null
		return gestor;
	}

	// si elimina el gestor devuelve true, si no, false
	public boolean borrarGestor(int id) {
		PreparedStatement instruccion = null;
		try {
			String query = "DELETE FROM gestor WHERE id = ?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setInt(1, id);
			int filasBorradas = instruccion.executeUpdate();
			return filasBorradas != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	// si actualiza el gestor devuelve true, si no, false
	public boolean actualizarGestor(Gestor gestor) {
		PreparedStatement instruccion = null;
		try {
			String query = "UPDATE gestor SET usuario = ?, password = ?, correo = ? WHERE id = ?";
			instruccion = conexion.prepareStatement(query);
			instruccion.setString(1, gestor.getUsuario());
			instruccion.setString(2, gestor.getPassword());
			instruccion.setString(3, gestor.getCorreo());
			instruccion.setInt(4, gestor.getId());
			int filasActualizadas = instruccion.executeUpdate();
			return filasActualizadas != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (instruccion != null) {
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
