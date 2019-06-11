package com.lihl.state;

/**
 * 守护线程
 * 
 * @author lihl
 *
 */
public class DaemonDemo {

	public static void main(String[] args) {
		Thread self = new Thread(new Self(), "self");
		Thread god = new Thread(new God(), "god");
		god.setDaemon(true);
		self.start();
		god.start();

	}

}

class Self implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}

class God implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
