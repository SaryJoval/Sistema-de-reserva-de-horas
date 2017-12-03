package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_de_reserva.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Sucursal;

@ManagedBean(name = "addSucursal")
@RequestScoped
public class AgregarSucursalControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6870601111515018059L;
	private static final Logger LOGGER = Logger.getLogger(AgregarSucursalControlador.class);

	private String nombre;
	private String mensaje;

	public AgregarSucursalControlador() {

		this.mensaje = "";
		this.nombre = "";

	}

	public void agregarSucursal() {

		try {
			SucursalDAO.agregarSucursal(this.nombre);
			this.setMensaje("Agregado con exito");
			LOGGER.info("se agrego la sucursal: " + this.nombre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOGGER.debug("Error desconocido", e);
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error desconocido", e);
		}

	}

	public void eliminar(Sucursal sucursal) {
		try {
			SucursalDAO.eliminarSucursal(sucursal);
			this.mensaje = "La sucursal se elimino con exito";
			LOGGER.info("se agrego la sucursal: " + sucursal.getNombre());
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la sucursal";
			LOGGER.error("Error desconocido", e);
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
