package com.lihl.syn;

/**
 * 线程安全
 * 
 * @author lihl
 *
 */
public class SynDemo1 {

	public static void main(String[] args) {
		SynWeb12306 web12306 = new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web12306, "thread1").start();
		new Thread(web12306, "thread2").start();
		new Thread(web12306, "thread3").start();

	}

}

class SynWeb12306 implements Runnable {

	private int ticketNum = 100;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test();
		}
	}

	private synchronized void test() {
		if (ticketNum <= 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + ticketNum--);
	}

}