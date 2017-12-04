package cl.accenture.curso_java.sistema_de_reserva.servicio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class ServicioEncriptar {

	public static void main(String[] args) throws Exception {
		

	}

	public static String encriptar(String texto) throws NoSuchAlgorithmException {
		
		
		MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
		md.update(texto.getBytes());
		byte[] digest = md.digest();

		byte[] encoded = Base64.encodeBase64(digest);
		return new String(encoded);
	}
}
