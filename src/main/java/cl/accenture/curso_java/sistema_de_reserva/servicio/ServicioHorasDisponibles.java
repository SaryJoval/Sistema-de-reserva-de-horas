/**
 * 
 */
package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Luis
 *
 */
public final class ServicioHorasDisponibles {

	/**
	 * 
	 * @return
	 */

	public static List<String> calcularHorasDisponibles(String horaInicio, String horaFinal, int bloque) {

		DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");
		List<String> horas = new ArrayList<String>();

		try {
			Date horaF = formatoHora.parse(horaFinal);
			Date horaI = formatoHora.parse(horaInicio);

			while (!horaI.equals(horaF)) {

				Calendar cal = Calendar.getInstance();
				cal.setTime(horaI);
				cal.add(Calendar.MINUTE, bloque);

				horaI = cal.getTime();

				SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
				String hora = formato.format(cal.getTime());

				horas.add(hora);

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return horas;
	}

	public static List<String> obtenerHorasDisponibles(List<String> horasReservadas, List<String> horasDisponibles) {

		Iterator<String> it = horasDisponibles.iterator();
		
		while(it.hasNext()) {
			
			String hora = it.next();
			
			for (String h : horasReservadas) {
				
				if (h.equals(hora)) {
					
					it.remove();				
				}				
			}					
		}
		
		return horasDisponibles;
	}
}
