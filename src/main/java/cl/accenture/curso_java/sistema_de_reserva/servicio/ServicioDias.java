package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Preferencia;

public final class ServicioDias {

	public static List<String> calcularDiasDelMes(String fechaFin, List<Preferencia> preferencias) throws ParseException {
		
		int diaSemana = 0;
		List<String> dates = new ArrayList<String>();
		
		//formater fechas
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		//obtener fecha actual
		Calendar actual = GregorianCalendar.getInstance();
		actual.getTime();
					
		//parsear la fecha fin a date
		Calendar cfin = Calendar.getInstance();
		cfin.setTime(formatter.parse(fechaFin));
		
		for (Preferencia preferencia : preferencias) {
			
			diaSemana = preferencia.getValor();
			
			while (!cfin.before(actual)) {

				if (actual.get(Calendar.DAY_OF_WEEK) == diaSemana) {
					dates.add(formatter.format(actual.getTime()));
				}
				actual.add(Calendar.DATE, 1);
			}
		}
		
		return dates;
	}

}
