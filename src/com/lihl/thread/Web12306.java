package com.lihl.thread;

public class Web12306 implements Runnable {

	private int ticketNum = 99;

	@Override
	public void run() {
		while (true) {
			if (ticketNum < 0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +":"+ ticketNum--);
		}
	}
	
	public static void main(String[] args) {
		Web12306 web12306 = new Web12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web12306,"thread1").start();
		new Thread(web12306,"thread2").start();
		new Thread(web12306,"thread3").start();
	}

}
