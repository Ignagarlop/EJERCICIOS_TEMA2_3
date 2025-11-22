package es.upm.dit.tema2.ejercicio10;

public class NodoLista {
	private int dato;
	private NodoLista siguiente;
	
	public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
		
			// Casos base: si una lista es nula, devolvemos la otra
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;

			// Paso recursivo: comparar cabeceras
			if (l1.dato <= l2.dato) {
				// l1 es menor: será la cabecera actual.
				// Su siguiente será el resultado de fusionar el resto de l1 con l2
				l1.siguiente = fusionarListas(l1.siguiente, l2);
				return l1;
			} else {
				// l2 es menor
				l2.siguiente = fusionarListas(l1, l2.siguiente);
				return l2;
			}
		}
	}


