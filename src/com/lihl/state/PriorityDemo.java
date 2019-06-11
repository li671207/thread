package com.lihl.state;


/**
 * 优先级，调用概率
 * @author lihl
 *
 */
public class PriorityDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		Thread t3 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		Thread t4 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		Thread t5 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		Thread t6 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
		});
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MIN_PRIORITY);
		t6.start();
		t5.start();
		t4.start();
		t3.start();
		t2.start();
		t1.start();
	}

}
