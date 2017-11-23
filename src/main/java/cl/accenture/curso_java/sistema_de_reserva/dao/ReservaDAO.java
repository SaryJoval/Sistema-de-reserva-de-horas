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

	// obtener lista de horas por fecha

	public static List<String> obenerHorasOcupadas(Date fecha) throws SQLException, SinConexionException {
		List<String> horasOcupadas = new ArrayList<String>();
		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("select hora "
						+ "from reserva "
						+ "where fecha = ?");
		st.setDate(1, fecha);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			
			horasOcupadas.add(rs.getString("hora"));
			
		}
		return horasOcupadas;
	}

	public static void agregarReserva(Reserva reserva, Sucursal sucursal, Usuario usuario)
			throws SQLException, SinConexionException {

		PreparedStatement st = Conexion.getInstancia().prepareStatement(
				"insert into reserva (fechaReserva,servicio,sucursal,hora,id_usuario) values(?,?,?,?,?);");

		st.setDate(1, (Date) reserva.getFechaReserva());
		st.setString(2, reserva.getServicio());
		st.setString(3, sucursal.getNombre());
		st.setString(4, reserva.getHora());
		st.setString(5, usuario.getNombreUsuario());

		st.executeUpdate();
	}

}
