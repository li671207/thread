package com.lihl.other;


/**
 * 分析上下文
 * @author Lihl
 *
 */
public class ThreadLocalDemo3 {
	// 初始化
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	public static void main(String[] args) {
		new Thread(new MyRun()).start();
	}

	static class MyRun implements Runnable {
		public MyRun() {
			System.out.println("ThreadLocalDemo3.MyRun.MyRun()"+":"+Thread.currentThread().getName()+":"+threadLocal.get());
		}
		
		@Override
		public void run() {
			System.out.println("ThreadLocalDemo3.MyRun.run()"+":"+Thread.currentThread().getName()+"：" + threadLocal.get());
		}
	}

}
