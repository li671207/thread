package com.lihl.thread;


/**
 * lamda
(params) -> expression
(params) -> statement
(params) -> { statements }
• λ希腊字母表中排序第十一位的字母，英语名称为
Lambda，
• 避免匿名内部类定义过多
• 其实质属于函数式编程的概念
new Thread(()->System.out.println("多线程学习。。。。")).start();
 * @author Lihl
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("LambdaTest.main1()");
			}
		}).start();

		new Thread(() -> System.out.println("LambdaTest.main2()")).start();
	}

}
