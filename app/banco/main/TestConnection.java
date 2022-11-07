package app.banco.main;

import java.util.ArrayList;

import app.banco.db.DatabaseGestor;
import app.banco.entidades.Gestor;

public class TestConnection {

	public static void main(String[] args) {

		DatabaseGestor database = new DatabaseGestor();

		// obtener todos los gestores e imprimirlos de uno en uno
		ArrayList<Gestor> gestores = database.getGestores();
		gestores.forEach((gestor) -> {
			System.out.println(gestor.getId() + " - " + gestor.getUsuario() + "- " + gestor.getCorreo());
		});

		// crear nuevo gestor y guardarlo
		Gestor nuevoGestor = new Gestor(1, "user", "pass", "test@correo.es");
//		database.insertarGestor(nuevoGestor);

		// obtener gestor con el id 8
		Gestor gestor = database.getGestor(8);
		if (gestor != null) {
			System.out.println("El gestor 8 es " + gestor.getUsuario());
		} else {
			System.out.println("El gestor 8 no existe en BD");
		}

		// actualizar correo del gestor 8
		gestor.setCorreo("otrocorreo@test.es");
		boolean gestorActualizado = database.actualizarGestor(gestor);
		if (gestorActualizado) {
			System.out.println("Se ha actualizado el gestor 8");
		} else {
			System.out.println("No se ha actualizado el gestor 8");
		}

		// borrar gestor con el id 3
//		boolean gestorBorrado = database.borrarGestor(3);
//		if (gestorBorrado) {
//			System.out.println("Se ha borrado el gestor 3");
//		} else {
//			System.out.println("No se ha eliminado el gestor 3");
//		}

	}

}
