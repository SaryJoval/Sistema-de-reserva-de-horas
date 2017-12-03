

package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.servicio.SendEmailUsingGMailSMTP;

@ManagedBean (name="pass")
@SessionScoped
public class RecuperarCuentaControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6406456345344022963L;
	private static final Logger LOGGER = Logger.getLogger(RecuperarCuentaControlador.class);

	private String mensaje;
	private String email;
	private String texto;
	private String asunto;

	public RecuperarCuentaControlador() {
		
		this.mensaje = "";
		this.email = "";

	}

	public void recuperar() {

		boolean validar = false;

		try {
			validar = UsuarioDAO.correo_existe(this.email);

			if (validar) {

				this.texto = "Por favor ingrese a este link para recuperar su contraseña: link";
				this.asunto = "Recuperacion de contraseña";

				Calendar cal = GregorianCalendar.getInstance();
				cal.getTime();

				SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
				String fecha = formatoFecha.format(cal.getTime());

				SendEmailUsingGMailSMTP.envioMail(this.email, fecha, this.asunto, this.texto);
				LOGGER.info("Correo enviado");

			}else {
				this.mensaje = "El correo no esta registrado";
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

		// texto

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
