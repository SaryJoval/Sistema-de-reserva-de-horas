package cl.accenture.curso_java.sistema_de_reserva.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Reserva;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;


public class ReservaDAO {
	
	//listar todas las reservas del sistema // Todos los usuarios
	
	public static List<Reserva> obtenerReservas() throws SQLException, SinConexionException{
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		PreparedStatement st = Conexion.getInstancia().prepareStatement(""
				+ "select * from reserva");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			Reserva reserva = new Reserva();
			reserva.setIdReserva(rs.getInt("idreserva"));
			reserva.setFechaReserva(rs.getDate("fechaReserva"));
			reserva.setFechaActual(rs.getDate("fechaAcutal"));
			reserva.setServicio(rs.getString("servicio"));
			reservas.add(reserva);
		}
		
		return reservas;
		
	}
	
	public static void agregarReserva(Reserva reserva, Sucursal sucursal) throws SQLException, SinConexionException {
		
		PreparedStatement st = Conexion.getInstancia().prepareStatement(""
				+ "insert into reserva values (?,?,?,?);");
		
		st.setInt(1, sucursal.getIdSucursal());
		st.setDate(2, (java.sql.Date) reserva.getFechaReserva());
		st.setDate(3, (java.sql.Date) reserva.getFechaActual());
		st.setString(4, reserva.getServicio());
		
		st.executeUpdate();
		
	}
	
	
	
}
