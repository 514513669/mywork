package com.mrlong.demo.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class MyData {

    private int number = 0;

    private final Lock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    /**
     * 加法
     */
    public void increment() {

        lock.lock();
        try {
            // 1,判断
            while (number != 0) {
                // 等待， 不能生成
                condition.await();
            }

            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + number);

            // 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 减法
     */
    public void decrement() {

        lock.lock();
        try {
            // 1,判断
            while (number == 0) {
                // 等待， 不能生成
                condition.await();
            }

            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + number);

            // 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 题目：
 *      一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1， 来5轮
 *      传统版的解决方案
 *      1，线程操作资源类
 *
 *
 *      2，线程             操作(方法)          资源类
 *      3，判断             干活          通知
 *      4, 防止虚假唤醒机制（多线程的判断要用while）
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/25 5:22 下午
 */
public class ProdConsumer_TradittionDem {


    public static void main(String[] args) {
        MyData data = new MyData();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                // 做++
                data.increment();
            }, "AA我的第"+ i+"个线程").start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                // 做--
                data.decrement();
            }, "BB我的第" + i + "个线程").start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                // 做++
                data.increment();
            }, "CC我的第"+ i+"个线程").start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                // 做--
                data.decrement();
            }, "DD我的第" + i + "个线程").start();
        }
    }

}

