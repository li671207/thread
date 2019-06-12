package com.lihl.syn;

/**
 * 线程安全
 * 
 * @author lihl
 *
 */
public class SynDemo1 {

	public static void main(String[] args) throws InterruptedException {
		SynWeb12306 web12306 = new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		Thread t1 = new Thread(web12306, "thread1");
		Thread t2 = new Thread(web12306, "thread2");
		Thread t3 = new Thread(web12306, "thread3");
		long s = System.currentTimeMillis();
		t1.start();
		t2.start();
		t3.start();
		System.out.println(System.currentTimeMillis()-s);

	}

}

class SynWeb12306 implements Runnable {

	private int ticketNum = 30;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			test3();
		}
	}
	
	//双重检测
	private void test3() {
		if (ticketNum <= 0) {//无票
			flag = false;
			return;
		}
		synchronized (this) {
			if (ticketNum <= 0) {//最后一张票
				flag = false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + ticketNum--);
		}
	}
	
	//范围不正确
	private void test2() {
		synchronized (this) {
			if (ticketNum <= 0) {
				flag = false;
				return;
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ":" + ticketNum--);
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
	
	//线程安全  范围大  效率低
	private void test1() {
		synchronized(this) {
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

}