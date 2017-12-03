package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.ReservaDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ListarReservaControlador implements Serializable {

	private static final long serialVersionUID = -4791973245161975696L;
	private static final Logger LOGGER = Logger.getLogger(ListarReservaControlador.class);

	private String mensaje;
	private List<Reserva> reservas;
	private Reserva reserva;

	public ListarReservaControlador() {
		obtenerReserva();
	}

	public void obtenerReserva() {
		try {

			Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");
			this.reservas = ReservaDAO.obtenerReserva(usuario.getNombreUsuario());
			this.mensaje = "";

			Collections.sort(this.reservas, new Comparator<Reserva>() {
				public int compare(Reserva r1, Reserva r2) {
					if (r1.getIdreserva() > r2.getIdreserva()) {
						return -1;
					}
					if (r1.getIdreserva() < r2.getIdreserva()) {
						return 1;
					}
					return 0;
				}
			});

		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener las Reservas";
			this.reservas = new ArrayList<Reserva>();
			LOGGER.error("Error desconocido", e);
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

	public Reserva getR() {
		return reserva;
	}

	public void setR(Reserva r) {
		this.reserva = r;
	}

}
