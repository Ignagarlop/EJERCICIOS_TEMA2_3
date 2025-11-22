package es.upm.dit.tema2.ejercicio8;

public class NodoLista {
	  int dato; 
	  NodoLista siguiente; 
	  
	  public static NodoLista invertirRecursivo(NodoLista actual) {
		// Caso base: lista vacía o único elemento
		  if (actual == null || actual.siguiente == null) {
		      return actual;
		  }
		  // Paso recursivo 
			  NodoLista nuevaCabecera = invertirRecursivo(actual.siguiente);
			  //Invertimos
			  actual.siguiente.siguiente=actual;
			  actual.siguiente=null;
		  return nuevaCabecera;
		  
	  }
}
