package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;

@ManagedBean
@SessionScoped
public class EjecutivoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5464344401830887343L;

	private Date fechaActual;
	private String mensaje;
	private int idReserva;

	private List<Reserva> reservasTotales;

	public EjecutivoControlador() {
		obtenerReseravsTotales();
	}

	// Lista todas las reservas del sistema

	public void obtenerReseravsTotales() {
		try {

			Calendar cal = Calendar.getInstance();
			this.fechaActual = cal.getTime();

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatoFecha.format(this.fechaActual);

			this.setReservasTotales(ReservaDAO.obtenerReservasTotales(fecha));

			Collections.sort(this.reservasTotales, new Comparator<Reserva>() {
				public int compare(Reserva r1, Reserva r2) {

					return r1.getFechaReserva().compareTo(r2.getFechaReserva());
				}
			});

			this.mensaje = "";

		} catch (Exception e) {
			// TODO: handle exception
			this.mensaje = "Lo sentimos ocurrio un error en listar las reservas";
			this.setReservasTotales(new ArrayList<Reserva>());
		}
	}

	// obtener Reserva por id

	public void obtenerReservaID() {
		try {

			this.setReservasTotales(ReservaDAO.obtenerReservaID(this.idReserva));

			Collections.sort(this.reservasTotales, new Comparator<Reserva>() {
				public int compare(Reserva r1, Reserva r2) {

					return r1.getFechaReserva().compareTo(r2.getFechaReserva());
				}
			});

			if (this.reservasTotales.size() == 0) {
				this.mensaje = "Numero de reserva incorrecto";
			} else {
				this.mensaje = "";
			}

		} catch (Exception e) {
			// TODO: handle exception
			this.mensaje = "Lo sentimos ocurrio un error en listar las reservas";
			this.setReservasTotales(new ArrayList<Reserva>());
		}
	}

	// Eliminar reserva

	public void eliminar(Reserva reserva) {
		
		try {
			ReservaDAO.eliminarReserva(reserva);
			obtenerReseravsTotales();
			this.mensaje = "La reserva se elimino con exito";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la reserva";
		}
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public List<Reserva> getReservasTotales() {
		return reservasTotales;
	}

	public void setReservasTotales(List<Reserva> reservasTotales) {
		this.reservasTotales = reservasTotales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

}
