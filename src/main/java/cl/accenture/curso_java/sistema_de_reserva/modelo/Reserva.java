package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.sql.Time;
import java.util.Date;

public class Reserva {

	private int idreserva;
	private Date fechaReserva;
	private String servicio;
	private String sucursal;
	private int idusuario;
	private Time hora;

	public Reserva() {

	}
	

	public Reserva(int idreserva, Date fechaReserva, String servicio, String sucursal, int idusuario, Time hora) {
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

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}
