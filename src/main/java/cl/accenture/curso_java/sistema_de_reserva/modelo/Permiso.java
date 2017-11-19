package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Permiso {

	private String identificador;
	private String nombre;

	public Permiso() {
	}

	public Permiso(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Permiso) {
			Permiso permiso = (Permiso) obj;
			return permiso.getIdentificador().equals(this.identificador);
		}
		return false;
	}

}
