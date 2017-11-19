package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ListarReservaControlador implements Serializable {

	private static final long serialVersionUID = -4791973245161975696L;

	private String mensaje;
	private List<Reserva> reservas;

	public ListarReservaControlador() {
		obtenerReserva();
	}

	public void obtenerReserva() {
		try {
			Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			this.reservas = ReservaDAO.obtenerReserva(usuario.getNombreUsuario());
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Reservas";
			this.reservas = new ArrayList<Reserva>();
			System.err.println(e);
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
