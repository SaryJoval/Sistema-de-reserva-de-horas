package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Permiso {
	
	private String identificador;
	private String nombre;
	
	public Permiso() {
		
	}

	public Permiso(String identificador, String nombre) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
	}

	

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Permiso) {
			Permiso permiso = (Permiso)obj;
			return permiso.getIdentificador().equals(((Permiso) obj).getIdentificador());
		}
		return false;
		
	}

}
