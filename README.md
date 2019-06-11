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
线程停止
• 不使用JDK提供的stop()/destroy()方法(它们本身也被JDK废弃了)。
• 提供一个boolean型的终止变量，当这个变量置为false，则终止线程的运行。
</pre>
<pre>
sleep
• sleep(时间)指定当前线程阻塞的毫秒数;
• sleep存在异常InterruptedException;
• sleep时间达到后线程进入就绪状态;
• sleep可以模拟网络延时、倒计时等。
• 每一个对象都有一个锁，sleep不会释放锁;
</pre>
<pre>
join
• join合并线程,待此线程执行完成后，再执行其他线程，其他线程阻塞
</pre>
<pre>
yield
• 礼让线程,让当前正在执行线程暂停
• 不是阻塞线程，而是将线程从运行状态转入就绪状态
• 让cpu调度器重新调度
</pre>
<pre>
priority
Java提供一个线程调度器来监控程序中启动后进入就绪状态的所有线程。线程调度器按照线程的优先级决定应调度哪个线程来执行。线程的优先级用数字表示，
范围从1到10
• Thread.MIN_PRIORITY = 1
• Thread.MAX_PRIORITY = 10
• Thread.NORM_PRIORITY = 5
使用下述方法获得或设置线程对象的优先级。
• int getPriority();
• void setPriority(int newPriority);
优先级的设定建议在start()调用前
注意：优先级低只是意味着获得调度的概率低。并不是绝对先调用优先级高后调用优先级低的线程。

daemon
• 线程分为用户线程和守护线程;
• 虚拟机必须确保用户线程执行完毕;
• 虚拟机不用等待守护线程执行完毕;
• 如后台记录操作日志、监控内存使用等

其它常用方法
isAlive() 判断线程是否还活着,即线程是否还未终止
setName() 给线程起一个名字
getName() 获取线程的名字
currentThread() 取得当前正在运行的线程对象，也就是获取自己本身
</pre>

<pre>
<b>线程同步</b>
线程同步其实就是一种等待机制，多个需要同时访问此对象的线程进入这个对象的等待池形成队列，等待前面的线程使用完毕后，下一个线程再使用。
</pre>
