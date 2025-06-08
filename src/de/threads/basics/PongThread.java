package de.threads.basics;

public class PongThread extends Thread {

	public void run() {
		for (int i = 0; i < 20; i++)
			System.out.println("Pong");
	}

}
