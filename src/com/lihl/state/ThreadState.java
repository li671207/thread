package com.lihl.state;

import java.lang.Thread.State;

public class ThreadState {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(".....");
			}
		});

		State state = thread.getState();
		System.out.println(state);

		thread.start();
		state = thread.getState();
		System.out.println(state);

		while (true) {
			int activeCount = Thread.activeCount();
			System.out.println(activeCount);
			if (activeCount == 1) {
				break;
			}
			try {
				Thread.sleep(200);
				state = thread.getState();
				System.out.println(state);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		state = thread.getState();
		System.out.println(state);

	}

}
