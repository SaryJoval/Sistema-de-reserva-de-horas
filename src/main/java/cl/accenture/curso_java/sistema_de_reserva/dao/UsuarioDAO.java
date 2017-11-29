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
 * @author Sara

 */
public class UsuarioDAO {
	
	private static int intentos = 0;

	public static Usuario validar(Usuario usuario) throws SQLException, SinConexionException {
		
		intentos ++;
		
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"select * from usuario where "+
				"nombreUsuario =?  AND "+  
				"password = ?");
		st.setString(1,  usuario.getNombreUsuario() );
		st.setString(2,  usuario.getPassword() );
		ResultSet rs = st.executeQuery();
		if( rs.next() ){
			Perfil perfil =PerfilDAO.obtenerPerfil( rs.getInt("id_perfil") ) ;
			usuario.setPerfil(perfil);
			usuario.setUltimoIngreso( rs.getDate("ultimoIngreso") );
			usuario.setIntentosFallidos(  rs.getInt("intentosFallidos" ) );
			usuario.setEstado(rs.getInt("estado"));
			return usuario;
		}
		
		usuario.setIntentosFallidos(intentos);	
		throw new ObjetoNoEncontradoException("Usuario y/o password incorrectos");
	}
	
	public static boolean nombreUsuario_existe(String nombre) throws SQLException, SinConexionException {
		PreparedStatement ps = Conexion.getInstancia().prepareStatement("select * from usuario where nombreUsuario =?");
		ps.setString(1, nombre);
		ResultSet rs = ps.executeQuery();
		boolean nombreUsuario_existe = false;
		if(rs.next()) {
			nombreUsuario_existe = true;
		}
		return nombreUsuario_existe;
	}
	
	public static boolean correo_existe(String email) throws SQLException, SinConexionException {
		PreparedStatement ps = Conexion.getInstancia().prepareStatement("select * from usuario where correo =?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		boolean correo_existe = false;
		if(rs.next()) {
			correo_existe = true;
		}
		return correo_existe;
	}
	
	public static void insertarUsuario(Usuario usuario,  Perfil perfil) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into usuario(nombre, apellidoPaterno, apellidoMaterno, correo, celular, edad,estado,nombreUsuario, password,id_perfil) values(?,?,?,?,?,?,?,?,?,?);");
		
		st.setString(1, usuario.getNombre());
		st.setString(2, usuario.getApellidoPaterno());
		st.setString(3, usuario.getApellidoMaterno());
		st.setString(4, usuario.getCorreo());
		st.setInt(5, usuario.getCelular());
		st.setInt(6, usuario.getEdad());
		st.setInt(5, 1);
		st.setString(8, usuario.getNombreUsuario());
		st.setString(9, usuario.getPassword());
		st.setInt(10, perfil.getId());

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
			u.setCelular(rs.getInt("celular"));
			
			return u;
		}
		throw new ObjetoNoEncontradoException("Perfil no existe");
	}
}