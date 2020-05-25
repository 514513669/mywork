package com.mrlong.demo.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * -- 同步阻塞队列  不存储线程， 来一个线程 必须消费一个线程，否则一直等待线程被消费
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 5:05 下午
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\tput a");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName() + "\tput b");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName() + "\tput c");
                synchronousQueue.put("c");
                System.out.println(Thread.currentThread().getName() + "\tput d");
                synchronousQueue.put("d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "我的第一个线程").start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\ttake " + synchronousQueue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\ttake " + synchronousQueue.take());

                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\ttake " + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "我的第二个线程").start();

    }

}
