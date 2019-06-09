package com.lihl.thread;

public class Racer implements Runnable {

	private String winner;

	public static void main(String[] args) {
		Racer racer = new Racer();
		new Thread(racer, "tortoies").start();
		new Thread(racer, "rabbit").start();
	}

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			if (winner != null) {
				break;
			} else {
				if (i == 100) {
					winner = Thread.currentThread().getName();
					System.out.println("Winner:" + Thread.currentThread().getName());
					break;
				}
			}
		}
	}

}
