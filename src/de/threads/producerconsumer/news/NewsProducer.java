package de.threads.producerconsumer.news;

/**
 * Ein Thread, der in unregelmäßigen Abständen Nachrichten produziert und in einer Zwischenablage ablegt.
 * Diese Klasse implementiert den Producer-Teil des Producer-Consumer-Patterns und verwendet
 * wait/notify-Mechanismen zur Thread-Koordination.
 */
public class NewsProducer extends Thread {
    
    /** Array mit möglichen Nachrichten, die produziert werden können */
    private String[] news = {
        "Weltfrieden erreicht",
        "Java Sprache des Jahres",
        "Twix heißt jetzt doch wieder Raider",
        "Spinat doch gesund - aber nur bei Vollmond"
    };
    
    /** Die Zwischenablage, in der die produzierten Nachrichten abgelegt werden */
    private Clipboard clipboard;
    
    /**
     * Erstellt einen neuen NewsProducer mit einer Referenz auf die zu verwendende Zwischenablage.
     * 
     * @param target Die Zwischenablage, in der die Nachrichten abgelegt werden sollen
     */
    public NewsProducer(Clipboard target) {
        clipboard = target;
    }
    
    /**
     * Die Hauptmethode des Threads, die in einer Endlosschleife Nachrichten produziert.
     * Der Thread wartet in unregelmäßigen Abständen (1-2 Sekunden) und prüft dann,
     * ob die Zwischenablage frei ist. Falls nicht, wartet er mit wait(), bis er
     * durch notifyAll() benachrichtigt wird. Sobald die Zwischenablage frei ist,
     * wird eine zufällige Nachricht ausgewählt und in der Zwischenablage abgelegt.
     */
    public void run() {
        for (;;) {
            try {
                // Warte 1-2 Sekunden, um das Eintreffen neuer Nachrichten zu simulieren
                Thread.sleep(1000 + (long)(Math.random() * 1000));
            } catch (InterruptedException ex) {
                return;
            }
            
            synchronized (clipboard) {
                // Warte, solange die Zwischenablage belegt ist
                while (clipboard.isOccupied()) {
                    try {
                        clipboard.wait();
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
                
                // Wähle eine zufällige Nachricht aus und lege sie in der Zwischenablage ab
                String nextNews = news[(int)(news.length * Math.random())];
                clipboard.set(nextNews);
                
                // Benachrichtige wartende Threads (Consumer), dass eine neue Nachricht verfügbar ist
                clipboard.notifyAll();
            }
        }
    }
}