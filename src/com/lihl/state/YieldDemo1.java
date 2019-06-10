package com.lihl.state;

/**
 * 礼让线程，进入就绪状态
 * 
 * @author lihl
 *
 */
public class YieldDemo1 {

	public static void main(String[] args) {

		new Thread(new Yield(), "a").start();
		new Thread(new Yield(), "b").start();

	}

}

class Yield implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "111111");
		Thread.yield();
		System.out.println(Thread.currentThread().getName() + "22222");

	}

}
