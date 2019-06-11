package com.lihl.syn;

import java.util.ArrayList;
import java.util.List;

public class UnSafeDemo3 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		
		System.out.println(list.size());
	}

}
