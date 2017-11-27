package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class DiaFeriado {
	
	private String fecha;
	
	public DiaFeriado() {
		
	}

	public DiaFeriado(String fecha) {
		super();
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
