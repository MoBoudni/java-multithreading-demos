package de.threads.synchronization.printer;

/**
 * Repräsentiert einen Drucker als gemeinsam genutzte Ressource für mehrere Threads.
 * Diese Klasse demonstriert die Verwendung von synchronisierten Methoden,
 * um den gleichzeitigen Zugriff mehrerer Threads auf eine gemeinsame Ressource zu koordinieren.
 * Durch die Synchronisierung wird sichergestellt, dass immer nur ein Thread den Drucker
 * initialisieren oder benutzen kann.
 */
public class Printer { 
   
    /** Der Name des Threads, der den Drucker aktuell benutzt */
    private String threadName; 
     
    /**
     * Initialisiert den Drucker mit dem Namen des aufrufenden Threads.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * den Drucker zur gleichen Zeit initialisieren kann.
     * 
     * @param threadTName Der Name des Threads, der den Drucker initialisiert
     */
    public synchronized void initPrinter(String threadTName) { 
      threadName = threadTName; 
      System.out.println(threadName+" initialisiert den Drucker!"); 
    } 
   
    /**
     * Druckt ein Dokument mit dem angegebenen Namen.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit den Drucker benutzen kann.
     * 
     * @param documentName Der Name des zu druckenden Dokuments
     */
    public synchronized void usePrinter(String documentName) { 
      System.out.println(threadName+" druckt Dokument "+documentName); 
    } 
}