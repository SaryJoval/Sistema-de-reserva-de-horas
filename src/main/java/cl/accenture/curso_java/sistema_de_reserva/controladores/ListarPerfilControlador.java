package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Perfil;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;
import cl.accenture.curso_java.sistema_de_reserva.servicio.ServicioEncriptar;

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

			Perfil p = new Perfil();

			Usuario u = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");

			p.setId(u.getPerfil().getId());

			this.usuario = UsuarioDAO.obtenerUsuario(u.getNombreUsuario());
			this.usuario.setPerfil(p);

			this.mensaje = "";
		} catch (Exception e) {
			FacesContext contex = FacesContext.getCurrentInstance();
			try {
				contex.getExternalContext().redirect("InicioFinal.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.mensaje = "Lo sentimos, Ocurrio un error al obtener el perfil";
			this.usuario = null;
		}

	}

	// Modificacion de usaurio

	public String modificarUsuario() {

		try {
			String pass = "";

			pass = ServicioEncriptar.encriptar(this.password);

			UsuarioDAO.modificarUsuario(this.usuario, pass);

			if (this.usuario.getPerfil().getId() == 1) {

				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect("Cliente.xhtml");

			} else if (this.usuario.getPerfil().getId() == 2) {
				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect("Ejecutivo.xhtml");

			} else {

				FacesContext contex = FacesContext.getCurrentInstance();
				contex.getExternalContext().redirect("root.xhtml");

			}

			LOGGER.info("Se modifico el usuario " + this.usuario.getNombreUsuario());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (NoSuchAlgorithmException e) {
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
