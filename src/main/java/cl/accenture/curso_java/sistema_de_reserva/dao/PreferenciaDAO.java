package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Preferencia;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class PreferenciaDAO {

	// agregar preferencia

	public static void agregarPreferencia(String nombreUsuairo, int valor)
			throws SQLException, SinConexionException {

		PreparedStatement st = Conexion.getInstancia()
				.prepareStatement("insert into preferencia (id_usuario,valor) values(?,?);");

		st.setString(1, nombreUsuairo);
		st.setInt(2, valor);

		st.executeUpdate();
	}

	public static List<Preferencia> obtenerPreferencia(String userName) throws SQLException, SinConexionException {

		List<Preferencia> preferencias = new ArrayList<Preferencia>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement("select * from preferencia where id_usuario = ?;");
		st.setString(1, userName);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Preferencia preferencia = new Preferencia();

			preferencia.setIdPreferencia(rs.getInt("idpreferencia"));
			preferencia.setValor(rs.getInt("valor"));

			preferencias.add(preferencia);
		}
		return preferencias;
	}

}
