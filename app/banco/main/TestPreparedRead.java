package app.banco.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedRead {

	public static void main(String[] args) throws SQLException {

		PreparedStatement instruccion = null;
		Connection conexion = null;
		ResultSet resultados = null;

		try {

			// nueva conexión
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

			String query = "SELECT * from gestor WHERE id IN (?,?)";
			// instrucción preparada
			instruccion = conexion.prepareStatement(query);

			// reemplazamos los ? con los valores
			instruccion.setInt(1, 2);
			instruccion.setInt(2, 3);

			// ejecutamos la query y guardamos el número de filas afectadas
			resultados = instruccion.executeQuery();

			System.out.println("Filas recuperadas: ");

			// recorremos los resultados
			while (resultados.next()) {
				System.out.println("Gestor " + resultados.getInt("id"));
				System.out.println("Usuario: " + resultados.getString("usuario"));
				System.out.println("Password: " + resultados.getString("password"));
				System.out.println("Correo: " + resultados.getString("correo"));
				System.out.println("...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// libera el ResultSet
			if (resultados != null) {
				resultados.close();
			}

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
