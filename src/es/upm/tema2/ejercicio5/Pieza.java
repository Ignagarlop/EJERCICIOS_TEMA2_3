package es.upm.tema2.ejercicio5;
import java.util.List;


public class Pieza {
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componentes; // Piezas necesarias para montar esta
	
	public boolean isDefectuosa() { return this.esDefectuosa; }
	public List<Pieza> getComponentes() { return this.componentes; }
	
	public static boolean contieneDefectos(Pieza piezaPrincipal) {
		if(piezaPrincipal==null) {System.out.println("Pieza no válida");}
		
		if(piezaPrincipal.isDefectuosa()) {return true;}
		
		if(piezaPrincipal.getComponentes()!=null) {
			for(Pieza subcomponentes: piezaPrincipal.getComponentes()) {
				if(contieneDefectos(subcomponentes)) {return true;}
			}
		}return false;
	}

}
