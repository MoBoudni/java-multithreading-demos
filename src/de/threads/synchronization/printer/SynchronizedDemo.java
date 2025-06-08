package de.threads.synchronization.printer; 
 
/**
 * Demonstriert die Verwendung von synchronisierten Methoden zur Thread-Koordination.
 * Diese Klasse erstellt zwei Threads, die auf dieselbe Drucker-Ressource zugreifen,
 * wobei die Synchronisierung in der Printer-Klasse sicherstellt, dass immer nur
 * ein Thread zur gleichen Zeit auf den Drucker zugreifen kann.
 */
public class SynchronizedDemo { 
 	 
	/**
	 * Die Hauptmethode, die das Programm startet.
	 * Erstellt einen gemeinsam genutzten Drucker und zwei Threads, die versuchen,
	 * gleichzeitig auf diesen Drucker zuzugreifen.
	 * 
	 * @param args Kommandozeilenargumente (werden nicht verwendet)
	 */
	public static void main (String args []) { 
	      
	      // Erstellen eines gemeinsam genutzten Druckers
	      Printer p = new Printer (); 
	      
	      // Erstellen von zwei Threads, die auf denselben Drucker zugreifen
	      Thread p1 = new PrintDocumentThread ("Thread A", p); 
	      Thread p2 = new PrintDocumentThread ("Thread B", p); 
	      
	      // Starten der Threads
	      p1.start (); 
	      p2.start (); 
	      
	    } 
}