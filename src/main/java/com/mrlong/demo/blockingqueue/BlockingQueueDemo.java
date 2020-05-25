package com.mrlong.demo.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * add
 * remove 没有报异常
 *
 * offer
 * pool 没有返回null
 *
 * put  没有 线程一直等待 一直阻塞
 * take
 *
 * 常用 boolean offer(E e, long timeout, TimeUnit unit)
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/25 4:59 下午
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));



    }

}


