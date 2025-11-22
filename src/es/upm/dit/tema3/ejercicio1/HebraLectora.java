package es.upm.dit.tema3.ejercicio1;

public class HebraLectora extends Thread {
	private final String nombre;
	private RecursoCompartido recurso;
	
	public HebraLectora(String nombre, RecursoCompartido recurso) {
		this.nombre=nombre;
		this.recurso=recurso;
	}
	
	public void Run() {
		try {
			recurso.Leer(nombre);
		}
		catch(InterruptedException e) {}
	}
	
}
