package com.mrlong.demo;

import com.mrlong.demo.enums.CountEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 2:31 下午
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {
        countDownLatchDemo();

    }

    /**
     * CountDownLatch 代码演示
     */
    private static void countDownLatchDemo() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }, CountEnum.getCountEnum(i).getMsg() + "同学").start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===========我是最后一个同学=============");
    }

}
