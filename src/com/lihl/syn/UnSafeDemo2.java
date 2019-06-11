package com.lihl.syn;

public class UnSafeDemo2 {

	public static void main(String[] args) {
		Account account = new Account("money", 100);
		new DrawMoney(account, 80, "my").start();
		new DrawMoney(account, 90, "other").start();
	}

}

class Account {
	String name;
	int money;

	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

}

class DrawMoney extends Thread {
	Account account;
	int drawMoney;
	int pocketMoney;

	public DrawMoney(Account account, int drawMoney, String name) {
		super(name);
		this.account = account;
		this.drawMoney = drawMoney;
	}

	@Override
	public void run() {
		account.money -= drawMoney;
		pocketMoney += drawMoney;
		System.out.println(Thread.currentThread().getName()+"余额：" + account.money);
		System.out.println(Thread.currentThread().getName()+"现金：" + pocketMoney);
	}

}
