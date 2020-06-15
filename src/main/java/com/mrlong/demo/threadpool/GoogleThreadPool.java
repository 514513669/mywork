package com.mrlong.demo.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liulong
 * @version 1.0
 * @date 2020/6/2 5:02 下午
 */
public class GoogleThreadPool {

    public static final ThreadFactory NAMED_THREAD_FACTORY = new ThreadFactoryBuilder()
            .setNameFormat("工作线程池-%d").build();

    /**
     * Common Thread Pool
     */
    public static final ExecutorService POOL = new ThreadPoolExecutor(1000, 2000,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), NAMED_THREAD_FACTORY, new ThreadPoolExecutor.AbortPolicy());

    //pool.execute(()-> System.out.println(Thread.currentThread().getName()));
    //pool.shutdown();//gracefully shutdown

    /**
     * 关闭线程池
     */
    public static void shutdownPool () {
        POOL.shutdown();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            POOL.execute(() -> {
                try {
                    Integer call = new MyBus().call();
                    System.out.println(Thread.currentThread().getName()+ "\t" +call);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        shutdownPool();

    }

}

class MyBus implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return -1;
    }

}
