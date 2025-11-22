package es.upm.dit.tema2;

public class Archivo {
	private String nombre;
	private double pesoMB; // Tamaño en Megabytes
	
	public Archivo(String nombre, double peso) { 
		this.nombre= nombre;
		this.pesoMB=peso;
		}
	
	public double getPesoMB() { return this.pesoMB; }

}
