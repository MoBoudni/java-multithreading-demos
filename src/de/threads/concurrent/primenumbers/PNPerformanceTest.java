package de.threads.concurrent.primenumbers;

/**
 * Performance-Testklasse für die parallele Primzahlenberechnung.
 * Diese Klasse misst die Ausführungszeit der Primzahlenberechnung mit unterschiedlicher
 * Anzahl von Threads. Sie demonstriert, wie die Leistung durch Parallelisierung
 * verbessert werden kann und hilft, die optimale Thread-Anzahl für eine bestimmte
 * Hardware-Konfiguration zu ermitteln.
 *
 * @author MoBoudni
 * @version 1.0
 * @see PNComputer
 */
public class PNPerformanceTest {
    
    /**
     * Der Haupteinstiegspunkt für die Performance-Tests.
     * Führt die Primzahlenberechnung für den Bereich von 1.000 bis 1.000.000 mit
     * unterschiedlicher Anzahl von Threads (1 bis 10) durch und misst die Ausführungszeit
     * für jeden Durchlauf. Die Ergebnisse werden auf der Konsole ausgegeben.

     * Die Messung kann verwendet werden, um:
     *   Die Skalierbarkeit der parallelen Implementierung zu bewerten
     *   Die optimale Thread-Anzahl für eine bestimmte Hardware zu ermitteln
     *   Den Overhead der Thread-Erstellung und -Koordination zu analysieren

     *
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String args[]) {
        for (int n = 1; n <= 10; n++) {
            System.out.print("Berechne Primzahlen zwischen 1000 und 1.000.000");
            System.out.print(" mit " + n + " Threads, ");
            
            long time = System.currentTimeMillis();
            PNComputer.computePrimeNumbers(1000, 1000000, n);
            time = System.currentTimeMillis() - time;
            
            System.out.println("benötigte Zeit: " + time + "ms!");
        }
    }
}