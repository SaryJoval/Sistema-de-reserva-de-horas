package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ListarPerfilControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242703777996793197L;

	private String mensaje;
	private Usuario usuario;

	public ListarPerfilControlador() {
		obtenerUsuario();
	}

	public void obtenerUsuario() {

		try {
			Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			this.usuario = UsuarioDAO.obtenerUsuario(u.getNombreUsuario());
			this.mensaje = "";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener el perfil";
			this.usuario = null;
			System.err.println(e);
		}

	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
