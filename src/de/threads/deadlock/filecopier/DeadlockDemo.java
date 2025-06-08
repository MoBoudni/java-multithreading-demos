package de.threads.deadlock.filecopier;

/**
 * Demonstriert einen klassischen Deadlock durch gekreuzte Ressourcenanforderungen.
 * Diese Klasse erstellt zwei Threads, die versuchen, Dateien in entgegengesetzter Richtung
 * zwischen zwei Festplatten zu kopieren, was zu einem Deadlock führt.
 * 
 * Der Deadlock entsteht, weil:
 * - Thread A versucht, von HDD2 nach HDD1 zu kopieren und fordert zuerst einen Lock für HDD2 an
 * - Thread B versucht, von HDD1 nach HDD2 zu kopieren und fordert zuerst einen Lock für HDD1 an
 * - Wenn beide Threads ihre ersten Locks erhalten haben, warten sie jeweils auf den Lock
 *   der anderen Festplatte, den der andere Thread bereits hält
 */
public class DeadlockDemo { 
    
    /**
     * Die Hauptmethode, die das Deadlock-Szenario initiiert.
     * Erstellt zwei Festplatten und zwei Threads, die in entgegengesetzter Richtung
     * Dateien kopieren, was zu einem Deadlock führt.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main (String args []) { 
      
      // Erstellen von zwei Festplatten
      Harddisk hdd1 = new Harddisk ("HDD1"); 
      Harddisk hdd2 = new Harddisk ("HDD2"); 
      
      // Erstellen von zwei Threads, die in entgegengesetzter Richtung kopieren
      // Thread A kopiert von HDD2 nach HDD1
      Thread t1 = new CopyThread ("Thread A", hdd2, hdd1); 
      // Thread B kopiert von HDD1 nach HDD2
      Thread t2 = new CopyThread ("Thread B", hdd1, hdd2); 
      
      // Starten der Threads - der Deadlock wird nach kurzer Zeit auftreten
      t1.start(); 
      t2.start(); 
    } 
}