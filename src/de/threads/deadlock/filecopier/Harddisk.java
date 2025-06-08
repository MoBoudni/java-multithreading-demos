package de.threads.deadlock.filecopier;

/**
 * Repräsentiert eine Festplatte oder ein Speichermedium, auf dem Dateien gespeichert werden können.
 * Diese Klasse demonstriert die Verwendung von synchronisierten Methoden für Dateioperationen.
 * Jede Operation (öffnen, lesen, schreiben) ist synchronisiert, um den gleichzeitigen Zugriff
 * mehrerer Threads zu koordinieren.
 */
public class Harddisk { 
    
    /** Der Name der Festplatte oder des Speichermediums */
    private String name; 
    
    /**
     * Erstellt eine neue Festplatte mit einem angegebenen Namen.
     * 
     * @param name Der Name der Festplatte
     */
    public Harddisk (String name) { 
      this.name = name; 
    } 
   
    /**
     * Öffnet eine Datei auf der Festplatte.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Festplatte zugreifen kann.
     */
    public synchronized void open () { 
      System.out.println ("Datei wird geöffnet!"); 
    } 
    
    /**
     * Liest Daten aus einer Datei auf der Festplatte.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Festplatte zugreifen kann.
     */
    public synchronized void read () { 
      System.out.println ("Datei wird ausgelesen!"); 
    } 
    
    /**
     * Schreibt Daten in eine Datei auf der Festplatte.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Festplatte zugreifen kann.
     */
    public synchronized void write () { 
      System.out.println ("Datei wird beschrieben!"); 
    } 
      
    /**
     * Gibt eine String-Repräsentation der Festplatte zurück.
     * 
     * @return Der Name der Festplatte
     */
    public String toString () { 
      return name; 
    } 
    
}