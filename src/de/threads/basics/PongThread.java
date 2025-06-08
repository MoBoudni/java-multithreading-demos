package de.threads.basics;

/**
 * Ein einfacher Thread, der 20 Mal "Pong" auf der Konsole ausgibt.
 * 
 * Diese Klasse erweitert die Thread-Klasse und überschreibt die run()-Methode,
 * um das gewünschte Verhalten zu implementieren. Der Thread wird gestartet,
 * wenn die start()-Methode auf einer Instanz dieser Klasse aufgerufen wird.
 */
public class PongThread extends Thread {

    /**
     * Die run-Methode enthält den Code, der in diesem Thread ausgeführt wird.
     * Diese Methode wird automatisch aufgerufen, wenn der Thread mit der
     * start()-Methode gestartet wird.
     * 
     * In diesem Fall gibt die Methode 20 Mal "Pong" auf der Konsole aus.
     */
    public void run() {
        for (int i = 0; i < 20; i++)
            System.out.println("Pong");
    }
}
