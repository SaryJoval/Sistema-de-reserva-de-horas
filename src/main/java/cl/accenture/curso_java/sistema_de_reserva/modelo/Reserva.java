package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.util.Date;


public class Reserva {

	private int idReserva;
	private Date fechaReserva;
	private Date fechaActual;
	private String servicio;
	private Sucursal sucursal;

	public Reserva() {
		super();
		this.idReserva = 0;
		this.fechaReserva = new Date();
		this.fechaActual = new Date();
		this.servicio = "";
		this.sucursal = new Sucursal();
	}
	

	public Reserva(int idReserva, Date fechaReserva, Date fechaActual, String servicios, Sucursal sucursal) {
		super();
		this.idReserva = idReserva;
		this.fechaReserva = fechaReserva;
		this.fechaActual = fechaActual;
		this.servicio = servicios;
		this.sucursal = sucursal;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}
