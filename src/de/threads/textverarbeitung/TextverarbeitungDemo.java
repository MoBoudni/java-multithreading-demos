package de.threads.textverarbeitung;

/**
 * Demonstrationsklasse für die parallele Ausführung von
 * Textverarbeitungsaufgaben. Diese Klasse zeigt, wie verschiedene
 * Textverarbeitungsprozesse (Schreiben, Drucken und Rechtschreibprüfung)
 * gleichzeitig als separate Threads ausgeführt werden können.
 *
 * @author MoBoudni
 * @version 1.0
 */
public class TextverarbeitungDemo {

	/**
	 * Die Hauptmethode, die das Programm startet. Erstellt und startet drei
	 * verschiedene Threads für Textverarbeitungsaufgaben: Schreiben, Drucken und
	 * Rechtschreibprüfung.
	 *
	 * @param args Kommandozeilenargumente (werden nicht verwendet)
	 */
	public static void main(String[] args) {

		// Konstruktoren
		Thread schreibenThread = new Thread(new SchreibenTask());
		Thread druckenThread = new Thread(new DruckenTask());
		Thread rechtschreibpruefungThread = new Thread(new RechtschreibpruefungTask());

		// Threads starten
		schreibenThread.start();
		druckenThread.start();
		rechtschreibpruefungThread.start();
	}
}
