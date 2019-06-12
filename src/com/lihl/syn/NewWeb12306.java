package com.lihl.syn;

public class NewWeb12306 {

	public static void main(String[] args) {
		My12306 myCinema = new My12306(3, "test");

		Thread t1 = new Passenger(myCinema, "thread1", 2);
		Thread t2 = new Passenger(myCinema, "thread2", 2);

		t1.start();
		t2.start();

	}

}

// 顾客
class Passenger extends Thread {
	int seat;

	public Passenger(Runnable target, String name, int seat) {
		super(target, name);
		this.seat = seat;
	}

}

class My12306 implements Runnable {
	int available;
	String name;

	public My12306(int available, String name) {
		this.available = available;
		this.name = name;
	}

	@Override
	public void run() {
		Passenger passenger = (Passenger) Thread.currentThread();
		boolean flag = bookTickets(passenger.seat);
		if (flag) {
			System.out.println(Thread.currentThread().getName() + "-->success：" + passenger.seat);
		} else {
			System.out.println(Thread.currentThread().getName() + "-->failed");
		}
	}

	public synchronized boolean bookTickets(int seat) {
		System.out.println("剩余：" + available);
		if (seat > available) {
			return false;
		}
		available -= seat;
		return true;
	}
}
