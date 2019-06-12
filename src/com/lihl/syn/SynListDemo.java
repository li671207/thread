package com.lihl.syn;

import java.util.concurrent.CopyOnWriteArrayList;

public class SynListDemo {

	public static void main(String[] args) throws InterruptedException {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(Thread.currentThread().getName());
		}
		Thread.sleep(1000);
		System.out.println(list.size());
	}

}
