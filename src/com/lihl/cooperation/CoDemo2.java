package com.lihl.cooperation;

/**
 * 信号灯法：借助标志位
 * 
 * @author lihl
 *
 */
public class CoDemo2 {

	public static void main(String[] args) {
		Tv tv = new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
	}

}

class Player extends Thread {
	Tv tv;

	public Player(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				tv.play("MyPlay");
			} else {
				tv.play("OtherPlay");
			}
		}

	}
}

class Watcher extends Thread {
	Tv tv;

	public Watcher(Tv tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();
		}
	}
}

class Tv {
	String voice;
	boolean flag = true;

	public synchronized void play(String voice) {
		if (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.voice = voice;
		System.out.println("play:" + voice);
		this.flag = !this.flag;
		this.notifyAll();
	}

	public synchronized void watch() {
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("watch:" + voice);
		this.flag = !this.flag;
		this.notifyAll();
	}
}
