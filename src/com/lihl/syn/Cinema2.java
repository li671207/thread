package com.lihl.syn;

import java.util.ArrayList;
import java.util.List;

public class Cinema2 {

	public static void main(String[] args) {
		List<Integer> available = new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(4);
		available.add(5);
		available.add(6);
		available.add(7);
		available.add(8);

		NewMyCinema myCinema = new NewMyCinema(available, "ll");

		List<Integer> seat1 = new ArrayList<>();
		seat1.add(1);
		seat1.add(2);
		seat1.add(3);
		List<Integer> seat2 = new ArrayList<>();
		seat2.add(8);
		seat2.add(9);

		Thread t1 = new Thread(new NewCustomer(myCinema, seat1), "thread1");
		Thread t2 = new Thread(new NewCustomer(myCinema, seat2), "thread2");

		t1.start();
		t2.start();

	}

}

class NewCustomer implements Runnable {
	NewMyCinema myCinema;
	List<Integer> seat;

	public NewCustomer(NewMyCinema myCinema, List<Integer> seat) {
		this.myCinema = myCinema;
		this.seat = seat;
	}

	@Override
	public void run() {
		synchronized (myCinema) {
			boolean flag = myCinema.bookTickets(seat);
			if (flag) {
				System.out.println(Thread.currentThread().getName() + "-->success:" + seat);
			} else {
				System.out.println(Thread.currentThread().getName() + "-->failed:" + seat);
			}
		}
	}

}

class NewMyCinema {
	List<Integer> available;
	String name;

	public NewMyCinema(List<Integer> available, String name) {
		this.available = available;
		this.name = name;
	}

	public boolean bookTickets(List<Integer> seat) {
		System.out.println("剩余：" + available);
		List<Integer> temp = new ArrayList<>();
		temp.addAll(available);
		available.removeAll(seat);
		if (temp.size() - available.size() != seat.size()) {
			available = temp;
			return false;
		}

		return true;
	}
}
