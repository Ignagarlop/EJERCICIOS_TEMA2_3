package es.upm.dit.tema2.ejercicio6;

public class Palindromo {
	
	public static boolean esPalindromo(String texto) {
		if(texto==null || texto.length()==1) {return true;}
		
		char primer= texto.charAt(0);
		char ultimo=texto.charAt(texto.length()-1);
		
		if(primer!=ultimo) {
			return false;
		}
		else {
			return esPalindromo(texto.substring(1,texto.length()-1));
		}
		
	}

}
