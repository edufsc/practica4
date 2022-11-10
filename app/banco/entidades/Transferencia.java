package app.banco.entidades;

import java.sql.Timestamp;

public class Transferencia {

	private int id;
	private int idOrdenante;
	private int idBeneficiario;
	private double importe;
	private Timestamp fecha;

	public Transferencia() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOrdenante() {
		return idOrdenante;
	}

	public void setIdOrdenante(int idOrdenante) {
		this.idOrdenante = idOrdenante;
	}

	public int getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(int idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}
