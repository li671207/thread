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
