package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485314226149147415L;

	private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private int celular;
	private int edad;
	private int estado;
	
	private List<String> preferencias;
	private List<Usuario> usuarios;

	private boolean errorNuevo;
	private String mensajeNuevoUsuario;

	public UsuarioController() {

	}

	public UsuarioController(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
			int celular, int edad, int estado, List<String> preferencias, List<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.celular = celular;
		this.edad = edad;
		this.estado = estado;
		this.preferencias = preferencias;
		this.usuarios = usuarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<String> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<String> preferencias) {
		this.preferencias = preferencias;
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

	public boolean isErrorNuevo() {
		return errorNuevo;
	}

	public void setErrorNuevo(boolean errorNuevo) {
		this.errorNuevo = errorNuevo;
	}

	public String getMensajeNuevoUsuario() {
		return mensajeNuevoUsuario;
	}

	public void setMensajeNuevoUsuario(String mensajeNuevoUsuario) {
		this.mensajeNuevoUsuario = mensajeNuevoUsuario;
	}

	public void guardar() {

		Usuario usuario = new Usuario();
		usuario.setId(this.id);
		usuario.setNombre(this.nombre);
		usuario.setApellidoPaterno(this.apellidoPaterno);
		usuario.setApellidoPaterno(this.apellidoPaterno);
		usuario.setCorreo(this.correo);
		usuario.setCelular(this.celular);
		usuario.setEdad(this.edad);
		usuario.setEstado(this.estado);

		UsuarioDAO dao = new UsuarioDAO();

		try {
			dao.insertarUsuario(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limpiar() {
		this.id = 0;
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.correo = "";
		this.celular = 0;
		this.edad = 0;
		this.preferencias = new ArrayList<String>();

	}

	public void enlistarPreferencias() {

	}

}
