package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Sucursal {

	private int idSucursal;
	private String nombre;

	public Sucursal() {
		super();
		this.idSucursal = 0;
		this.nombre = "";
	}

	public Sucursal(int idSucursal, String nombre) {
		super();
		this.idSucursal = idSucursal;
		this.nombre = nombre;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
