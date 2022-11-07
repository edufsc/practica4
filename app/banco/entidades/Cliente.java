package app.banco.entidades;

public class Cliente extends Persona {

	private Long idGestor;
	private Double saldo;

	public Cliente() {

	}

	public Long getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Long idGestor) {
		this.idGestor = idGestor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
