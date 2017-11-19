/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.dao;

import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Conexion;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Preferencia;

/**
 * @author PC
 *
 */
public class PreferenciaDAO {
	
	private Conexion conexion;

	public PreferenciaDAO(Conexion conexion) {
		super();
		this.conexion = conexion;
	}
	
	public PreferenciaDAO() {
		
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public List<Preferencia> obtenerPreferencias(){
	List <Preferencia>preferencias = new ArrayList<Preferencia>();
	PreparedStatement st = 
		
	}
}
