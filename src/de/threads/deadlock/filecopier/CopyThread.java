package de.threads.deadlock.filecopier;

/**
 * Ein Thread, der Dateien von einer Quell-Festplatte auf eine Ziel-Festplatte kopiert.
 * Diese Klasse demonstriert die Verwendung von verschachtelten synchronized-Blöcken,
 * was zu einem potenziellen Deadlock führen kann, wenn mehrere Threads gleichzeitig
 * auf verschiedene Festplatten zugreifen und dabei die Locks in unterschiedlicher
 * Reihenfolge anfordern.
 */
public class CopyThread extends Thread { 
   
    /** Die Quell-Festplatte, von der gelesen wird */
    private Harddisk source;
    
    /** Die Ziel-Festplatte, auf die geschrieben wird */
    private Harddisk target; 
    
    /**
     * Erstellt einen neuen Kopier-Thread mit einem Namen und Referenzen auf Quell- und Ziel-Festplatte.
     * 
     * @param name Der Name des Threads
     * @param q Die Quell-Festplatte (source)
     * @param z Die Ziel-Festplatte (target)
     */
    public CopyThread (String name, Harddisk q, Harddisk z) { 
      setName (name); 
      source = q; 
      target = z; 
    } 
   
    /**
     * Die Hauptmethode des Threads, die ausgeführt wird, wenn der Thread gestartet wird.
     * Führt 100 Kopieroperationen durch, wobei für jede Operation zuerst ein Lock auf die
     * Quell-Festplatte und dann ein Lock auf die Ziel-Festplatte angefordert wird.
     * 
     * HINWEIS: Diese Implementierung kann zu Deadlocks führen, wenn zwei Threads gleichzeitig
     * Dateien in entgegengesetzter Richtung kopieren (z.B. Thread1: A→B, Thread2: B→A),
     * da die Locks in unterschiedlicher Reihenfolge angefordert werden.
     */
    public void run () { 
   
      for (int i = 0; i < 100; i++) { 
   
        System.out.println (getName()+" benötigt Lock für "+source); 
        synchronized (source) { 
          
          source.open(); 
           
          System.out.println (getName()+" hat Lock für "+source+" und benötigt nun Lock für "+target); 
          synchronized (target) {  
             
            System.out.println (getName()+" hat beide Locks!"); 
            target.open(); 
            source.read(); 
            target.write(); 
          } 
        } 
      } 
    } 
}