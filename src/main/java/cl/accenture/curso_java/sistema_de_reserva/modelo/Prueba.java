package cl.accenture.curso_java.sistema_de_reserva.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Prueba {

	public static void main(String[] args) throws ParseException {

		String fechaInicio = "01/12/2017";
		String fechaFin = "31/12/2017";
		int dia = 4;
		int mes = 6;
		
		//obtener fecha actual;
		Calendar actual = GregorianCalendar.getInstance();
		System.out.println("Fecha actual " + actual.getTime());
		
		//obtener cantidad de dias de un mes
		Calendar cal = new GregorianCalendar(2010, mes, 1); 
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
		System.out.println(days);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		List<String> dates = new ArrayList<String>();

		Calendar cini = Calendar.getInstance();
		cini.setTime(formatter.parse(fechaInicio));
		Calendar cfin = Calendar.getInstance();
		cfin.setTime(formatter.parse(fechaFin));


		while (!cfin.before(cini)) {

			if (cini.get(Calendar.DAY_OF_WEEK) == dia) {
				System.out.println("---------->" + cini.getTime().toString() + " es Lunes ");
				dates.add(formatter.format(cini.getTime()));
			}
			cini.add(Calendar.DATE, 1);
		}
		for (String c : dates) {
			System.out.println("Fecha: " + c);
		}
	}
}
