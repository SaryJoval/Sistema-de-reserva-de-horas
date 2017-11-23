package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.ConfiguracionDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Configuracion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
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
	private String horaInicio;
	private String horaFin;
	private String bloque;

	private Calendar hora;

	private Date fechaReserva;

	private List<Sucursal> sucursales;
	private List<Calendar> horas;
	private List<Configuracion> configuraciones;

	public AgregarReservaControlador() {
		obtenerSucursal();
		//obtenerHorasDisponibles();

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

	public void obtenerHorasDisponibles() {

		try {

			// Calendar cal = GregorianCalendar.getInstance();
			// cal.setTime( this.fechaReserva );
			// cal.add(Calendar.DAY_OF_MONTH, 1);
			//
			// String horaInicio = "10:00:00";
			// String horaFin = "18:00:00";
			// String bloque = "30";

			this.configuraciones = ConfiguracionDAO.obtenerConfiguraciones();

			this.bloque = this.configuraciones.get(0).getValor();
			this.horaFin = this.configuraciones.get(1).getValor();
			this.horaInicio = this.configuraciones.get(2).getValor();
			
//			System.out.println(bloque);
//			System.out.println(horaFin);
//			System.out.println(horaInicio);

			
			DateFormat horaformar = new SimpleDateFormat("hh:mm:ss");

			Date bloqueT = horaformar.parse(this.bloque);
			Date horaFinT = horaformar.parse(this.horaFin);
			Date horaInicioT = horaformar.parse(this.horaInicio);
			
			System.out.println(horaFinT.getTime());
			System.out.println(horaInicioT.getTime());

			

			Calendar cal = Calendar.getInstance();

			while (cal.getTime().equals(horaFinT)) {

				cal.setTime(horaInicioT);
				cal.add(Calendar.MINUTE, 30);

				this.hora.setTime(cal.getTime());
				this.horas.add(this.hora);

			}

			// SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			// this.date = formato.format(cal.getTime());
			// this.reservasHoras = ReservaHoraDAO.obtenerHorasDisponibles(this.date);
			this.mensaje = "";
			//
			// System.out.println(this.date);
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Horas";
			// this.reservasHoras = new ArrayList<ReservaHora>();
			this.configuraciones = new ArrayList<Configuracion>();
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

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Calendar> getHoras() {
		return horas;
	}

	public void setHoras(List<Calendar> horas) {
		this.horas = horas;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public List<Configuracion> getConfiguraciones() {
		return configuraciones;
	}

	public void setConfiguraciones(List<Configuracion> configuraciones) {
		this.configuraciones = configuraciones;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

}
