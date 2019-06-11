package com.lihl.state;

public class AliveDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Alive("lhl"));
		thread.setName("alive");
		thread.start();
		System.out.println(thread.isAlive());
		Thread.sleep(100);
		System.out.println(thread.isAlive());
		
	}

}

class Alive implements Runnable {
	private String name;

	public Alive(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":" + name);
	}

}
