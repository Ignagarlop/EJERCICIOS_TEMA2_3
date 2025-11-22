package es.upm.dit.tema2;
import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Archivo> archivos; // Archivos directos en esta carpeta private
	List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
	
	public Carpeta(String nombre) { 
		this.nombre=nombre;
		this.archivos = new ArrayList<Archivo>();
		this.subcarpetas= new ArrayList<Carpeta>();
	}
	public List<Archivo> getArchivos() { return this.archivos; } 
	public List<Carpeta> getSubcarpetas() { return this.subcarpetas; }
	
	public static double calcularPesoTotal(Carpeta inicio) {
		if(inicio==null) {return 0.0;}
		
		double pesoTotal=0.0;
		for(Archivo archives: inicio.getArchivos()) {
			pesoTotal += archives.getPesoMB();
		}
		//Caso base
		if(inicio.getSubcarpetas()==null) {
			return pesoTotal;
		}
		else {
			for(Carpeta subcarpetas:inicio.getSubcarpetas()){
				pesoTotal +=calcularPesoTotal(subcarpetas);	
			}
		}return pesoTotal;
	}
}
