package de.threads.synchronization.printer;

/**
 * Ein Thread, der Dokumente auf einem gemeinsam genutzten Drucker ausdruckt.
 * Diese Klasse demonstriert, wie mehrere Threads auf eine synchronisierte Ressource
 * (in diesem Fall einen Drucker) zugreifen können, ohne dass es zu Konflikten kommt.
 */
public class PrintDocumentThread extends Thread { 
   
  /** Die gemeinsam genutzte Drucker-Ressource */
  private Printer printer; 
   
  /**
   * Erstellt einen neuen Druck-Thread mit einem Namen und einer Referenz auf den gemeinsamen Drucker.
   * 
   * @param threadName Der Name des Threads
   * @param printerResource Die gemeinsam genutzte Drucker-Ressource
   */
  public PrintDocumentThread(String threadName, Printer printerResource) { 
    setName(threadName); 
    printer = printerResource; 
  } 
   
  /**
   * Die Hauptmethode des Threads, die ausgeführt wird, wenn der Thread gestartet wird.
   * Initialisiert zuerst den Drucker und druckt dann drei Dokumente nacheinander.
   * Da die Drucker-Methoden synchronisiert sind, kann immer nur ein Thread
   * den Drucker zur gleichen Zeit benutzen.
   */
  public void run() { 
     
    printer.initPrinter(getName()); 
     
    for (int i = 1; i <= 3; i++) 
      printer.usePrinter("Dokument "+i); 
  } 
}