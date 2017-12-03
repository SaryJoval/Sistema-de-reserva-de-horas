package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class Prueba {

	public static void main(String[] args) throws Exception {

		MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
		md.update("123456".getBytes());
		byte[] digest = md.digest();

		// Se escribe byte a byte en hexadecimal
		for (byte b : digest) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();

		// Se escribe codificado base 64. Se necesita la librería
		// commons-codec-x.x.x.jar de Apache
		byte[] encoded = Base64.encodeBase64(digest);
		System.out.println(new String(encoded));
	}

}
