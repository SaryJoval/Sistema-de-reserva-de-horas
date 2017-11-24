package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import cl.accenture.curso_java.sistema_de_reserva.dao.ConfiguracionDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Configuracion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;
import cl.accenture.curso_java.sistema_de_reserva.servicio.ServicioHorasDisponibles;

@ManagedBean
@SessionScoped
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
	private int idsucursal;

	private String hora;

	private Date fechaReserva;

	private List<Sucursal> sucursales;
	private List<String> horas;
	private List<String> horasReservadas;
	private List<String> horasDisponibles;
	private List<Configuracion> configuraciones;

	public AgregarReservaControlador() {
		obtenerSucursal();
	}

	// lista de sucursales

	public void obtenerSucursal() {

		try {
			this.sucursales = SucursalDAO.obtenerSucursal();
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener la Sucursal";
			this.sucursales = new ArrayList<Sucursal>();
		}
	}

	// Horas disponibles

	public void obtenerHorasDisponibles() {

		try {

			this.configuraciones = ConfiguracionDAO.obtenerConfiguraciones();

			this.bloque = this.configuraciones.get(0).getValor();
			this.horaFin = this.configuraciones.get(1).getValor();
			this.horaInicio = this.configuraciones.get(2).getValor();

			int bloqueF = Integer.parseInt(bloque);

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha = formatoFecha.format(this.fechaReserva);

			this.horas = ServicioHorasDisponibles.calcularHorasDisponibles(this.horaInicio, this.horaFin, bloqueF);
			this.horasReservadas = ReservaDAO.obenerHorasReservadas(fecha);
			this.horasDisponibles = ServicioHorasDisponibles.obtenerHorasDisponibles(this.horasReservadas, this.horas);

			this.mensaje = "";
		} catch (Exception e) {
			e.printStackTrace();
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Horas";
			this.configuraciones = new ArrayList<Configuracion>();
			this.horasDisponibles = new ArrayList<String>();
			this.horasReservadas = new ArrayList<String>();
		}
	}

	// agregar una reserva

	public void agregarReserva() {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoFecha.format(this.fechaReserva);

		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");

		try {
			ReservaDAO.agregarReserva(fecha, this.servicio, this.nombre, usuario, this.hora);
			limpiar();
			recargar();

		} catch (Exception e) {
			this.mensaje = "Ocurrio un error al agregar la reserva";
			System.err.println(e);
		}

	}

	private void recargar() {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void limpiar() {
		this.horasDisponibles = new ArrayList<String>();
		this.servicio = "";
		this.fechaReserva = Calendar.getInstance().getTime();
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
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

	public List<String> getHorasDisponibles() {
		return horasDisponibles;
	}

	public void setHorasDisponibles(List<String> horasDisponibles) {
		this.horasDisponibles = horasDisponibles;
	}

	public List<String> getHorasReservadas() {
		return horasReservadas;
	}

	public void setHorasReservadas(List<String> horasReservadas) {
		this.horasReservadas = horasReservadas;
	}

	public List<String> getHoras() {
		return horas;
	}

	public void setHoras(List<String> horas) {
		this.horas = horas;
	}

	public int getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

}
