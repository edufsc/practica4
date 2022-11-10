package app.banco.test;

import java.util.ArrayList;

import app.banco.db.DatabaseGestor;
import app.banco.entidades.Gestor;

public class TestLeerGestores {
	public static void main(String[] args) {
		DatabaseGestor database = new DatabaseGestor();
		ArrayList<Gestor> gestores = database.getGestores();
		
		// imprimir todos los gestores
		gestores.forEach((gestor) -> {
			System.out.println(gestor.getId() + " " + gestor.getUsuario());
		});
	}
}
