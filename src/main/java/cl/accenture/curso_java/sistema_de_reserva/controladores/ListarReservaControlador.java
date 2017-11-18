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
public class ListarReservaControlador implements Serializable {

	private static final long serialVersionUID = -4791973245161975696L;

	private String mensaje;
	private List<Reserva> reservas;

	public ListarReservaControlador() {
		obtenerReserva();
	}

	public void obtenerReserva() {
		try {
			this.reservas = ReservaDAO.obtenerReserva();
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Reservas";
			this.reservas = new ArrayList<Reserva>();
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
