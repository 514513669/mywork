package com.mrlong.demo.threadpool;


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
        // 查看cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
