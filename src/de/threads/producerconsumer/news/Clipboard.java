package de.threads.producerconsumer.news;

/**
 * Repräsentiert eine thread-sichere Zwischenablage für Nachrichten.
 * Diese Klasse dient als gemeinsam genutzter Puffer zwischen Producer- und Consumer-Threads
 * und implementiert eine einfache Synchronisationsmechanik, um den gleichzeitigen Zugriff
 * mehrerer Threads zu koordinieren.
 */
public class Clipboard {
    
    /** Der aktuelle Wert in der Zwischenablage, null wenn die Zwischenablage leer ist */
    private String value;
    
    /**
     * Legt einen Text in der Zwischenablage ab.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Zwischenablage zugreifen kann.
     * 
     * @param v Der in der Zwischenablage abzulegende Text
     */
    public synchronized void set(String v) {
        value = v;
    }
    
    /**
     * Ruft den aktuellen Text aus der Zwischenablage ab und leert diese.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Zwischenablage zugreifen kann.
     * 
     * @return Der abgerufene Text, oder null wenn die Zwischenablage leer war
     */
    public synchronized String recall() {
        String v = value;
        value = null;
        return v;
    }
    
    /**
     * Prüft, ob die Zwischenablage belegt ist.
     * Diese Methode ist synchronisiert, um sicherzustellen, dass nur ein Thread
     * zur gleichen Zeit auf die Zwischenablage zugreifen kann.
     * 
     * @return true, wenn die Zwischenablage belegt ist (value != null), sonst false
     */
    public synchronized boolean isOccupied() {
        return value != null;
    }
}