package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Feriado;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;

public class FeriadoDAO {

	public static List<Feriado> obtenerFeriados() throws SQLException, SinConexionException {

		List<Feriado> diasFeriados = new ArrayList<Feriado>();

		PreparedStatement st = Conexion.getInstancia().prepareStatement("SELECT * FROM feriado");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			
			Feriado feriado = new Feriado();
			
			feriado.setIdFeriado(rs.getInt("idferiado"));
			feriado.setFecha(rs.getString("fecha"));
			feriado.setDescripcion(rs.getString("descripcion"));
			
			diasFeriados.add(feriado);

		}

		return diasFeriados;
	}

	public static void agregarFeriado(String fecha, String descripcion) throws SQLException, SinConexionException {

		PreparedStatement st = Conexion.getInstancia().prepareStatement("insert into feriado (fecha,descripcion) values(?,?)");

		st.setString(1, fecha);
		st.setString(2, descripcion);

		st.executeUpdate();

	}

	public static void eliminarFeriado(Feriado feriado) throws SQLException, SinConexionException {
		PreparedStatement st = Conexion.getInstancia().prepareStatement("delete from feriado where idferiado = ?;");
		st.setInt(1, feriado.getIdFeriado());
		st.executeUpdate();
	}

}
