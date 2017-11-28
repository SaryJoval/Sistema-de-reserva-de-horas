package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.servicio.SendEmailUsingGMailSMTP;

@ManagedBean
@SessionScoped
public class RecuperarCuentaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6406456345344022963L;

	private String mensaje;
	private String email;
	private String texto;
	private String asunto;

	public RecuperarCuentaControlador() {

	}

	public void recuperar() {
		
		//texto
		this.texto = "Por favor ingrese a este link para recuperar su contraseña: link";
		this.asunto = "Recuperacion de contraseña";

		Calendar cal = GregorianCalendar.getInstance();
		cal.getTime();

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoFecha.format(cal.getTime());

		SendEmailUsingGMailSMTP.envioMail(this.email, fecha, this.asunto, this.texto);

	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	

}
