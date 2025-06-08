package de.threads.producerconsumer.so;

/**
 * Repräsentiert eine gemeinsame Zwischenablage für die Übertragung von Nachrichtenelementen
 * zwischen Produzenten- und Konsumenten-Threads.
 * <p>
 * Diese Klasse implementiert Thread-Synchronisation unter Verwendung des wait/notify-Mechanismus,
 * um eine korrekte Koordination zwischen Produzenten- und Konsumenten-Threads sicherzustellen.
 * Sie verhindert, dass der Produzent ein neues Element hinzufügt, bevor der Konsument das aktuelle
 * verarbeitet hat, und verhindert, dass der Konsument versucht zu lesen, wenn kein Element verfügbar ist.
 * </p>
 *
 * @author MoBoudni
 * @version 1.0
 */
public class Clipboard {
    
    /** Das aktuelle Nachrichtenelement, das in der Zwischenablage gespeichert ist */
    private String content = null;
    
    /** Flag, das anzeigt, ob die Zwischenablage ein neues, ungelesenes Element enthält */
    private boolean occupied = false;
    
    /**
     * Überprüft, ob die Zwischenablage ein ungelesenes Element enthält.
     *
     * @return true, wenn die Zwischenablage ein ungelesenes Element enthält, sonst false
     */
    public boolean isOccupied() {
        return occupied;
    }
    
    /**
     * Setzt ein neues Nachrichtenelement in die Zwischenablage.
     * <p>
     * Diese Methode wird vom Produzenten-Thread aufgerufen, um eine neue Nachricht
     * in der Zwischenablage zu platzieren. Der Aufruf sollte innerhalb eines
     * synchronisierten Blocks erfolgen, der die Zwischenablage als Monitor verwendet.
     * </p>
     *
     * @param item Das Nachrichtenelement, das in die Zwischenablage gesetzt werden soll
     */
    public void set(String item) {
        content = item;
        occupied = true;
        System.out.println("Producer set: " + item);
    }
    
    /**
     * Ruft das aktuelle Nachrichtenelement aus der Zwischenablage ab und markiert es als gelesen.
     * <p>
     * Diese Methode wird vom Konsumenten-Thread aufgerufen, um eine Nachricht aus der
     * Zwischenablage abzurufen. Der Aufruf sollte innerhalb eines synchronisierten Blocks
     * erfolgen, der die Zwischenablage als Monitor verwendet.
     * </p>
     *
     * @return Das Nachrichtenelement aus der Zwischenablage
     */
    public String recall() {
        occupied = false;
        return content;
    }
}
