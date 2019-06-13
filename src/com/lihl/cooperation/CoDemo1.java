package com.lihl.cooperation;


/**
 * 管程法：借助缓冲区
 * @author lihl
 *
 */
public class CoDemo1 {

	public static void main(String[] args) {
		SteamedBunContainer container = new SteamedBunContainer();
		new Thread(new Producer(container)).start();
		new Thread(new Comsumer(container)).start();
	}

}

class Producer implements Runnable {
	SteamedBunContainer container;

	public Producer(SteamedBunContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			container.push(new SteamedBun(i));
			System.out.println("生产:" + i);
		}
	}
}

class Comsumer implements Runnable {
	SteamedBunContainer container;

	public Comsumer(SteamedBunContainer container) {
		this.container = container;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("消费:" + container.pop().id);
		}
	}
}

class SteamedBunContainer {
	SteamedBun[] steamedBuns = new SteamedBun[10];
	int count = 0;

	public synchronized void push(SteamedBun steamedBun) {
		if (count == steamedBuns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		steamedBuns[count] = steamedBun;
		count++;
		notifyAll();// 通知消费者
	}

	public synchronized SteamedBun pop() {
		if (count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		SteamedBun steamedBun = steamedBuns[--count];
		notifyAll();// 通知生产者

		return steamedBun;
	}

}

class SteamedBun {
	int id;

	public SteamedBun(int id) {
		super();
		this.id = id;
	}

}
