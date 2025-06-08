package de.threads.textverarbeitung;

/**
 * Implementiert die Aufgabe der Rechtschreibprüfung eines Dokuments. Diese
 * Klasse simuliert den Prozess der Rechtschreibprüfung in verschiedenen
 * Abschnitten eines Dokuments mit Pausen zwischen den Prüfvorgängen.
 */
class RechtschreibpruefungTask implements Runnable { // Aufgabe 3: Rechtschreibprüfung im Hintergrund
	/**
	 * Führt die Rechtschreibprüfungsaufgabe aus. Simuliert die Prüfung von 4
	 * Abschnitten mit einer Pause von 800 Millisekunden zwischen den einzelnen
	 * Abschnitten.
	 */
	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			System.out.println("Rechtschreibprüfung aktiv... Abschnitt " + i);
			sleep(800);
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
