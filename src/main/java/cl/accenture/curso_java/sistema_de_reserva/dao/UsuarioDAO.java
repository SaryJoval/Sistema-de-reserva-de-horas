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
<<<<<<< HEAD
 
=======
 *private int id;
	private String nombre;
	private String nombreUsuario;
	private String password;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String celular;
	private int edad;
	private boolean estado;
	private String preferencias;
>>>>>>> c57243f38d61daff0c1fbb0648dfbe07e83f4f9e
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
<<<<<<< HEAD
		PreparedStatement st = Conexion.getInstancia().prepareStatement("insert into usuario(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, password) values(?,?,?,?,?,?,?,?);");
		st.setString(1, usuario.getNombreUsuario());
=======
		PreparedStatement st = Conexion.getInstancia().prepareStatement("insert into usuario(id, nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, estado, nombreUsuario, password) values(?,?,?,?,?,?,?,?,?,?);");
		st.setString(1, usuario.getId());
>>>>>>> c57243f38d61daff0c1fbb0648dfbe07e83f4f9e
		st.setString(2, usuario.getNombre());
		st.setString(3, usuario.getApellidoPaterno());
		st.setString(4, usuario.getApellidoPaterno());
		st.setString(5, usuario.getCorreo());
		st.setInt(6, usuario.getCelular());
		st.setInt(7, usuario.getEdad());
<<<<<<< HEAD
		st.setString(8, usuario.getNombreUsuario());
=======
		st.setBoolean(8, usuario.isEstado());
		st.setString(9, usuario.getNombreUsuario());
		st.setString(10, usuario.getPassword());
>>>>>>> c57243f38d61daff0c1fbb0648dfbe07e83f4f9e

		st.executeUpdate();
	}
}