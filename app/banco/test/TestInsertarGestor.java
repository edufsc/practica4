package app.banco.test;

import app.banco.db.DatabaseGestor;
import app.banco.entidades.Gestor;

public class TestInsertarGestor {

	public static void main(String[] args) {
		DatabaseGestor database = new DatabaseGestor();
		Gestor nuevoGestor = new Gestor();
		nuevoGestor.setCorreo("prueba@test.com");
		nuevoGestor.setUsuario("pepe");
		nuevoGestor.setPassword("pass123");

		boolean insertado = database.insertarGestor(nuevoGestor);
		
		// se ha insertado?
		if (insertado) {
			System.out.println("Insertado correctamente");
		} else {
			System.out.println("No insertado");
		}
	}
}
