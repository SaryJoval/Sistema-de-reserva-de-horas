package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.util.Date;

public class Reserva {

	private int idreserva;
	private Date fechaReserva;
	private String servicio;
	private String sucursal;
	private String idusuario;
	private String hora;

	public Reserva() {

	}
	

	public Reserva(int idreserva, Date fechaReserva, String servicio, String sucursal, String idusuario, String hora) {
		super();
		this.idreserva = idreserva;
		this.fechaReserva = fechaReserva;
		this.servicio = servicio;
		this.sucursal = sucursal;
		this.idusuario = idusuario;
		this.hora = hora;
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

}
