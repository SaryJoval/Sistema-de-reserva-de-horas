package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.util.List;

public class Perfil {
	
	private int id;
	private String nombre;
	private List<Permiso> permisos;
	
	public Perfil() {
		
	}

	public Perfil(int id, String nombre, List<Permiso> permisos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.permisos = permisos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
}
