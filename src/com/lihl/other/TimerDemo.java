package com.lihl.other;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer timer = new Timer();
//		timer.schedule(new MyTask(), 3000);
//		timer.schedule(new MyTask(), new Date(1000), 1000);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, 2);
		timer.schedule(new MyTask(), calendar.getTime(), 1000);
	}

}

class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("MyTask.run()");
	}

}
