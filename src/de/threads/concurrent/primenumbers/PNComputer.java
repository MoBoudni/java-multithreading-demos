package de.threads.concurrent.primenumbers;

import java.util.*;

/**
 * Thread zur parallelen Berechnung von Primzahlen in einem bestimmten Zahlenbereich.
 * Diese Klasse erweitert {@link Thread} und berechnet Primzahlen in einem angegebenen
 * Intervall. Sie bietet auch eine statische Methode, um die Berechnung auf mehrere
 * Threads aufzuteilen und so die Leistung zu verbessern.
 *
 * @author MoBoudni
 * @version 1.0
 */
public class PNComputer extends Thread {

    /** Untere Grenze des zu prüfenden Zahlenbereichs */
    private int from;
    
    /** Obere Grenze des zu prüfenden Zahlenbereichs */
    private int to;
    
    /** Set zur Speicherung der gefundenen Primzahlen */
    private Set<Integer> primeNumbers;
    
    /** Flag, das anzeigt, ob die Berechnung abgeschlossen ist */
    private boolean isDone;

    /**
     * Konstruiert einen PNComputer für einen bestimmten Zahlenbereich.
     *
     * @param from Die untere Grenze des zu prüfenden Zahlenbereichs (inklusive)
     * @param to Die obere Grenze des zu prüfenden Zahlenbereichs (inklusive)
     */
    public PNComputer(int from, int to) {
        this.from = from;
        this.to = to;
        primeNumbers = new TreeSet<Integer>();
        isDone = false;
    }

    /**
     * Führt die Primzahlenberechnung im angegebenen Zahlenbereich durch.
     * <p>
     * Diese Methode ist synchronisiert, um sicherzustellen, dass der Zugriff auf
     * die gemeinsamen Ressourcen thread-sicher ist. Nach Abschluss der Berechnung
     * werden alle wartenden Threads benachrichtigt.
     * </p>
     */
    public synchronized void run() {
        for (int n = from; n <= to; n++)
            if (isPrimeNumber(n))
                primeNumbers.add(n);

        isDone = true;
        notifyAll();
    }

    /**
     * Überprüft, ob eine Zahl eine Primzahl ist.
     * <p>
     * Eine Primzahl ist eine natürliche Zahl größer als 1, die nur durch 1 und sich selbst
     * ohne Rest teilbar ist. Diese Methode verwendet einen einfachen Algorithmus, der
     * prüft, ob die Zahl durch einen Wert zwischen 2 und der Quadratwurzel der Zahl teilbar ist.
     * </p>
     *
     * @param p Die zu prüfende Zahl
     * @return {@code true}, wenn die Zahl eine Primzahl ist, sonst {@code false}
     */
    private boolean isPrimeNumber(int p) {
        if (p < 3)
            return false;

        for (int i = 2; i < Math.sqrt(p) + 1; i++) {
            if (p % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Gibt die berechneten Primzahlen zurück.
     * Diese Methode ist synchronisiert und wartet, bis die Berechnung abgeschlossen ist,
     * bevor sie die Ergebnisse zurückgibt. Dies stellt sicher, dass der aufrufende Thread
     * erst dann die Ergebnisse erhält, wenn die Berechnung vollständig abgeschlossen ist.
     *
     * @return Ein Set mit allen gefundenen Primzahlen im angegebenen Bereich
     */
    public synchronized Set<Integer> getPrimeNumbers() {
        while (!isDone) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        return primeNumbers;
    }

    /**
     * Berechnet Primzahlen in einem angegebenen Bereich unter Verwendung mehrerer Threads.
     * Diese statische Methode teilt den angegebenen Zahlenbereich in gleich große Teilbereiche auf
     * und weist jedem Thread einen Teilbereich zu. Nach Abschluss aller Berechnungen werden
     * die Ergebnisse zusammengeführt und zurückgegeben.
     *
     * @param from Die untere Grenze des zu prüfenden Zahlenbereichs (inklusive)
     * @param to Die obere Grenze des zu prüfenden Zahlenbereichs (inklusive)
     * @param numberOfThreads Die Anzahl der zu verwendenden Threads
     * @return Ein Set mit allen gefundenen Primzahlen im angegebenen Bereich
     */
    public static Set<Integer> computePrimeNumbers(int from,
            int to, int numberOfThreads) {

        List<PNComputer> threads = new ArrayList<>();
        Set<Integer> allPrimeNumbers = new TreeSet<>();
        int intervalSize = (to - from) + 1;
        int subintervalSize = intervalSize / numberOfThreads;
        int remainingIntervalSize = intervalSize % numberOfThreads;

        // Erstelle und konfiguriere die Threads
        for (int i = 0; i < numberOfThreads; i++) {

            int subfrom = i * subintervalSize + from;
            int subto = subfrom + subintervalSize - 1;

            // Füge den Rest dem letzten Thread hinzu
            if (i == numberOfThreads - 1)
                subto += remainingIntervalSize;

            threads.add(new PNComputer(subfrom, subto));
        }

        // Starte alle Threads
        for (Thread t : threads)
            t.start();

        // Sammle die Ergebnisse aller Threads
        for (PNComputer t : threads)
            allPrimeNumbers.addAll(t.getPrimeNumbers());

        return allPrimeNumbers;
    }
}