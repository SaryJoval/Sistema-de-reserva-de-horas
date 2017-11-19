package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;

public class SucursalDAO {
	public static List<Sucursal> obtenerSucursal() throws SQLException, SinConexionException {
		List<Sucursal> sucursales = new ArrayList<Sucursal>();
		PreparedStatement st = Conexion.getInstancia().prepareStatement("select * from sucursal;");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {

			Sucursal sucursal = new Sucursal();

			sucursal.setIdsucursal(rs.getInt("idsucursal"));
			sucursal.setNombre(rs.getString("nombre"));

			sucursales.add(sucursal);
		}
		return sucursales;
	}

}