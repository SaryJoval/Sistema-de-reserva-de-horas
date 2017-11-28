package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class FeriadoDAO {

	public static List<String> obtenerFeriados() throws SQLException, SinConexionException {
		
		List<String> diasFeriados = new ArrayList<String>();
		
		PreparedStatement st = Conexion.getInstancia().prepareStatement("SELECT * FROM feriado");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			
			diasFeriados.add(rs.getString("fecha"));
	
		}
		
		return diasFeriados;
	}

}
