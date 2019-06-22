package com.lihl.other;

/**
 * 可重入锁
 * 
 * @author lihl
 *
 */
public class LockTest2 {
	ReLock lock = new ReLock();
//	ReentrantLock lock = new ReentrantLock();//JUC:可重入锁

	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		b();
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}

	public void b() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		System.out.println("......");
		lock.unlock();
		System.out.println(lock.getHoldCount());

	}

	public static void main(String[] args) throws InterruptedException {
		LockTest2 lockTest = new LockTest2();
		lockTest.a();
		System.out.println(lockTest.lock.getHoldCount());
	}

}

class ReLock {
	private boolean isLock = false;// 锁是否被占用
	private Thread lockThread;
	private int holdCount = 0;

	public int getHoldCount() {
		return holdCount;
	}

	public synchronized void lock() throws InterruptedException {
		Thread thread = Thread.currentThread();
		while (isLock && lockThread != thread) {// 锁被持有，且被锁线程不为当前运行线程，等待，计数器加1
			wait();
		}
		holdCount++;
		isLock = true;
		lockThread = thread;
	}

	public synchronized void unlock() {// 被锁线程为当前运行线程，释放锁。计数器减1
		if (lockThread == Thread.currentThread()) {
			holdCount--;
			if (holdCount == 0) {
				isLock = false;
				notify();
				lockThread = null;
			}
		}
	}
}
