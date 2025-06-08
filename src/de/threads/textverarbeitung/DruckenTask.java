package de.threads.textverarbeitung;

/**
 * Implementiert die Aufgabe des Druckens eines Dokuments. Diese Klasse
 * simuliert den Prozess des Druckens mehrerer Seiten mit Pausen zwischen den
 * Druckvorgängen.
 */
class DruckenTask implements Runnable { // Aufgabe 2: Dokument wird gedruckt
	/**
	 * Führt die Druckaufgabe aus. Simuliert das Drucken von 3 Seiten mit einer
	 * Pause von 1000 Millisekunden zwischen den einzelnen Seiten.
	 */
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			System.out.println("Druckvorgang läuft... Seite " + i);
			sleep(1000);
		}
	}

	/**
	 * Hilfsmethode zum Pausieren des Threads.
	 * 
	 * @param millis Die Dauer der Pause in Millisekunden
	 */
	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
