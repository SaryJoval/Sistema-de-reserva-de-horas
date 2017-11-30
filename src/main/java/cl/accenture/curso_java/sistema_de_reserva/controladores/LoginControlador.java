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
	private int estado;
	private boolean error;
	private Usuario usuarioLogeado;
	private int intentosFallidos;

	public LoginControlador() {

	}

	// inicio de sesion

	public String iniciarSesion() {

		try {

			Usuario usuario = UsuarioDAO.validar(new Usuario(this.nombreUsuario, this.password));
			usuarioLogeado = usuario;

			// validar el estado

			if (usuarioLogeado.getEstado() == 1) {

				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
				UsuarioDAO.actualizarUltimoIngreso(usuarioLogeado);
				this.mensaje = "";
				this.error = false;

				if (usuario.getPerfil().getId() == 1) {
					return "Cliente?faces-redirect=true";
				} else if (usuario.getPerfil().getId() == 2) {
					return "Ejecutivo?faces-redirect=true";
				} else if (usuario.getPerfil().getId() == 3) {
//					FacesContext contex = FacesContext.getCurrentInstance();
//		            contex.getExternalContext().redirect( "admin" );
					return "root";
				}

			} else if (usuarioLogeado.getEstado() == 2) {

				return "cuenta_bloqueda?faces-redirect=true";

			}

			return "";

		} catch (

		ObjetoNoEncontradoException e) {
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

	public int getIntentosFallidos() {
		return intentosFallidos;
	}

	public void setIntentosFallidos(int intentosFallidos) {
		this.intentosFallidos = intentosFallidos;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
