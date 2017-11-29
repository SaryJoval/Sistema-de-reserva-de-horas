package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import cl.accenture.curso_java.sistema_de_reserva.modelo.Preferencia;

public final class ServicioDias {

	public static List<Preferencia> calcularDiasDelMes(String fechaFin, List<Preferencia> preferencias)
			throws ParseException {

		int diaSemana = 0;
		List<Preferencia> dates = new ArrayList<Preferencia>();
		
		// formater fechas
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		// parsear la fechafin a date
		Calendar cfin = Calendar.getInstance();
		cfin.setTime(formatter.parse(fechaFin));

		for (Preferencia preferencia : preferencias) {

			diaSemana = preferencia.getValor();

			// obtener fecha actual
			Calendar actual = GregorianCalendar.getInstance();
			actual.getTime();

			while (!cfin.before(actual)) {
				
				Preferencia p = new Preferencia();

				if (actual.get(Calendar.DAY_OF_WEEK) == diaSemana) {
					
					String dia = formatter.format(actual.getTime());
					String diaNombre = "";
					
					GregorianCalendar cal = new GregorianCalendar();
					cal.get(Calendar.DAY_OF_MONTH);
					
					if (preferencia.getValor() == 2) {
						diaNombre = "Lunes";
					}else if(preferencia.getValor() == 3) {
						diaNombre = "Martes";
					}else if(preferencia.getValor() == 4) {
						diaNombre = "Miercoles";
					}else if(preferencia.getValor() == 5) {
						diaNombre = "Jueves";
					}else if(preferencia.getValor() == 6) {
						diaNombre = "Viernes";
					}
					
					p.setDia(dia);
					p.setNombreDia(diaNombre);
					
					dates.add(p);
					
				}
				actual.add(Calendar.DATE, 1);
			}
		}

		return dates;
	}

}
