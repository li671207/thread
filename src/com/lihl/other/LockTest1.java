package com.lihl.other;

/**
 * 不可重入锁
 * 
 * @author lihl
 *
 */
public class LockTest1 {
	Lock lock = new Lock();
	
	public void a() throws InterruptedException {
		lock.lock();
		b();
		lock.unLock();
	}
	public void b() throws InterruptedException {
		lock.lock();
		System.out.println("......");
		lock.unLock();
		
	}

	public static void main(String[] args) throws InterruptedException {
		LockTest1 lockTest = new LockTest1();
		lockTest.a();
	}

}

class Lock {

	private boolean isLock = false;//锁是否被占用

	public synchronized void lock() throws InterruptedException {
		while (isLock) {//锁被持有，等待
			wait();
		}
		
		isLock = true;
	}
	
	public synchronized void unLock() {//释放锁
		isLock = false;
		notify();
	}
}
