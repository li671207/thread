package com.lihl.syn;

/**
 * 线程安全
 * 
 * @author lihl
 *
 */
public class SynDemo2 {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		Account account = new Account("money", 1000);
		new SynDrawMoney(account, 80, "my").start();
		new SynDrawMoney(account, 90, "other").start();
		System.out.println(System.currentTimeMillis() - s);
	}

}

class SynDrawMoney extends Thread {
	Account account;
	int drawMoney;
	int pocketMoney;

	public SynDrawMoney(Account account, int drawMoney, String name) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}

	@Override
	public void run() {
		test();
	}

	public void test() {
		if (account.money <= 0) {
			return;
		}
		synchronized (account) {
			if (account.money < drawMoney) {
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money -= drawMoney;
			pocketMoney += drawMoney;
			System.out.println(Thread.currentThread().getName() + "余额：" + account.money);
			System.out.println(Thread.currentThread().getName() + "现金：" + pocketMoney);
		}
	}

}