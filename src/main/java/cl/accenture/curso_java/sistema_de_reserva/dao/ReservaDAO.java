package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

public class ReservaDAO {

	// obtener lista de horas por fecha <- -

	public static List<String> obenerHorasReservadas(String fecha) throws SQLException, SinConexionException {
		List<String> horasOcupadas = new ArrayList<String>();
		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("select hora " + "from reserva " + "where fechaReserva = ?");
		st.setString(1, fecha);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			horasOcupadas.add(rs.getString("hora"));

		}
		return horasOcupadas;
	}

	// obtener Reservas <--

	public static List<Reserva> obtenerReserva(String usuario) throws SQLException, SinConexionException {
		List<Reserva> reservas = new ArrayList<Reserva>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement("SELECT * FROM reserva where id_usuario=?;");
		st.setString(1, usuario);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Reserva reserva = new Reserva();

			reserva.setIdreserva(rs.getInt("idreserva"));
			reserva.setFechaReserva(rs.getDate("fechaReserva"));
			reserva.setServicio(rs.getString("servicio"));
			reserva.setHora(rs.getString("hora"));
			reserva.setSucursal(rs.getString("sucursal"));

			reservas.add(reserva);
		}
		return reservas;
	}

	// agregar Reserva <--

	public static void agregarReserva(Date fechaReserva, String servicio, String sucursal, Usuario usuario, String hora)
			throws SQLException, SinConexionException {

		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into reserva (fechaReserva,servicio,sucursal,id_usuario,hora) values(?,?,?,?,?);");
		
		st.setDate(1, fechaReserva);
		st.setString(2, servicio);
		st.setString(3, sucursal);
		st.setString(4, usuario.getNombreUsuario());
		st.setString(5, hora);

		st.executeUpdate();
	}

}
