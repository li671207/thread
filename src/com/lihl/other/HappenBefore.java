package com.lihl.other;

/**
 * 指令重排
 * 
 * @author lihl
 *
 */
public class HappenBefore {

	private static int a = 0;
	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			a = 0;
			flag = false;
			Thread t1 = new Thread(() -> {
				a = 1;
				flag = true;
			});

			Thread t2 = new Thread(() -> {
				if (flag) {
					a *= 1;
				}
				//指令重排
				if (a == 0) {
					System.out.println(Thread.currentThread().getName() + ">>>" + a);
				}
			});

			t1.start();
			t2.start();

			t1.join();
			t2.join();
		}
	}

}
