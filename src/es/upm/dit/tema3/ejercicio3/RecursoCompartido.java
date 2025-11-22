package es.upm.dit.tema3.ejercicio3;

public class RecursoCompartido {
	private Integer entero = null;
	
	private boolean escribiendo=false;
	private int numLectores = 0;
	
	private int[]escritoresEsperando= {0,0,0};
	private int[]lectoresEsperando = {0,0,0};
	
	//Lectura
	public void Leer(String nombreLector,Prioridad p) throws InterruptedException{
		this.accesoLectura(nombreLector,p);
		System.out.println("El lector:"+ nombreLector+"está leyendo"+this.entero);
		Thread.sleep((long)(Math.random()*500));
		this.terminaLectura(nombreLector);
	}
	 private synchronized void accesoLectura(String nombreLector,Prioridad p) throws InterruptedException {
		 	escritoresEsperando[p.ordinal()]++;
	    	// Si el entero es null debe esperar
	        while (escribiendo || this.entero == null||hayEscritoresDeMayorPrioridad(p)) { 
	           try { System.out.println("... Lector " + nombreLector + " espera para leer.");
	            wait();
	        }
	           catch(InterruptedException e) {e.printStackTrace();}
	        
	        }
	        numLectores++;
	        escritoresEsperando[p.ordinal()]--;
	        System.out.println(">>> Lector " + nombreLector + " ha empezado a leer.");
	    }
	 private synchronized void terminaLectura( String nombreLector)throws InterruptedException{
		 System.out.println("El lector"+nombreLector+"ha terminado su lectura");
		 numLectores--;
		 if(numLectores==0) {
		 notifyAll();}
	 }
	 
	 public void Escribir(String nombreEscritor,Prioridad p)throws InterruptedException{
		 empezarEscritura(nombreEscritor,p);
		 System.out.println("El escritor"+nombreEscritor+"está escribiendo");
		 Integer valorAntiguo= this.entero;
		 this.entero= (int)Math.random()*1000;
		 System.out.println("El escritor ha cambiado el valor de"+valorAntiguo+"a el nuevo valor"+this.entero);
		 Thread.sleep((long)Math.random()*500);
		 acabaEscritura(nombreEscritor);
	 }
	 private synchronized void empezarEscritura(String nombreEscritor,Prioridad p)throws InterruptedException{
		 escritoresEsperando[p.ordinal()]++;
		 while(escribiendo||numLectores>0||hayAlguienDeMayorPrioridad(p)||lectoresEsperando[p.ordinal()]>0) {
			 try {
				 wait();
				 System.out.println("El escritor: "+ nombreEscritor+"está esperando a escribir");
			 }
			 catch(InterruptedException e) {e.printStackTrace();}
		 }
		 escritoresEsperando[p.ordinal()]--;
		 escribiendo=true;
		 System.out.println("El escritor"+nombreEscritor+"ha empezado a escribir");
	 }
	private synchronized void acabaEscritura(String nombreEscritor)throws InterruptedException{
		System.out.println("El escritor"+nombreEscritor+"ha terminado su lectura");
		escribiendo=false;
		notifyAll();
	}
	private boolean hayEscritoresDeMayorPrioridad(Prioridad p) {
		for(int i =p.ordinal()+1;i<3;i++) {
			if(escritoresEsperando[i]>0) {return true;}
		}
		return false;
	}
	private boolean hayAlguienDeMayorPrioridad(Prioridad p) {
		for(int i=p.ordinal()+1;i<3;i++) {
			if(escritoresEsperando[i]>0||lectoresEsperando[i]>0) {return true;
			}
		}return false;
	}
}

