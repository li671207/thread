package com.lihl.state;

public class BlockedJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new JoinTest());
		t.start();
		for (int i = 0; i < 10; i++) {
			if (i==3) {
				t.join();
			}
			System.out.println("BlockedJoin.main()");
		}
	}

}

class JoinTest implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("JoinTest.run()");
		}
	}
	
}
