package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.util.Date;

public class Reserva {

	private int idreserva;
	private Date fechaReserva;
	private String servicio;
	private String sucursal;
	private String idusuario;
	private String hora;

	private String nombre;
	private String apellidoPaterno;
	private String correo;
	private int celular;

	public Reserva() {

	}

	public Reserva(int idreserva, Date fechaReserva, String servicio, String sucursal, String idusuario, String hora,
			String nombre, String apellidoPaterno, String correo, int celular) {
		super();
		this.idreserva = idreserva;
		this.fechaReserva = fechaReserva;
		this.servicio = servicio;
		this.sucursal = sucursal;
		this.idusuario = idusuario;
		this.hora = hora;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.correo = correo;
		this.celular = celular;
	}

	public Reserva(int idreserva) {

		this.idreserva = idreserva;

	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

}
