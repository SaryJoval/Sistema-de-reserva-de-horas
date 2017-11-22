package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.ReservaHora;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class ReservaHoraDAO {
	
	public static List<ReservaHora> obtenerHorasDisponibles(String fecha) throws SQLException, SinConexionException {
		
		List<ReservaHora> reservasHoras = new ArrayList<ReservaHora>();
		
		PreparedStatement st = Conexion.getInstancia().prepareStatement(""
				+ "select t1.hora, t1.idreserva_hora "
				+ "from reserva_hora t1 inner join reserva t2 "
				+ "on t1.idreserva_hora <> t2.id_reserva_hora "
				+ "where t2.fechaReserva = ?");
		
		st.setString(1, fecha);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			ReservaHora reservaHora = new ReservaHora();
			
			reservaHora.setHora(rs.getString("hora"));
			reservaHora.setIdReservaHora(rs.getInt("idreserva_hora"));

			reservasHoras.add(reservaHora);
		}
		return reservasHoras;
	}

}
