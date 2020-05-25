package com.mrlong.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 4:02 下午
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        //public CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("**********召唤神龙********");
        });

        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "第"+ temp +"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "我的第"+ i +"个龙珠").start();
        }

    }

}
