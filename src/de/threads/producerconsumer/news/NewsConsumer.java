package de.threads.producerconsumer.news;

/**
 * Ein Thread, der regelmäßig Nachrichten aus einer Zwischenablage abruft und ausgibt.
 * Diese Klasse implementiert den Consumer-Teil des Producer-Consumer-Patterns und verwendet
 * wait/notify-Mechanismen zur Thread-Koordination.
 */
public class NewsConsumer extends Thread {
    
    /** Die Zwischenablage, aus der die Nachrichten abgerufen werden */
    private Clipboard clipboard;
    
    /**
     * Erstellt einen neuen NewsConsumer mit einer Referenz auf die zu verwendende Zwischenablage.
     * 
     * @param source Die Zwischenablage, aus der die Nachrichten abgerufen werden sollen
     */
    public NewsConsumer(Clipboard source) {
        clipboard = source;
    }
    
    /**
     * Die Hauptmethode des Threads, die in einer Endlosschleife Nachrichten konsumiert.
     * Der Thread wartet regelmäßig (1 Sekunde) und prüft dann, ob in der Zwischenablage
     * eine Nachricht verfügbar ist. Falls nicht, wartet er mit wait(), bis er durch
     * notifyAll() benachrichtigt wird. Sobald eine Nachricht verfügbar ist, wird diese
     * aus der Zwischenablage abgerufen und ausgegeben.
     */
    public void run() {
        for (;;) {
            try {
                // Warte 1 Sekunde zwischen den Abrufen
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                return;
            }
            
            synchronized (clipboard) {
                // Warte, solange die Zwischenablage leer ist
                while (!clipboard.isOccupied()) {
                    try {
                        clipboard.wait();
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
                
                // Rufe die Nachricht ab und gib sie aus
                System.out.println("Got News: " + clipboard.recall());
                
                // Benachrichtige wartende Threads (Producer), dass die Zwischenablage wieder frei ist
                clipboard.notifyAll();
            }
        }
    }
}