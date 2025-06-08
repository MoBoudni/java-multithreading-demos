package de.threads.basics;

/**
 * Demonstriert die grundlegende Verwendung von Threads in Java.
 * Diese Klasse startet einen separaten Thread (PongThread) und führt
 * gleichzeitig eigene Ausgaben im Hauptthread aus.
 * 
 * Dieses Beispiel zeigt, wie zwei Threads (der Hauptthread und der PongThread)
 * parallel ausgeführt werden und ihre Ausgaben sich vermischen können.
 */
public class ThreadDemo1 {

    /**
     * Die Hauptmethode, die beim Start des Programms ausgeführt wird.
     * Erstellt und startet einen PongThread und gibt dann selbst
     * 20 Mal "Ping" auf der Konsole aus.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {

        PongThread pongThread = new PongThread();
        pongThread.start();

        for (int i = 0; i < 20; i++)
            System.out.println("Ping");
    }
}
