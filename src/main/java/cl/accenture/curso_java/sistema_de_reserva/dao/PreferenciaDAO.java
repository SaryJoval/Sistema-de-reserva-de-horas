package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class PreferenciaDAO {
	
	public static void insertarPreferencias (String valor) throws SQLException, SinConexionException {
		PreparedStatement ps = Conexion.getInstancia().prepareStatement("insert into preferencia (nombreUsuario, valor)values(?,?)");
		
		ps.set
	}

}
