# thread
多线程Demo

<pre>
核心概念
• 线程就是独立的执行路径；
• 在程序运行时，即使没有自己创建线程，后台也会存在多个线程，
如gc线程、主线程；
• main()称之为主线程,为系统的入口点，用于执行整个程序；
• 在一个进程中，如果开辟了多个线程，线程的运行由调度器安排
调度，调度器是与操作系统紧密相关的，先后顺序是不能人为的
干预的；
• 对同一份资源操作时，会存在资源抢夺的问题，需要加入并发控
制;
• 线程会带来额外的开销,如cpu调度时间,并发控制开销
• 每个线程在自己的工作内存交互，加载和存储主内存控制不当会
造成数据不一致。
</pre>

![Image 创建线程](https://raw.githubusercontent.com/li671207/thread/master/images/20190609151009.png)

<pre>
lamda
(params) -> expression
(params) -> statement
(params) -> { statements }
• λ希腊字母表中排序第十一位的字母，英语名称为
Lambda，
• 避免匿名内部类定义过多
• 其实质属于函数式编程的概念

new Thread(()->System.out.println("多线程学习)).start()
</pre>

![Image 线程状态1](https://raw.githubusercontent.com/li671207/thread/master/images/20190609160547.png)
![Image 线程状态2](https://raw.githubusercontent.com/li671207/thread/master/images/20190609155749.png)

<pre>
线程方法
• sleep () 
• 使线程停止运行一段时间，将处于阻塞状态
• 如果调用了sleep方法之后，没有其他等待执行的线程，这个时候当前线程不会马上恢复执行！
• join () 
• 阻塞指定线程等到另一个线程完成以后再继续执行。
• yield () 
• 让当前正在执行线程暂停，不是阻塞线程，而是将线程转入就绪状态;
• 调用了yield方法之后，如果没有其他等待执行的线程，此时当前线程就会马上恢复执行！
• setDaemon() 
• 可以将指定的线程设置成后台线程,守护线程;
• 创建用户线程的线程结束时，后台线程也随之消亡;
• 只能在线程启动之前把它设为后台线程
• setPriority(int newPriority) getPriority()
• 线程的优先级代表的是概率
• 范围从1到10，默认为5
• stop()停止线程
• 不推荐使用
</pre>

<pre>
sleep
• sleep(时间)指定当前线程阻塞的毫秒数;
• sleep存在异常InterruptedException;
• sleep时间达到后线程进入就绪状态;
• sleep可以模拟网络延时、倒计时等。
• 每一个对象都有一个锁，sleep不会释放锁;
</pre>