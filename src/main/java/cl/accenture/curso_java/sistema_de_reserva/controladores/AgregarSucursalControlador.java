package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminar(Sucursal sucursal) {
		try {
			SucursalDAO.eliminarSucursal(sucursal);
			this.mensaje = "La sucursal se elimino con exito";
		} catch (Exception e) {
			this.mensaje = "Lo sentimos, Ocurrio un error al eliminar la sucursal";
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
