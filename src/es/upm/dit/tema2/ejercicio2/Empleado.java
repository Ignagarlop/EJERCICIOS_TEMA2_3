package es.upm.dit.tema2.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private double salario;
	private List<Empleado> subordinados; // Lista de empleados a su cargo
	
	public Empleado(String nombre, double salario) { 
		this.nombre=nombre;
		this.salario=salario;
		this.subordinados= new ArrayList<Empleado>();
	}
	public double getSalario() { return this.salario; }
	public List<Empleado> getSubordinados() { return this.subordinados; }
	
	public static double presupuestoEquipo(Empleado jefe) {
		if(jefe==null) {return 0.0;}
		
		double presuPuestoTeam=jefe.getSalario();
		//Caso base
		if(jefe.getSubordinados()!= null) {
			for(Empleado subordinados: jefe.getSubordinados()) {
				presuPuestoTeam += presupuestoEquipo(subordinados);
			}
		}return presuPuestoTeam;
	}
	
}
