package es.upm.dit.tema3.ejercicio3;

public class HebraLectora extends Thread {
	private final String nombre;
	private RecursoCompartido recurso;
	private final Prioridad prioridad;
	
	public HebraLectora(String nombre, RecursoCompartido recurso,Prioridad p) {
		this.nombre=nombre;
		this.recurso=recurso;
		this.prioridad=p;
	}
	@Override
	public void run() {
		try {
			recurso.Leer(nombre,prioridad);
		}
		catch(InterruptedException e) {}
	}
	
}

