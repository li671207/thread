package com.lihl.other;


/**
 * volatile 保证数据可见性，避免指令重排，不保证数据原子性
 * @author lihl
 *
 */
public class VolatileDemo {
	private volatile static int a = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			while (a == 0) {

			}
		}).start();

		Thread.sleep(1000);
		a = 1;
	}

}
