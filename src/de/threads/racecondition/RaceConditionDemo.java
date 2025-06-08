package de.threads.racecondition; 
 
/**
 * Demonstriert eine Race Condition beim gleichzeitigen Zugriff mehrerer Threads auf eine gemeinsame Ressource.
 * In diesem Beispiel greifen zwei Personen (Threads) gleichzeitig auf ein gemeinsames Konto zu,
 * was zu unvorhersehbaren Ergebnissen führen kann, wenn der Zugriff nicht synchronisiert ist.
 */
public class RaceConditionDemo { 
 	 
	/**
	 * Die Hauptmethode, die das Programm startet.
	 * Erstellt ein gemeinsames Konto und zwei Personen, die gleichzeitig versuchen,
	 * Geld von diesem Konto abzuheben. Nach Abschluss der Abhebungen werden die
	 * Ergebnisse ausgegeben.
	 *
	 * @param args Kommandozeilenargumente (werden nicht verwendet)
	 * @throws InterruptedException Wenn ein Thread während des Wartens unterbrochen wird
	 */
	public static void main (String args []) throws  InterruptedException { 
    
    // Erstellen eines gemeinsamen Kontos mit einem Startguthaben von 1000€
    Account account = new Account (1000); 
     
    // Erstellen von zwei Personen, die auf das gleiche Konto zugreifen
    Person peter = new Person("Peter", account); 
    Person maria = new Person("Maria", account); 
         
    // Erstellen und Starten der Threads für die Einkäufe beider Personen
    Thread peterBuys = new Thread(peter); 
    Thread mariaBuys = new Thread(maria); 
     
    peterBuys.start(); 
    mariaBuys.start(); 
      
    // Warten auf die Beendigung beider Threads, bevor fortgefahren wird
    peterBuys.join(); 
    mariaBuys.join(); 
       
    // Berechnen der Gesamtausgaben beider Personen
    int sum = maria.getSpendings() + peter.getSpendings(); 
     
    // Ausgabe der Ergebnisse
    System.out.println ("Maria hat " + maria.getSpendings() + "€ ausgegeben!"); 
    System.out.println ("Peter hat " + peter.getSpendings() + "€ ausgegeben!"); 
    System.out.println ("Zusammen sind das " + sum+"€!"); 
    System.out.println ("Kontostand: " + account.getBalance() + "€!"); 
   } 
 
}