package cl.accenture.curso_java.sistema_de_reserva.controladores;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Esthéfanie Holguín
 *
 */
@ManagedBean
@SessionScoped
public class InicioSesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4396136258065169961L;
	private String nombreUsuario;
	private String password;
	private boolean error;
	private String mensaje;
	
	public InicioSesionController() {
		this.nombreUsuario="";
		this.password="";
		this.mensaje="";
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

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
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
	
	public String iniciarSesion() {
		if( this.nombreUsuario.equals( "esthefanieholguin" ) && this.password.equals( "eh123" )  ){
			this.mensaje = "";
			this.error = false;
			return ""; 
		}else{
			this.error = true;
			this.mensaje = "Usuario y/o Password incorrectos";
			return "";
		}
		
		
	}


}
