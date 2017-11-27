package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.ObjetoNoEncontradoException;
import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5310586593465150563L;

	private String nombreUsuario;
	private String password;
	private String mensaje;
	private boolean estado;
	private boolean error;
	private Usuario usuarioLogeado;

	public LoginControlador() {
		this.nombreUsuario = "";
		this.password = "";
		this.estado = true;
		this.mensaje = "";
		this.usuarioLogeado = new Usuario();

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Usuario getUsuarioLogeado() {
		return usuarioLogeado;
	}

	public void setUsuarioLogeado(Usuario usuarioLogeado) {
		this.usuarioLogeado = usuarioLogeado;
	}

	// inicio de sesion

	public String iniciarSesion() {

		try {
			Usuario usuario = UsuarioDAO.validar(new Usuario(this.nombreUsuario, this.password));
			usuarioLogeado = usuario;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
			UsuarioDAO.actualizarUltimoIngreso(usuarioLogeado);
			this.mensaje = "";
			this.error = false;

			if (usuario.getPerfil().getId() == 1) {
				return "Cliente?faces-redirect=true";
			} else if (usuario.getPerfil().getId() == 2) {
				return "Ejecutivo?faces-redirect=true";
			} else if (usuario.getPerfil().getId() == 3) {
				return "Admin?faces-redirect=true";
			}
			
			return "";

		} catch (ObjetoNoEncontradoException e) {
			this.error = true;
			this.mensaje = "Usuario y/o Password incorrectos";
			return "";
		} catch (Exception e) {
			this.error = true;
			this.mensaje = "Ocurrio un error inesperado, intente más tarde";
			return "";
		}
	}

	public String cerrarSesion() {

		this.usuarioLogeado = null;
		this.nombreUsuario = null;
		this.password = null;
		return "InicioFinal?faces-redirect=true";
	}

}
