package es.upm.dit.tema2.ejercicio4;
import java.util.List;

public class ElementoHTML {
	private String tag; // Ejemplo: "div", "p", "img" 
	private List<ElementoHTML> hijos;
	
	public String getTag() { return this.tag; }	
	public List<ElementoHTML> getHijos() { return this.hijos; } 
	
	public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
		if(elemento ==null || tagBuscado ==null) {return 0;}
		
		int numEtiquetas=0;
		
		if(elemento.getTag().equals(tagBuscado)) {numEtiquetas=1;}
		
		if(elemento.getHijos()!=null) {
			for(ElementoHTML hijo: elemento.getHijos()) {
				numEtiquetas +=contarEtiquetas(hijo,tagBuscado);
			}
			
		}return numEtiquetas;
		
	}

}
