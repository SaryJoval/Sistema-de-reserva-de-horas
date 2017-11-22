package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaHoraDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.ReservaHora;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class AgregarReservaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2545746997175419045L;

	private String mensaje;
	private String servicio;
	private String nombre;
	private Date fechaReserva;
	private String hora;
	private String date;
	private List<Sucursal> sucursales;
	private List<ReservaHora> reservasHoras;

	public AgregarReservaControlador() {
		obtenerSucursal();
		obtenerReservasHoras();
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

	public void obtenerReservasHoras() {

		try {
//			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//			this.date = formato.format(this.fechaReserva);
			this.reservasHoras = ReservaHoraDAO.obtenerHorasDisponibles("2017-11-12");
			this.mensaje = "";
			//
			System.out.println(this.date);
			for (ReservaHora reservaHora : reservasHoras) {
				System.out.println(reservaHora.getHora());
			}

		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Horas";
			this.reservasHoras = new ArrayList<ReservaHora>();
		}
	}

	public void agregarReserva() {

		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");
		Reserva reserva = new Reserva();
		Sucursal sucursal = new Sucursal();

		reserva.setServicio(this.servicio);
		reserva.setSucursal(this.nombre);
		reserva.setFechaReserva(this.fechaReserva);
		reserva.setHora(this.hora);

		try {
			ReservaDAO.agregarReserva(reserva, sucursal, usuario);
			this.mensaje = "la reserva se agrego correctamente";
			System.err.println(this.nombre);
		} catch (Exception e) {
			this.mensaje = "Ocurrio un error al agregar la reserva";
			System.err.println(e);
		}

	}

	public void mostrar() {

		System.out.println(this.fechaReserva);
		System.out.println(this.servicio);
		System.out.println(this.nombre);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	public List<ReservaHora> getReservasHoras() {
		return reservasHoras;
	}

	public void setReservasHoras(List<ReservaHora> reservasHoras) {
		this.reservasHoras = reservasHoras;
	}

}
