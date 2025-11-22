package es.upm.dit.tema2.ejercicio3;
import java.util.List;

public class Habilidad {
	private String id;
	private int costePuntos; // Coste para desbloquear esta habilidad
	private List<Habilidad> desbloqueables; // Habilidades que dependen de esta
	
	public int getCoste() { return this.costePuntos; }
	public List<Habilidad> getDesbloqueables() { return this.desbloqueables; }
	
	public static int costeRamaCompleta(Habilidad raiz) {
		if(raiz==null) {return 0;}
		int costeTotal = raiz.getCoste();
		if(raiz.getDesbloqueables()!=null) {
			for(Habilidad desbloqueables:raiz.getDesbloqueables()) {
				costeTotal+=costeRamaCompleta(desbloqueables);
				}
			}return costeTotal;
		}
}
