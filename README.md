# Java Thread Programmierung

Dieses Repository enthält eine Sammlung von Java-Beispielen zur Thread-Programmierung, Synchronisation und Producer-Consumer-Pattern. Es demonstriert grundlegende und fortgeschrittene Konzepte der nebenläufigen Programmierung in Java.

## Übersicht

Das Repository umfasst folgende Beispiele:

### Grundlegende Thread-Synchronisation
- **SynchronizedDemo**: Demonstriert die Verwendung von synchronisierten Methoden, um Race Conditions zu vermeiden.

### Producer-Consumer Pattern
- **NewsTicker**: Implementierung des Producer-Consumer-Patterns mit einer Nachrichtenticker-Simulation.
  - `Clipboard`: Gemeinsam genutzter Speicher für Nachrichten.
  - `NewsProducer`: Erzeugt Nachrichten und legt sie im Clipboard ab.
  - `NewsConsumer`: Liest Nachrichten vom Clipboard.

### Parallele Berechnung
- **PNComputer**: Berechnung von Primzahlen mit mehreren Threads.
- **PNTest**: Testklasse für die parallele Primzahlberechnung.
- **PNPerformanceTest**: Leistungsvergleich der Primzahlberechnung mit unterschiedlicher Thread-Anzahl.

### Textverarbeitung
- **TextverarbeitungDemo**: Demonstration von Threads in einer Textverarbeitungsanwendung.

## Konzepte

Dieses Repository demonstriert folgende Konzepte:

- Thread-Erstellung und -Verwaltung
- Synchronisation mit `synchronized`-Methoden und -Blöcken
- Inter-Thread-Kommunikation mit `wait()` und `notifyAll()`
- Producer-Consumer-Pattern
- Parallele Algorithmen
- Leistungsoptimierung durch Multithreading

## Voraussetzungen

- Java Development Kit (JDK) 8 oder höher
- Eine Java-IDE wie Eclipse, IntelliJ IDEA oder Visual Studio Code

## Verwendung

Jedes Beispiel kann unabhängig ausgeführt werden. Die Hauptklassen enthalten eine `main`-Methode, die das jeweilige Konzept demonstriert.

```java
// Beispiel zur Ausführung der SynchronizedDemo
public static void main(String[] args) {
    SynchronizedDemo demo = new SynchronizedDemo();
    demo.start();
}
