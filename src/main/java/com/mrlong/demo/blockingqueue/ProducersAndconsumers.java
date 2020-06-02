package com.mrlong.demo.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyDatas {

    /**
     * volatile所有线程可见 默认开启
     */
    private volatile boolean flag = true;

    /**
     * CAS
     */
    private final AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 阻塞队列
     */
    private final BlockingQueue<String> blockingQueue;

    public MyDatas(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者
     */
    public void prod() throws Exception {
        String data;
        boolean resultVal;
        // 判断
        while (flag) {
            // ++i
            data = atomicInteger.getAndIncrement() + "";
            resultVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (resultVal) {
                System.out.println(Thread.currentThread().getName() + "\t" + "生产队列成功！");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + "生产队列失败！");
            }
            //TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "停止生产，flag=false表示生产结束");
    }

    /**
     * 消费者
     */
    public void consumer() throws InterruptedException {
        String poll;
        while (flag) {
            poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (poll == null || "".equals(poll)) {
                // 判断如果没有消费到返回
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "没有可消费的资源退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "消费队列" + poll + "成功");
        }
    }

    /**
     * 停止
     */
    public void stop() {
        this.flag = false;
    }

}


/**
 * 生产者和消费者
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/26 9:39 下午
 */
public class ProducersAndconsumers {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(13 & 17);
        /*MyDatas datas = new MyDatas(new ArrayBlockingQueue<>(3));

        new Thread(() -> {
            try {
                //成产者
                datas.prod();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();


        new Thread(() -> {
            try {
                datas.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        TimeUnit.SECONDS.sleep(2);
        datas.stop();*/

    }

}
