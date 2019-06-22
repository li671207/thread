package com.lihl.other;

/**
 * InheritableThreadLocal:继承上下文，数据拷贝
 * 
 * @author Lihl
 *
 */
public class ThreadLocalDemo4 {
	private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

	public static void main(String[] args) throws InterruptedException {
		threadLocal.set(10);
		System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		Thread t1 = new Thread(() -> {
			threadLocal.set(20);
			System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		});
		Thread t2 = new Thread(() -> {
			threadLocal.set(30);
			System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
		});
		t1.join();
		t2.join();
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
	}

}
