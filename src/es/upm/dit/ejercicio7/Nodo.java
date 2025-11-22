package es.upm.dit.ejercicio7;

public class Nodo {
	int valor;
	Nodo izq, der; 

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public static boolean esBST(Nodo nodo) {
		return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean esBSTAux(Nodo nodo, int min, int max) {
		if (nodo ==null) {return true;}
		
		if(nodo.getValor()<=min || nodo.getValor()>=max) {
			return false;
		}
		return esBSTAux(nodo.izq,min,nodo.getValor()) && esBSTAux(nodo.der,nodo.getValor(),max);
		
	}
}
