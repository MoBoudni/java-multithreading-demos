package de.threads.racecondition;
/**
 * Repräsentiert ein Bankkonto mit einem Guthaben und Abhebungsfunktionalität.
 * Diese Klasse demonstriert eine potenzielle Race Condition, wenn mehrere Threads
 * gleichzeitig auf die withdraw-Methode zugreifen, da zwischen der Überprüfung des
 * Kontostands und der tatsächlichen Abhebung eine künstliche Verzögerung eingebaut ist.
 */
public class Account { 
   
  /** Das aktuelle Guthaben des Kontos */
  private int balance; 
   
  /**
   * Erstellt ein neues Konto mit einem angegebenen Startguthaben.
   * 
   * @param initialBalance Das Startguthaben des Kontos
   */
  public Account (int initialBalance) { 
    balance = initialBalance; 
  } 
  
  /**
   * Versucht, einen bestimmten Betrag vom Konto abzuheben.
   * Diese Methode enthält eine künstliche Verzögerung (sleep), um eine Race Condition
   * zu demonstrieren, wenn mehrere Threads gleichzeitig darauf zugreifen.
   * 
   * @param amount Der abzuhebende Betrag
   * @return true, wenn die Abhebung erfolgreich war (genügend Guthaben vorhanden);
   * false, wenn nicht genügend Guthaben vorhanden ist
   */
  public boolean withdraw (int amount) { 
      
    if (balance >= amount) {      
      try { 
        // Künstliche Verzögerung, um Race Conditions zu demonstrieren
        Thread.sleep (7); 
      } 
      catch (InterruptedException ex) {} 
         
      balance -= amount; 
      return true; 
    } 
    else { 
      return false; 
    } 
  } 
      
  /**
   * Gibt das aktuelle Guthaben des Kontos zurück.
   * 
   * @return Das aktuelle Guthaben
   */
  public int getBalance () { 
    return balance; 
  }  
}
