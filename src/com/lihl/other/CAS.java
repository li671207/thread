package com.lihl.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS compare and swap :原子操作
 * 
 * @author lihl
 *
 */
public class CAS {

	private static AtomicInteger atomicInteger = new AtomicInteger(6);

	public static void main(String[] args) {

		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Integer left = atomicInteger.decrementAndGet();
				if (left < 1) {
					System.out.println(Thread.currentThread().getName() + ":" + "done....");
					return;
				}
				System.out.println(Thread.currentThread().getName() + ":" + left);
			}).start();
		}
	}

}
