package com.mrlong.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 使用场景
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 4:16 下午
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        // 3个车位
        Semaphore semaphore = new Semaphore(3);

        // 6个车
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "号车抢到车位！");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "停车3秒后离开车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }

}
