package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.FeriadoDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Feriado;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;

@ManagedBean
@SessionScoped
public class EjecutivoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5464344401830887343L;
	private static final Logger LOGGER = Logger.getLogger(EjecutivoControlador.class);

	private Date fechaActual;
	private String mensaje;
	private String mensajeFeriados;
	private String nombre;
	private String fecha;
	private String descripcion;
	private int idReserva;

	private List<Reserva> reservasTotales;
	private List<Sucursal> sucursales;
	private List<Feriado> feriados;

	public EjecutivoControlador() {
		obtenerReseravsTotales();
		obtenerSucursal();
		obtenerFeriado();
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
			LOGGER.error("Error desconocido", e);

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
				this.mensaje = "No se encontro la reserva";
				LOGGER.warn("No se encontro la reserva");
			} else {
				this.mensaje = "";
			}

		} catch (Exception e) {
			// TODO: handle exception
			this.mensaje = "Lo sentimos ocurrio un error en listar las reservas";
			this.setReservasTotales(new ArrayList<Reserva>());
			LOGGER.error("Error desconocido", e);
		}
	}

	// Eliminar reserva

	public void eliminar(Reserva reserva) {

		try {
			ReservaDAO.eliminarReserva(reserva);
			obtenerReseravsTotales();
			this.mensaje = "La reserva se elimino con exito";
			this.nombre = "";
			LOGGER.info("Se elimino la reserva " + reserva.getIdreserva());
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la reserva";
			LOGGER.error("Error desconocido", e);
		}
	}

	// Listar todas las sucursales
	public void obtenerSucursal() {

		try {
			this.setSucursales(SucursalDAO.obtenerSucursal());
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener la Sucursal";
			this.setSucursales(new ArrayList<Sucursal>());
			LOGGER.error("Error desconocido", e);
		}
	}

	// Agreagar sucursal

	public void agregarSucursal() {

		try {
			SucursalDAO.agregarSucursal(this.nombre);
			LOGGER.info("Se agrego la sucursal: " + this.nombre);
			obtenerSucursal();
			this.mensaje = "Sucursal agregada con exito!";
			this.nombre = "";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

	}

	// eliminar sucursal

	public void eliminarSucursal(Sucursal sucursal) {

		try {
			SucursalDAO.eliminarSucursal(sucursal);
			this.mensaje = "Sucursal eliminada";
			LOGGER.info("Se elimino la sucursal " + sucursal.getNombre());
			obtenerSucursal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

	}

	// Listar todos los feriados
	public void obtenerFeriado() {

		try {
			this.setFeriados(FeriadoDAO.obtenerFeriados());
		} catch (Exception e) {
			this.mensajeFeriados = "Lo sentimos, Ocurrio un error al obtener los feriados";
			this.setSucursales(new ArrayList<Sucursal>());
		}
	}

	// agreagar friado
	public void agregarFeriado() {

		try {
			FeriadoDAO.agregarFeriado(this.fecha, this.descripcion);
			obtenerFeriado();
			this.mensajeFeriados = "Feriado agregardo con exito";
			this.nombre = "";
			LOGGER.info("Se agrego el feriado " + this.fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}
	}

	// eliminar feriado

	public void eliminarFeriado(Feriado feriado) {

		try {
			FeriadoDAO.eliminarFeriado(feriado);
			this.mensajeFeriados = "Feriado eliminado";
			obtenerFeriado();
			LOGGER.info("Se elimino el feriado con fecha " + this.fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

	}

	// horas

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public List<Feriado> getFeriados() {
		return feriados;
	}

	public void setFeriados(List<Feriado> feriados) {
		this.feriados = feriados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMensajeFeriados() {
		return mensajeFeriados;
	}

	public void setMensajeFeriados(String mensajeFeriados) {
		this.mensajeFeriados = mensajeFeriados;
	}

}
