package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ListarPerfilControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5242703777996793197L;
	private static final Logger LOGGER = Logger.getLogger(ListarPerfilControlador.class);

	private String mensaje;
	private String password;

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
			LOGGER.error("Error desconocido", e);
		}

	}
	

	// Modificacion de usaurio

	public String modificarUsuario() {

		try {

			UsuarioDAO.modificarUsuario(this.usuario);
			LOGGER.info("Se modifico el usuario " + this.usuario.getNombreUsuario());
			//refireccionar
			
			FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect( "Cliente.xhtml" );


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}
		return mensaje;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
