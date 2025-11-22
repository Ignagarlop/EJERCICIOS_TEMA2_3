package es.upm.dit.tema3.ejercicio3;


public class HebraEscriotra extends Thread {
	private final String nombre;
	private final RecursoCompartido recurso;
	private final Prioridad p;
	public HebraEscriotra(String nombre, RecursoCompartido recurso,Prioridad p) {
		this.nombre=nombre;
		this.recurso=recurso;
		this.p=p;
	}
	@Override
	public void run() {
		try{
			recurso.Escribir(nombre,p);
		}
		catch(InterruptedException e) {}
	}
}

