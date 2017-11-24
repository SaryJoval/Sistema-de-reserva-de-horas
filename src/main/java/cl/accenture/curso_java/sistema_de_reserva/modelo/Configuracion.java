package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Configuracion {

	private String clave;
	private String valor;
	
	public Configuracion() {
	}

	public Configuracion(String clave, String valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
