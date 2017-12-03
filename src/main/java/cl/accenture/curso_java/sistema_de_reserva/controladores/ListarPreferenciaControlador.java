/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.PreferenciaDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Preferencia;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;
import cl.accenture.curso_java.sistema_de_reserva.servicio.ServicioDias;

/**
 * @author Luis Torres
 *
 */
@ManagedBean
@RequestScoped
public class ListarPreferenciaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6770267643578042348L;
	private static final Logger LOGGER = Logger.getLogger(ListarPreferenciaControlador.class);

	private List<Preferencia> preferencias;
	private List<Preferencia> diasDelMes;

	private String mensaje;
	private String fechaFin;
	private String nombreDia;

	public ListarPreferenciaControlador() {
		
		obtenerDias();
	}

	public void obtenerDias() {

		try {

			Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			
			this.preferencias = PreferenciaDAO.obtenerPreferencia(u.getNombreUsuario());
			
			for (Preferencia preferencia : preferencias) {
				
				
				if (preferencia.getValor() == 2) {
					nombreDia = "Lunes";
				} else if (preferencia.getValor() == 3) {
					nombreDia = "Martes";
				} else if (preferencia.getValor() == 4) {
					nombreDia = "Miercoles";
				} else if (preferencia.getValor() == 5) {
					nombreDia = "Jueves";
				} else if (preferencia.getValor() == 6) {
					nombreDia = "Viernes";
				}
				
				preferencia.setNombreDia(nombreDia);
				
			}
			
			this.diasDelMes = ServicioDias.calcularDiasDelMes(this.preferencias);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

	}

	public void obtenerPreferencias() {
		Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuario");

		try {
			this.preferencias = PreferenciaDAO.obtenerPreferencia(usuario.getNombreUsuario());
			this.mensaje = "hola";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}
	}

	public List<Preferencia> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<Preferencia> preferencias) {
		this.preferencias = preferencias;
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
	
	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Preferencia> getDiasDelMes() {
		return diasDelMes;
	}

	public void setDiasDelMes(List<Preferencia> diasDelMes) {
		this.diasDelMes = diasDelMes;
	}
	

}
