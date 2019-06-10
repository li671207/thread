package com.lihl.state;

import java.lang.Thread.State;

public class ThreadState {

	public static void main(String[] args) {
		Thread thread = new Thread(()->{
			System.out.println(".....");
		});
		
		State state = thread.getState();
		System.out.println(state);
		
		thread.start();
		state = thread.getState();
		System.out.println(state);
		
		while (true) {
			int activeCount = Thread.activeCount();
			if (activeCount == 1) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = thread.getState();
			System.out.println(state);
		}
		
		state = thread.getState();
		System.out.println(state);
		
		
	}

}
