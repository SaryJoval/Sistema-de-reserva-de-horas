/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.modelo;

/**
 * @author luis
 *
 */

public class Preferencia {

	private int idPreferencia;
	private String nombreUsuario;
	private int valor;

	public Preferencia() {

	}

	public int getIdPreferencia() {
		return idPreferencia;
	}

	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
