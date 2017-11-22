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

	public static List<Reserva> obtenerReserva(String usuario) throws SQLException, SinConexionException {
		List<Reserva> reservas = new ArrayList<Reserva>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement(""
				+ "SELECT t1.idreserva, t1.fechaReserva, t1.servicio, t1.sucursal, t2.hora"
				+ " FROM reserva t1 INNER JOIN reserva_hora t2 ON t1.id_reserva_hora = t2.idreserva_hora"
				+ " where id_usuario=?;");
		st.setString(1, usuario);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Reserva reserva = new Reserva();

			reserva.setIdreserva(rs.getInt("idreserva"));
			reserva.setFechaReserva(rs.getDate("fechaReserva"));
			reserva.setServicio(rs.getString("servicio"));
			reserva.setSucursal(rs.getString("sucursal"));
			reserva.setHora(rs.getString("hora"));

			reservas.add(reserva);
		}
		return reservas;
	}

	public static void agregarReserva(Reserva reserva, Sucursal sucursal, Usuario usuario) throws SQLException, SinConexionException {

		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("insert into reserva (fechaReserva,servicio,sucursal,hora,id_usuario) values(?,?,?,?,?);");

		st.setDate(1, (Date) reserva.getFechaReserva());
		st.setString(2, reserva.getServicio());
		st.setString(3, sucursal.getNombre());
		st.setString(4, reserva.getHora());
		st.setString(5, usuario.getNombreUsuario());

		st.executeUpdate();
	}

}
