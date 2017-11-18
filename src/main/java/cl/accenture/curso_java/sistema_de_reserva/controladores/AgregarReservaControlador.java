package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;

@ManagedBean
@SessionScoped
public class AgregarReservaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545746997175419045L;

	private String mensaje;
	private List<Sucursal> sucursales;

	//
	private String nombre;
	private String servicio;
	private Date fechaReserva;
	private Time hora;

	public AgregarReservaControlador() {
		obtenerSucursal();
		agregarReserva();
	}

	public void obtenerSucursal() {
		try {
			this.sucursales = SucursalDAO.obtenerSucursal();
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener la Sucursal";
			this.sucursales = new ArrayList<Sucursal>();
		}
	}

	public void agregarReserva() {

		try {

			Reserva reserva = new Reserva();
			Sucursal sucursal = new Sucursal();

			reserva.setFechaReserva(fechaReserva);
			System.out.println("fecha: " + fechaReserva);
			reserva.setHora(hora);
			reserva.setServicio(servicio);
			sucursal.setNombre(nombre);
			System.out.println("nombre: " + nombre);

			ReservaDAO.agregarReserva(reserva, sucursal);
			this.mensaje = "la reserva se agrego correctamente";
			reserva = null;
			sucursal = null;
		} catch (Exception e) {
			this.mensaje = "Ocurrio un error al agregar la reserva";
		}

	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

}
