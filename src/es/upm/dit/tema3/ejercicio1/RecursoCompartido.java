package es.upm.dit.tema3.ejercicio1;

public class RecursoCompartido {
	private Integer entero = null;
	
	private boolean escribiendo=false;
	private int numLectores = 0;
	
	//Lectura
	public void Leer(String nombreLector) throws InterruptedException{
		this.accesoLectura(nombreLector);
		System.out.println("El lector:"+ nombreLector+"está leyendo"+this.entero);
		Thread.sleep((long)(Math.random()*500));
		this.terminaLectura(nombreLector);
	}
	 private synchronized void accesoLectura(String nombreLector) throws InterruptedException {
	    	// Si el entero es null debe esperar
	        while (escribiendo || this.entero == null) { 
	           try { System.out.println("... Lector " + nombreLector + " espera para leer.");
	            wait();
	        }
	           catch(InterruptedException e) {e.printStackTrace();}
	        
	        }
	        numLectores++;
	        System.out.println(">>> Lector " + nombreLector + " ha empezado a leer.");
	    }
	 private synchronized void terminaLectura( String nombreLector)throws InterruptedException{
		 System.out.println("El lector"+nombreLector+"ha terminado su lectura");
		 numLectores--;
		 if(numLectores==0) {
		 notifyAll();}
	 }
	 
	 public void Escribir(String nombreEscritor)throws InterruptedException{
		 empezarEscritura(nombreEscritor);
		 System.out.println("El escritor"+nombreEscritor+"está escribiendo");
		 Integer valorAntiguo= this.entero;
		 this.entero= (int)Math.random()*1000;
		 System.out.println("El escritor ha cambiado el valor de"+valorAntiguo+"a el nuevo valor"+this.entero);
		 Thread.sleep((long)Math.random()*500);
		 acabaEscritura(nombreEscritor);
	 }
	 private synchronized void empezarEscritura(String nombreEscritor)throws InterruptedException{
		 while(escribiendo||numLectores>0) {
			 try {
				 wait();
				 System.out.println("El escritor: "+ nombreEscritor+"está esperando a escribir");
			 }
			 catch(InterruptedException e) {e.printStackTrace();}
		 }
		 escribiendo=true;
		 System.out.println("El escritor"+nombreEscritor+"ha empezado a escribir");
	 }
	private synchronized void acabaEscritura(String nombreEscritor)throws InterruptedException{
		System.out.println("El escritor"+nombreEscritor+"ha terminado su lectura");
		escribiendo=false;
		notifyAll();
	}
}
