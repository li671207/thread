package com.lihl.syn;

/**
 * 死锁：不在同一代码块，同时持有多个对象锁
 * @author lihl
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		new MakeUp(1, "Dead1").start();
		new MakeUp(0, "Dead2").start();
	}

}

class Lipstick{
	
}

class Mirror{
	
}

class MakeUp extends Thread {
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	int flag;
	String name;
	
	public MakeUp(int flag, String name) {
		super();
		this.flag = flag;
		this.name = name;
	}

	@Override
	public void run() {
//		makeUp();//死锁
		makeUp1();
	}
	
	private void makeUp1() {
		if (flag == 1) {
			synchronized (lipstick) {
				System.out.println(name + "lipstick");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (mirror) {
				System.out.println(name + "mirror");
			}
		} else {
			synchronized (mirror) {
				System.out.println(name + "lipstick");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			synchronized (lipstick) {
				System.out.println(name + "mirror");
			}
		}
	}

	/**
	 * 死锁
	 */
	private void makeUp() {
		if (flag == 1) {
			synchronized (lipstick) {
				System.out.println(name + "lipstick");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(name + "mirror");
				}
			}
		} else {
			synchronized (mirror) {
				System.out.println(name + "lipstick");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lipstick) {
					System.out.println(name + "mirror");
				}
			}
		}
	}
}