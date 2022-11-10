package app.banco.main;

import java.sql.Timestamp;
import java.util.Date;

public class TestCliente {

	public static void main(String[] args) {

		// fecha actual formato Java
		Date fecha = new Date();
		
		// fecha en ms desde 1 de enero de 1970
		long ms = fecha.getTime();

		System.out.println("Fecha en ms: " + ms);
		
		// fecha en formato datetime compatible con SQL
		Timestamp datetime = new Timestamp(ms);
		
		// en una línea
		datetime = new Timestamp(new Date().getTime());
		
		System.out.println("Fecha en timestamp: " + datetime);

	}

}
