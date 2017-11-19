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

 * @author Administrador private int id; private String nombre; private String
 *         apellidoPaterno; private String apellidoMaterno; private String
 *         correo; private String celular; private int edad; private boolean
 *         estado; private String preferencias;
=======
 * @author Administrador
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

 */
public class UsuarioDAO {

	// Validar Usuario

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
				"insert into usuario(id, nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad, estado, nombreUsuario) values(?,?,?,?,?,?,?,?,?);");

		st.setString(1, usuario.getId());
		st.setString(2, usuario.getNombre());
		st.setString(3, usuario.getApellidoPaterno());
		st.setString(4, usuario.getApellidoPaterno());
		st.setString(5, usuario.getCorreo());
		st.setInt(6, usuario.getCelular());
		st.setInt(7, usuario.getEdad());
		st.setInt(8, 1);
		st.setString(9, usuario.getNombreUsuario());
		st.setString(10, usuario.getPassword());

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
}