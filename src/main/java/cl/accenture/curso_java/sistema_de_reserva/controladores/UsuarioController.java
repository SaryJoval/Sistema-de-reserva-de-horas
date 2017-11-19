package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485314226149147415L;
	
	private int idUsuario;
	private String nombreUsuario;
	private String nombre;
	private String password;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private int celular;
	private int edad;
	private Date ultimoIngreso;
	private boolean estado;
	private List<String> preferencias;
	
	private List<Usuario>usuarios;
	private boolean errorNuevo;
	private String mensajeNuevoUsuario;
	
	public UsuarioController() {
		
	}

	public UsuarioController(int idUsuario, String nombreUsuario, String nombre, String password, String apellidoPaterno,
			String apellidoMaterno, String correo, int celular, int edad, Date ultimoIngreso, boolean estado,
			List<String> preferencias, List<Usuario> usuarios, boolean errorNuevo, String mensajeNuevoUsuario) {
		super();
		this.idUsuario= idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.password = password;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correo = correo;
		this.celular = celular;
		this.edad = edad;
		this.ultimoIngreso = ultimoIngreso;
		this.estado = estado;
		this.preferencias = preferencias;
		this.usuarios = usuarios;
		this.errorNuevo = errorNuevo;
		this.mensajeNuevoUsuario = mensajeNuevoUsuario;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int id) {
		this.idUsuario = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getUltimoIngreso() {
		return ultimoIngreso;
	}

	public void setUltimoIngreso(Date ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void guardar() {
		
		Usuario usuario = new Usuario();
	usuario.setNombreUsuario(this.nombreUsuario);
	usuario.setNombre(this.nombre);
	usuario.setApellidoPaterno(this.apellidoPaterno);
	usuario.setApellidoMaterno(this.apellidoMaterno);
	usuario.setEdad(this.edad);
	usuario.setCorreo(this.correo);
	usuario.setCelular(this.celular);
	usuario.setPassword(this.password);
		
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
		this.nombreUsuario="";
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.correo = "";
		this.celular = 0;
		this.edad = 0;
		this.preferencias = new ArrayList<String>();
		
		
	}
	
	public void enlistarPreferencias(){
		
	}
	
	
	

}
