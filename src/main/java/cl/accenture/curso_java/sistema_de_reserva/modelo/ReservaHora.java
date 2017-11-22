package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class ReservaHora {

	private int idReservaHora;
	private String hora;
	
	public ReservaHora() {
	
	}

	public ReservaHora(int idReservaHora, String hora) {
		super();
		this.idReservaHora = idReservaHora;
		this.hora = hora;
	}

	public int getIdReservaHora() {
		return idReservaHora;
	}

	public void setIdReservaHora(int idReservaHora) {
		this.idReservaHora = idReservaHora;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
