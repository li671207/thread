package com.lihl.other;


/**
 * DCL单例模式：双重检测锁
 * @author lihl
 *
 */
public class DoubleCheckedLocking {
	private static volatile DoubleCheckedLocking instance;//volatile：避免指令重排

	private DoubleCheckedLocking() {

	}

	public static DoubleCheckedLocking getInstance() {
		if (instance != null) {//已经存在对象情况，避免不必要的同步
			return instance;
		}
		synchronized (DoubleCheckedLocking.class) {
			if (instance == null) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				instance = new DoubleCheckedLocking();
			}
		}

		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {
				System.out.println(DoubleCheckedLocking.getInstance());
			}).start();
		}

	}

}
