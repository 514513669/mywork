package com.mrlong.demo;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

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

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("我的线程-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(4, 10000,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();

    }

}
