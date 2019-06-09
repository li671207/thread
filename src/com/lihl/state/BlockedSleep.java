package com.lihl.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedSleep {

	public static void main(String[] args) throws InterruptedException {
		// 倒计时
		Date date = new Date(System.currentTimeMillis() + 1000 * 10);
		long now = date.getTime();
		while (true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(date));
			Thread.sleep(1000);
			date = new Date(date.getTime() - 1000);

			if (now - 10000 > date.getTime()) {
				break;
			}
		}
	}

}
