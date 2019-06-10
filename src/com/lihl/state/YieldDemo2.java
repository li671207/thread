package com.lihl.state;

/**
 * 礼让线程，进入就绪状态
 * 
 * @author lihl
 *
 */
public class YieldDemo2 {

	public static void main(String[] args) {

		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda.." + i);
			}
		}).start();

		for (int i = 0; i < 100; i++) {
			System.out.println("main.." + i);
			if (i % 20 == 0) {
				Thread.yield();
			}
		}

	}

}
