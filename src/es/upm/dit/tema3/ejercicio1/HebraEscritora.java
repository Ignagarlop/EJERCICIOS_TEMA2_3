package es.upm.dit.tema3.ejercicio1;

public class HebraEscritora extends Thread {
	private final String nombre;
	private final RecursoCompartido recurso;
	
	public HebraEscritora(String nombre, RecursoCompartido recurso) {
		this.nombre=nombre;
		this.recurso=recurso;
	}
	public void Run() {
		try{
			recurso.Escribir(nombre);
		}
		catch(InterruptedException e) {}
	}
}
