package de.threads.textverarbeitung;

/**
 * Implementiert die Aufgabe des Schreibens an einem Dokument. Diese Klasse
 * simuliert den Prozess des Schreibens an verschiedenen Abschnitten eines
 * Dokuments mit Pausen zwischen den Schreibvorgängen.
 */
class SchreibenTask implements Runnable { // Aufgabe 1: Benutzer schreibt weiter am Dokument

	/**
	 * Führt die Schreibaufgabe aus. Simuliert das Schreiben von 5 Abschnitten mit
	 * einer Pause von 700 Millisekunden zwischen den einzelnen Abschnitten.
	 */
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Schreiben an Dokument... Abschnitt " + i);
			sleep(700);
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
