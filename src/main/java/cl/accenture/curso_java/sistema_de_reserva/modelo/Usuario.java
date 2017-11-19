package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.util.Date;
import java.util.List;

public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private int celular;
	private int edad;
	private Date ultimoIngreso;
	private boolean estado;
	private List<String> preferencias;
	private String password;

	public Usuario() {

	}

	public Usuario(int idUsuario, String nombreUsuario, String nombre, String apellidoPaterno, String apellidoMaterno,
			String correo, int celular, int edad, Date ultimoIngreso, boolean estado, List<String> preferencias,
			String password) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.celular = celular;
		this.edad = edad;
		this.ultimoIngreso = ultimoIngreso;
		this.estado = estado;
		this.preferencias = preferencias;
		this.password = password;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int id) {
		this.idUsuario = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}

	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<String> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<String> preferencias) {
		this.preferencias = preferencias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}