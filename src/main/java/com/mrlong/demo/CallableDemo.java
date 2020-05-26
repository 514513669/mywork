package com.mrlong.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyData {

    private int number = 1;
    private final Lock lock = new ReentrantLock();
    public Condition c1 = lock.newCondition();
    public Condition c2 = lock.newCondition();
    public Condition c3 = lock.newCondition();


    /**
     * Condition demo
     * 模拟
     * 1A 2B 3C  A 打印5次， B 打印10次 C打印15次  以上打印5轮
     *
     * @param emun         获取值
     * @param printCount   打印个数
     * @param next         通知下一个
     * @param conditionnow 当前等待
     * @param condition    通知下一个执行
     */
    public void print(int emun, int printCount, int next, Condition conditionnow, Condition condition) {
        lock.lock();
        try {
            // 判断
            while (number != emun) {
                conditionnow.await();
            }
            // 干活
            for (int i = 1; i <= printCount; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 通知
            number = next;
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

/**
 * Callable线程demo
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/25 9:52 下午
 */
public class CallableDemo {

    public static void main(String[] args) {

        MyData data = new MyData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.print(1, 5, 2, data.c1, data.c2);
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.print(2, 10, 3, data.c2, data.c3);
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.print(3, 15, 1, data.c3, data.c1);
            }
        }, "CCC").start();
    }


}
