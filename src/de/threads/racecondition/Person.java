package de.threads.racecondition; 
 
/**
 * Repräsentiert eine Person, die Geld von einem Konto abheben kann.
 * Diese Klasse implementiert das Runnable-Interface, um als Thread ausgeführt werden zu können.
 * Jede Person versucht wiederholt, zufällige Geldbeträge vom zugewiesenen Konto abzuheben,
 * bis keine Abhebungen mehr möglich sind.
 */
public class Person implements Runnable { 
      
    /** Der Name der Person */
    private String myName; 
    
    /** Das Konto, von dem die Person Geld abhebt */
    private Account myAccount; 
    
    /** Die Gesamtsumme, die die Person erfolgreich abgehoben hat */
    private int mySpendings; 
   
    /**
     * Erstellt eine neue Person mit einem Namen und einem zugewiesenen Konto.
     * 
     * @param name Der Name der Person
     * @param account Das Konto, von dem die Person Geld abheben wird
     */
    public Person (String name, Account account) { 
      myName = name; 
      myAccount = account; 
    } 
  
    /**
     * Die run-Methode wird ausgeführt, wenn der Thread gestartet wird.
     * Die Person versucht wiederholt, zufällige Geldbeträge zwischen 1 und 9 Euro
     * vom zugewiesenen Konto abzuheben, bis keine Abhebungen mehr möglich sind
     * (wenn das Konto leer ist oder nicht genügend Geld für die Abhebung hat).
     */
    public void run() { 
       
      boolean success; 
       
      do { 
        int amount = 1 + (int)(Math.random()*9); 
        success = myAccount.withdraw(amount); 
        if (success) 
          mySpendings += amount; 
      } 
      while (success);     
    } 
    
    /**
     * Gibt die Gesamtsumme zurück, die diese Person erfolgreich abgehoben hat.
     * 
     * @return Die Gesamtsumme der Ausgaben in Euro
     */
    public int getSpendings () { 
      return mySpendings; 
    } 
  }