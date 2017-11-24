/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Perfil;
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

	public static Usuario validar(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("select * from usuario where " + "nombreUsuario =?  AND " + "password = ?;");
		st.setString(1, usuario.getNombreUsuario());
		st.setString(2, usuario.getPassword());
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			Perfil perfil = PerfilDAO.obtenerPerfil(rs.getInt("id_perfil"));
			usuario.setPerfil(perfil);
			usuario.setUltimoIngreso(rs.getDate("ultimoIngreso"));
			usuario.setIntentosFallidos(rs.getInt("intentosFallidos"));
			return usuario;
		}
		throw new ObjetoNoEncontradoException("Usuario y/o password incorrectos");
	}

	public static void insertarUsuario(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into usuario(nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, nombreUsuario, password) values(?,?,?,?,?,?,?,?);");
		
		st.setString(1, usuario.getNombre());
		st.setString(2, usuario.getApellidoPaterno());
		st.setString(3, usuario.getApellidoMaterno());
		st.setString(4, usuario.getCorreo());
		st.setInt(5, usuario.getCelular());
		st.setInt(6, usuario.getEdad());
		st.setString(7, usuario.getNombreUsuario());
		st.setString(8, usuario.getPassword());

		st.executeUpdate();
	}

	public static List<Usuario> obtenerUsuarios() throws SQLException, SinConexionException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement("select * from usuario");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Usuario usuario = new Usuario();
			Perfil perfil = PerfilDAO.obtenerPerfil(rs.getInt("id_perfil"));
			usuario.setPerfil(perfil);
			usuario.setNombreUsuario(rs.getString("nombreUsuario"));
			usuario.setUltimoIngreso(rs.getTimestamp("ultimoIngreso"));
			usuario.setIntentosFallidos(rs.getInt("intentosFallidos"));
			usuarios.add(usuario);
		}
		return usuarios;
	}

	public static void actualizarUltimoIngreso(Usuario usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("update usuario set ultimoIngreso=? where nombreUsuario = ?;");
		st.setTimestamp(1, new Timestamp(new java.util.Date().getTime()));
		// st.setDate(1, new Date( new java.util.Date().getTime() ));
		st.setString(2, usuario.getNombreUsuario());
		st.executeUpdate();
	}

	public static Usuario obtenerUsuario(String usuario) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement("select * from usuario where nombreUsuario = ?;");
		st.setString(1, usuario);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			
			Usuario u = new Usuario();
			
			u.setNombre(rs.getString("nombre"));
			u.setApellidoPaterno(rs.getString("apellidoPaterno"));
			u.setApellidoMaterno(rs.getString("apellidoMaterno"));
			u.setCorreo(rs.getString("correo"));
			u.setEdad(rs.getInt("edad"));
			u.setNombreUsuario(rs.getString("nombreUsuario"));
			
			return u;
		}
		throw new ObjetoNoEncontradoException("Perfil no existe");
	}
}