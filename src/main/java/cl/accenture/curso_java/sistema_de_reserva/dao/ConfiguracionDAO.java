package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Configuracion;

import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class ConfiguracionDAO {
	
	public static List<Configuracion> obtenerConfiguraciones() throws SQLException, SinConexionException {
		List<Configuracion> configuraciones = new ArrayList<Configuracion>();
		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("select * from configuracion;");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {

			Configuracion config = new Configuracion();
			
			config.setClave(rs.getString("clave"));
			config.setValor(rs.getString("valor"));
			
			configuraciones.add(config);
		}
		
		return configuraciones;
	}
	
	

}
