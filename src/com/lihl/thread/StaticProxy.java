package com.lihl.thread;

public class StaticProxy {

	public static void main(String[] args) {
		new WeddingCompany(new My()).marry();
	}

}

interface Marry {
	void marry();
}

class My implements Marry {

	@Override
	public void marry() {
		System.out.println("My.marry()");
	}

}

class WeddingCompany implements Marry {
	private My target;

	public WeddingCompany(My target) {
		super();
		this.target = target;
	}

	@Override
	public void marry() {
		System.out.println("before");
		target.marry();
		System.out.println("after");
	}

}
