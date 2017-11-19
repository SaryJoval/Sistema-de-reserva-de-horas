package cl.accenture.curso_java.sistema_de_reserva.modelo;

public class Sucursal {

	private int idsucursal;
	private String nombre;

	public Sucursal() {

	}

	public Sucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

	public int getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}