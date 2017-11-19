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
		PreparedStatement st = Conexion.getInstancia().prepareStatement("insert into usuario(nombreUsuario, nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, password) values(?,?,?,?,?,?,?,?);");
		st.setString(1, usuario.getNombreUsuario());
		st.setString(2, usuario.getNombre());
		st.setString(3, usuario.getApellidoPaterno());
		st.setString(4, usuario.getApellidoPaterno());
		st.setString(5, usuario.getCorreo());
		st.setInt(6, usuario.getCelular());
		st.setInt(7, usuario.getEdad());
		st.setString(8, usuario.getNombreUsuario());

		st.executeUpdate();
	}
}