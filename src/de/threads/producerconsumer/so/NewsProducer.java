package de.threads.producerconsumer.so;

/**
 * Ein Thread, der Nachrichten erzeugt und in einer gemeinsamen Zwischenablage platziert.
 * <p>
 * Diese Klasse erweitert {@link Thread} und generiert kontinuierlich Nachrichten,
 * die in der gemeinsamen {@link Clipboard} abgelegt werden. Sie demonstriert die Produzentenseite
 * des Erzeuger-Verbraucher-Musters mit korrekter Thread-Synchronisation.
 * </p>
 *
 * @author MoBoudni
 * @version 1.0
 */
public class NewsProducer extends Thread {

    /** Array von Beispiel-Nachrichtenelementen, die produziert werden sollen */
    private String[] news = {
        "Weltfrieden erreicht",
        "Java Sprache des Jahres",
        "Twix heißt jetzt doch wieder Raider",
        "Spinat doch gesund - aber nur bei Vollmond"
    };

    /** Die gemeinsame Zwischenablage zum Übertragen von Nachrichten zum Konsumenten */
    private Clipboard clipboard;
    
    /** Der Name des Produzenten zur Identifikation in der Ausgabe */
    private String name;

    /**
     * Konstruiert einen NewsProducer mit einer Referenz zur gemeinsamen Zwischenablage
     * und einem Namen zur Identifikation.
     *
     * @param target Die gemeinsame Zwischenablage zum Übertragen von Nachrichten
     * @param name Der Name des Produzenten zur Identifikation in der Ausgabe
     */
    public NewsProducer(Clipboard target, String name) {
        clipboard = target;
        this.name = name;
    }

    /**
     * Die Hauptausführungsmethode für den Produzenten-Thread.
     * <p>
     * Generiert kontinuierlich Nachrichten und platziert sie in der gemeinsamen Zwischenablage.
     * Nach jeder Produktion wartet der Thread für eine zufällige Zeitspanne zwischen 1 und 2 Sekunden,
     * um die Zeit zu simulieren, die benötigt wird, um Nachrichten zu sammeln. Der Thread verwendet
     * synchronisierte Blöcke und die wait/notify-Mechanismen, um eine korrekte Koordination mit
     * dem Konsumenten-Thread sicherzustellen.
     * </p>
     */
    public void run() {

        for (;;) {

            try {
                Thread.sleep(1000+(long)(Math.random()*1000));
            }
            catch (InterruptedException ex) {return;}

            synchronized (clipboard) {

                while (clipboard.isOccupied()) {
                    try {
                        clipboard.wait();
                    }
                    catch (InterruptedException ex) {return;}
                }

                String nextNews = name+": "+news[(int)(news.length*Math.random())];

                clipboard.set(nextNews);
                clipboard.notifyAll();
            }
        }
    }
}
