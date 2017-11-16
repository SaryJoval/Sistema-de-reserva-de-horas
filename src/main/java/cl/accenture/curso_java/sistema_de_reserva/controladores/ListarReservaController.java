package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;

@ManagedBean
@SessionScoped
public class ListarReservaController implements Serializable {

	private static final long serialVersionUID = -4791973245161975696L;

	private List<Reserva> reservas;
	private String mensaje;

	public ListarReservaController() {
		obtenerReserva();
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void obtenerReserva() {
		
		try {
			this.reservas = ReservaDAO.obtenerReservas();
		} catch (Exception e) {
			this.mensaje = "Ocurrio un error al obtener las reservas de horas";
			this.reservas = new ArrayList<Reserva>();
		}
		
	}

}
