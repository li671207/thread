package com.lihl.syn;

public class Cinema {

	public static void main(String[] args) {
		MyCinema myCinema = new MyCinema(2, "ll");

		Thread t1 = new Thread(new Customer(myCinema, 2), "thread1");
		Thread t2 = new Thread(new Customer(myCinema, 1), "thread2");

		t1.start();
		t2.start();

	}

}

class Customer implements Runnable {
	MyCinema myCinema;
	int seat;

	public Customer(MyCinema myCinema, int seat) {
		this.myCinema = myCinema;
		this.seat = seat;
	}

	@Override
	public void run() {
		synchronized (myCinema) {
			boolean flag = myCinema.bookTickets(seat);
			if (flag) {
				System.out.println(Thread.currentThread().getName() + "-->success：" + seat);
			} else {
				System.out.println(Thread.currentThread().getName() + "-->failed");
			}
		}
	}

}

class MyCinema {
	int available;
	String name;

	public MyCinema(int available, String name) {
		this.available = available;
		this.name = name;
	}

	public boolean bookTickets(int seat) {
		System.out.println("剩余：" + available);
		if (seat > available) {
			return false;
		}
		available -= seat;
		return true;
	}
}
