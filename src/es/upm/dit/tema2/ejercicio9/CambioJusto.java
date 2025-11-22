package es.upm.dit.tema2.ejercicio9;

public class CambioJusto {
	
	public static int contarFormasCambio(int objetivo, int[] monedas) {
		int[] valores= {1,2,5};
		return contarAux(objetivo,monedas,valores,2);
	}
	private static int contarAux(int objetivo,int[] monedas,int[]valores,int indexMoneda) {
		if(objetivo==0) {return 1;}
		if(objetivo<0) {return 0;}
		if(indexMoneda<0) {return 0;}
		
		int valorActual = valores[indexMoneda];
		int cantidadDisponible= monedas[indexMoneda];
		int formas=0;
		
		for(int i=0;i<cantidadDisponible;i++) {
			int sumaActual = valorActual*i;
			
			if (sumaActual>objetivo) {
				break;}
				formas +=contarAux(objetivo-sumaActual,monedas,valores,indexMoneda-1);
		}
		return formas;
	}
}
