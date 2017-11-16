/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

/**
 * @author Administrador
 *private int id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String celular;
	private int edad;
	private boolean estado;
	private String preferencias;
 */
public class UsuarioDAO {

	private Conexion conexion;

	public UsuarioDAO() {

	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public void insertarUsuario(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement("insert into usuario(id, nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, estado, nombreUsuario) values(?,?,?,?,?,?,?,?,?);");
		st.setString(1, usuario.getId());
		st.setString(2, usuario.getNombre());
		st.setString(3, usuario.getApellidoPaterno());
		st.setString(4, usuario.getApellidoPaterno());
		st.setString(5, usuario.getCorreo());
		st.setString(6, usuario.getCelular());
		st.setInt(7, usuario.getEdad());
		st.setBoolean(8, usuario.isEstado());
		st.setString(9, usuario.getNombreUsuario());

		st.executeUpdate();
	}
}