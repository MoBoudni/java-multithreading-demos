package de.threads.concurrent.primenumbers;

import java.util.Set;

/**
 * Testklasse für die parallele Primzahlenberechnung.
 * <p>
 * Diese Klasse demonstriert die Verwendung der {@link PNComputer}-Klasse zur
 * parallelen Berechnung von Primzahlen in einem bestimmten Zahlenbereich mit
 * mehreren Threads.
 * </p>
 *
 * @author MoBoudni
 * @version 1.0
 */
public class PNTest {

    /**
     * Der Haupteinstiegspunkt für die Anwendung.
     * <p>
     * Berechnet alle Primzahlen zwischen 1 und 1000 unter Verwendung von 5 parallelen
     * Threads und gibt die Anzahl und die gefundenen Primzahlen aus.
     * </p>
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String args[]) {

        Set<Integer> primes =
                PNComputer.computePrimeNumbers(1, 1000, 5);

        System.out.println(primes.size() + " Primzahlen zwischen 1 und 1000 mit 5 Threads gefunden:");
        System.out.println(primes);
    }
}
