package de.threads.basics;

/**
 * Demonstrationsklasse für die Verwendung der join()-Methode in Java Threads.
 * Diese Klasse zeigt, wie mehrere Threads parallel Teilberechnungen durchführen
 * können und wie das Hauptprogramm auf die Ergebnisse warten kann, bevor es
 * fortfährt.
 *
 * @author MoBoudni
 * @version 1.0
 */
public class JoinDemo {

	/**
	 * Die Hauptmethode, die das Programm startet. Erstellt zwei SumMaker-Threads,
	 * die jeweils die Summe von Zahlen in unterschiedlichen Bereichen berechnen,
	 * und kombiniert dann ihre Ergebnisse.
	 *
	 * @param args Kommandozeilenargumente (werden nicht verwendet)
	 * @throws InterruptedException Wenn ein Thread während des Wartens unterbrochen
	 *                              wird
	 */
	public static void main(String args[]) throws InterruptedException {
		SumMaker s1 = new SumMaker(1, (int) 1E09);
		SumMaker s2 = new SumMaker((int) 1E09 + 1, (int) 2E09);
		s1.start();
		s2.start();

		// Explizites Warten auf die Beendigung beider Threads
		// bevor mit der weiteren Verarbeitung fortgefahren wird
		s1.join();
		s2.join();

		// Jetzt können wir sicher sein, dass beide Threads ihre Berechnungen
		// abgeschlossen haben
		long sum = s1.getSum() + s2.getSum();
		System.out.println("Summe der Zahlen von 1 bis 2 Mrd.: " + sum);
	}
}

/**
 * Thread-Klasse zur Berechnung der Summe aller Zahlen in einem bestimmten
 * Bereich. Diese Klasse erweitert Thread und führt die Summenberechnung in
 * ihrer run()-Methode durch.
 */
class SumMaker extends Thread {
	/** Die untere Grenze des Zahlenbereichs für die Summenberechnung. */
	private int from;

	/** Die obere Grenze des Zahlenbereichs für die Summenberechnung. */
	private int to;

	/** Die berechnete Summe aller Zahlen im angegebenen Bereich. */
	private long sum;

	/**
	 * Konstruktor, der den zu summierenden Zahlenbereich festlegt.
	 *
	 * @param from Die untere Grenze des Zahlenbereichs (inklusive)
	 * @param to   Die obere Grenze des Zahlenbereichs (inklusive)
	 */
	public SumMaker(int from, int to) {
		this.from = from;
		this.to = to;
		sum = 0;
	}

	/**
	 * Die run-Methode, die ausgeführt wird, wenn der Thread gestartet wird.
	 * Berechnet die Summe aller Zahlen im festgelegten Bereich.
	 */
	public void run() {
		for (int i = from; i <= to; i++)
			sum += i;
	}

	/**
	 * Gibt die berechnete Summe zurück. Hinweis: Diese Methode sollte erst
	 * aufgerufen werden, nachdem der Thread seine Berechnung abgeschlossen hat,
	 * sonst wird möglicherweise ein unvollständiges Ergebnis zurückgegeben.
	 *
	 * @return Die Summe aller Zahlen im festgelegten Bereich
	 */
	public long getSum() {
		return sum;
	}
}