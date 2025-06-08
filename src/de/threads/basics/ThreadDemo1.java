package de.threads.basics;

public class ThreadDemo1 {

	public static void main(String[] args) {

		PongThread pongThread = new PongThread();
		pongThread.start();

		for (int i = 0; i < 20; i++)
			System.out.println("Ping");
	}
}
