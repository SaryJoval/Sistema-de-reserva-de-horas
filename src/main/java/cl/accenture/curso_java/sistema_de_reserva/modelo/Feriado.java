package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Feriado {

	private int idFeriado;
	private String fecha;
	private String descripcion;

	public Feriado() {
	}

	public Feriado(int idFeriado, String fecha, String descripcion) {
		super();
		this.idFeriado = idFeriado;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	public int getIdFeriado() {
		return idFeriado;
	}

	public void setIdFeriado(int idFeriado) {
		this.idFeriado = idFeriado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
