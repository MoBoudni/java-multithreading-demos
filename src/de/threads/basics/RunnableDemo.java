package de.threads.basics;

/**
 * Demonstrationsklasse für die Verwendung des Runnable-Interfaces in Java.
 * Diese Klasse zeigt, wie mehrere Threads parallel ausgeführt werden können,
 * indem Klassen das Runnable-Interface implementieren.
 *
 * @author MoBoudni
 * @version 1.0
 */
public class RunnableDemo {

    /**
     * Die Hauptmethode, die das Programm startet.
     * Erstellt zwei TextTicker-Objekte mit unterschiedlichen Texten und
     * führt sie in separaten Threads aus.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String args[]) {

        Runnable pingTicker = new TextTicker("Ping");
        Runnable pongTicker = new TextTicker("Pong");

        Thread pingThread = new Thread(pingTicker);
        Thread pongThread = new Thread(pongTicker);

        pingThread.start();
        pongThread.start();

    }
}

/**
 * Eine Klasse, die das Runnable-Interface implementiert und einen Text
 * kontinuierlich auf der Konsole ausgibt.
 * 
 * Diese Klasse kann in einem Thread ausgeführt werden, um wiederholte
 * Textausgaben zu erzeugen.
 */
class TextTicker implements Runnable {

    /** Der Text, der kontinuierlich ausgegeben werden soll. */
    private String text;

    /**
     * Konstruktor, der den auszugebenden Text festlegt.
     *
     * @param consoleText Der Text, der kontinuierlich auf der Konsole ausgegeben werden soll
     */
    public TextTicker(String consoleText) {
        text = consoleText;
    }

    /**
     * Die run-Methode, die ausgeführt wird, wenn der Thread gestartet wird.
     * Gibt den festgelegten Text in einer Endlosschleife auf der Konsole aus.
     * 
     * Hinweis: Diese Methode enthält eine Endlosschleife ohne Verzögerung,
     * was zu einer hohen CPU-Auslastung führen kann. In realen Anwendungen
     * sollte eine Verzögerung (Thread.sleep) eingebaut werden.
     */
    public void run() {
        for (;;)  // for (Initialisierung; Bedingung; Inkrementierung)
            System.out.println(text);
    }

}
