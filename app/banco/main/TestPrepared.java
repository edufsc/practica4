package app.banco.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPrepared {

	public static void main(String[] args) throws SQLException {

		PreparedStatement instruccion = null;
		Connection conexion = null;

		try {

			// nueva conexión
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

			String query = "INSERT INTO gestor (usuario, password, correo) VALUES (?,?,?)";
			// instrucción preparada
			instruccion = conexion.prepareStatement(query);

			// reemplazamos los ? con los valores
			instruccion.setString(1, "gestorPrueba");
			instruccion.setString(2, "gestorPrueba");
			instruccion.setString(3, "gprueba@mail.com");

			// ejecutamos la query y guardamos el número de filas afectadas
			int filasAfectadas = instruccion.executeUpdate();

			System.out.println("Filas insertadas: " + filasAfectadas);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// libera la instrucción
			if (instruccion != null) {
				instruccion.close();
			}
			// libera la conexión
			if (conexion != null) {
				conexion.close();
			}
		}

	}

}
