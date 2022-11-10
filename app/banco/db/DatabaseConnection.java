package app.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private Connection conexion;
	private static final String BD_HOST = "localhost";
	private static final String BD_PORT = "3306";
	private static final String BD_NAME = "banco";
	private static final String BD_USER = "banco";
	private static final String BD_PASS = "banco";

	public DatabaseConnection() {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://" + BD_HOST + ":" + BD_PORT + "/" + BD_NAME, BD_USER,
					BD_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConexion() {
		return conexion;
	}

}
