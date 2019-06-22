package com.lihl.other;

public class ThreadLocalDemo1 {
	//初始化
	/*private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 10;
		};
	};*/
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 100);
	

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
		
		threadLocal.set(200);
		System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
		
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	
	}

	static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*99));
			System.out.println(threadLocal.get());
		}
	}
	
}
