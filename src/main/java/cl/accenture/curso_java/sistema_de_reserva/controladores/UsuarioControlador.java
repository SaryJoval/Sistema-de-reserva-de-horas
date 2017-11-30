package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cl.accenture.curso_java.sistema_de_reserva.dao.PreferenciaDAO;
import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Perfil;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;
import cl.accenture.curso_java.sistema_de_reserva.servicio.SendEmailUsingGMailSMTP;

@ManagedBean
@RequestScoped
public class UsuarioControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485314226149147415L;

	private String nombreUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String password;
	private String mensajeNuevoUsuario;
	private String mensaje;
	private String errorUser;
	private String errorEdad;
	private String errorEmail;
	private int idPerfil;

	private int celular;
	private int edad;
	private int estado;

	private List<String> preferencias;
	private List<Usuario> usuarios;

	public UsuarioControlador() {

		this.idPerfil = 1;

	}

	// validar edad

	public boolean validarEdad() {

		if (this.edad < 18) {
			this.errorEdad = "Debes ser mayor de edad";
			return true;
		} else {
			this.errorEdad = "";
			return false;
		}

	}

	public boolean validarUsuario() {

		try {

			boolean errorU = false;

			errorU = UsuarioDAO.nombreUsuario_existe(this.nombreUsuario);
			if (errorU) {
				this.errorUser = "Ya existe";
				return true;
			} else {
				this.errorUser = "Perfecto";
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	// validar email

	public boolean validarCorreo() {

		try {

			boolean errorC = false;

			errorC = UsuarioDAO.correo_existe(this.correo);

			if (errorC) {
				this.errorEmail = "Ya existe";
				return true;
			} else {
				this.errorEmail = "Perfecto";
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public String guardar() {

		Calendar cal = GregorianCalendar.getInstance();
		cal.getTime();

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = formatoFecha.format(cal.getTime());

		String asunto = "Registro sistema reservas de horas";
		String texto = " Registro ñññññññ  ISO-8859-1";

		Usuario usuario = new Usuario();
		Perfil perfil = new Perfil();
		// Preferencia preferencia = new Preferencia();

		usuario.setNombreUsuario(this.nombreUsuario);
		usuario.setNombre(this.nombre);
		usuario.setApellidoPaterno(this.apellidoPaterno);
		usuario.setApellidoMaterno(this.apellidoMaterno);
		usuario.setCorreo(this.correo);
		usuario.setCelular(this.celular);
		usuario.setEdad(this.edad);
		usuario.setPassword(this.password);
		usuario.setEstado(1);
		perfil.setId(idPerfil);

		try {

			if (validarUsuario()) {
				this.errorUser = "El usuario ya existe";
			} else if (validarEdad()) {
				this.errorEdad = "Debes ser mayor de edad";
			} else if (validarCorreo()) {
				this.errorEmail = "El correo ya existe";
			} else {

				UsuarioDAO.insertarUsuario(usuario, perfil);
				
				
				for (String p : preferencias) {
					
					int diaP = Integer.parseInt(p);
					PreferenciaDAO.agregarPreferencia(this.nombreUsuario, diaP);
					
				}

				// envio email Registro
				SendEmailUsingGMailSMTP.envioMail(correo, fecha, asunto, texto);

				FacesContext contex = FacesContext.getCurrentInstance();
	            contex.getExternalContext().redirect( "login.xhtml" );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMensajeNuevoUsuario() {
		return mensajeNuevoUsuario;
	}

	public void setMensajeNuevoUsuario(String mensajeNuevoUsuario) {
		this.mensajeNuevoUsuario = mensajeNuevoUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEstado() {
		return estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getErrorEdad() {
		return errorEdad;
	}

	public void setErrorEdad(String errorEdad) {
		this.errorEdad = errorEdad;
	}

	public String getErrorUser() {
		return errorUser;
	}

	public void setErrorUser(String errorUser) {
		this.errorUser = errorUser;
	}

	public String getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public List<String> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<String> preferencias) {
		this.preferencias = preferencias;
	}

}
