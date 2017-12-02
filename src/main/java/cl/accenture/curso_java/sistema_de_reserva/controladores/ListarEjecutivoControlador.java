package cl.accenture.curso_java.sistema_de_reserva.controladores;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import cl.accenture.curso_java.sistema_de_reserva.dao.UsuarioDAO;
import cl.accenture.curso_java.sistema_de_reserva.modelo.SinConexionException;
import cl.accenture.curso_java.sistema_de_reserva.modelo.Usuario;

@ManagedBean
@RequestScoped
public class ListarEjecutivoControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6458120473107931313L;

	private List<Usuario> usuarios;

	public ListarEjecutivoControlador() {
		obtenerUsuarios();
	}

	public void obtenerUsuarios() {

		try {
			this.usuarios = UsuarioDAO.obtenerUsuarios(2);

			for (Usuario usuario : usuarios) {

				if (usuario.getEstado().equals("Activo")) {

					usuario.setValorEstado(true);

				} else {
					usuario.setValorEstado(false);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SinConexionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cambiarEstado(Usuario usuario) {

		String estado = "";

		if (usuario.getEstado().equals("Activo")) {

			usuario.setValorEstado(false);
			estado = "Inactivo";

		} else {

			usuario.setValorEstado(true);
			estado = "Activo";

		}

		try {
			UsuarioDAO.cambiarEstado(usuario, estado);
		} catch (Exception e) {

		}

	}

	private void recargar() {

		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
