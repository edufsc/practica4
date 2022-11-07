package app.banco.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {

		try {
			// nueva conexión
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");
			System.out.println("Versión del driver: " + conexion.getMetaData().getDriverVersion());
			// capturamos posibles excepciones
			Statement instruccion = conexion.createStatement();
			String query = "INSERT INTO gestor (usuario, password, correo) VALUES ('gestor1','gestor1','gestor1@correo.com')";

			boolean resultado = instruccion.execute(query);

			if (!resultado) {
				System.out.println("Registros actualizados: " + instruccion.getUpdateCount());
			}

//			String query = "SELECT * FROM gestor";
//			ResultSet resultados1 = instruccion.executeQuery(query);

//			System.out.println("Listado de gestores (con executeQuery): ");
			// ejecutar instrucción con el método executeQuery
//			while (resultados1.next()) {
//				System.out.println("Gestor " + resultados1.getInt("id"));
//				System.out.println("Usuario: " + resultados1.getString("usuario"));
//				System.out.println("Password: " + resultados1.getString("password"));
//				System.out.println("Correo: " + resultados1.getString("correo"));
//				System.out.println("...");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
