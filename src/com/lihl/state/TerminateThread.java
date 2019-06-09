package com.lihl.state;

public class TerminateThread implements Runnable {

	private boolean flag = true;
	private String name;

	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(name + ":" + i++);
		}
	}

	private void terminate() {
		this.flag = false;
	}

	public static void main(String[] args) {
		TerminateThread thread = new TerminateThread("Test");
		new Thread(thread).start();
		for (int i = 0; i < 50; i++) {
			if (i == 22) {
				System.out.println("\n");
				thread.terminate();
				System.out.println("TerminateThread.terminate()");
				System.out.println("\n");
			}

			 System.out.println("TerminateThread.main()" + i);
		}

	}

}
