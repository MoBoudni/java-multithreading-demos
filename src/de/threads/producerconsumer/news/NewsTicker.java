package de.threads.producerconsumer.news;

/**
 * Hauptklasse, die das Producer-Consumer-Pattern mit Nachrichten demonstriert.
 * Diese Klasse erstellt eine Zwischenablage sowie einen Producer- und einen Consumer-Thread,
 * die über die Zwischenablage kommunizieren.
 */
public class NewsTicker {
    
    /**
     * Die Hauptmethode, die das Programm startet.
     * Erstellt eine Zwischenablage sowie einen Producer und einen Consumer,
     * die über diese Zwischenablage kommunizieren.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        // Erstellen der gemeinsam genutzten Zwischenablage
        Clipboard clipboard = new Clipboard();
        
        // Erstellen und Starten des Producer-Threads
        NewsProducer producer = new NewsProducer(clipboard);
        producer.start();
        
        // Erstellen und Starten des Consumer-Threads
        NewsConsumer consumer = new NewsConsumer(clipboard);
        consumer.start();
        
        // Hinweis: Das Programm läuft in einer Endlosschleife und muss manuell beendet werden
    }
} 