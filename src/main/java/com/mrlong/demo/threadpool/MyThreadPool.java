package com.mrlong.demo.threadpool;

import java.util.concurrent.*;

/**
 * 线程池创建
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 11:25 上午
 */
public class MyThreadPool {


    public static void main(String[] args) {
        // 查看cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors() + "核");
        // Executors.newCachedThreadPool() // 可扩容的线程池
        // Executors.newFixedThreadPool()  // 固定的线程池
        // newSingleThreadExecutor()       // 单独线程池

        /**
         * 线程池中的7大参数的意思
         * int corePoolSize,                线程池中核心线程数
         * int maximumPoolSize,             线程池中同时容纳最大线程数
         * long keepAliveTime,              在规定的keepAliveTime时间内单位为（TimeUnit unit），
         *                                  没有多余的线程请求时 会把线程销毁到corePoolSize大小
         * TimeUnit unit,                   时间单位
         * BlockingQueue<Runnable> workQueue,   阻塞队列， 当达到了maximumPoolSize时候 回到阻塞队列中排队
         * ThreadFactory threadFactory,         生成线程池中工作线程的工厂，用于创建线程
         * RejectedExecutionHandler handler     拒绝策略
         */

        // 可扩容的线程池
        //ExecutorService executorService1 = Executors.newCachedThreadPool();
        // 单线程池
        //ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        // 池子5工作线程， 固定线程池
        ExecutorService executorService3 = Executors.newFixedThreadPool(5);

        try {
            // 模拟10个人办理业务，每一个用户就是来自外部的请求
            for (int i = 1; i <= 10; i++) {
                executorService3.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService3.shutdown();
        }

    }

}
