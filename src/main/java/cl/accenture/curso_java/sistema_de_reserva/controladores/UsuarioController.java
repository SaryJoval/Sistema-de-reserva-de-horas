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
public class UsuarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5485314226149147415L;
	
	private String id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String celular;
	private int edad;
	private boolean estado;
	private List<String>preferencias;
	private List<Usuario>usuarios;
	
	private boolean errorNuevo;
	private String mensajeNuevoUsuario;
	
	
	
	public UsuarioController() {
		
	}
	public UsuarioController(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String correo,
			String celular, int edad, boolean estado, List<String> preferencias, List<Usuario> usuarios) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		usuario.setPreferencias(this.preferencias);
		
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
		this.id = "";
		this.nombre = "";
		this.apellidoPaterno = "";
		this.apellidoMaterno = "";
		this.correo = "";
		this.celular = "";
		this.edad = 0;
		this.preferencias = new ArrayList<String>();
		
		
	}
	
	public void enlistarPreferencias(){
		
	}
	
	
	

}
