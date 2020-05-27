package com.mrlong.demo.callable;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MySource implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "***************** come in Callable");
        //TimeUnit.MILLISECONDS.sleep(3);
        return 1024;
    }
}


/**
 * @author liulong
 * @version 1.0
 * @date 2020/5/27 9:50 下午
 */
public class CallableDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MySource());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MySource());

        new Thread(futureTask, "AAA").start();
        new Thread(futureTask2, "BBB").start();


        System.out.println("********* main");
        while (!futureTask.isDone()) {
            //System.out.println("线程正在计算中。。。。");
        }
        int result01 = futureTask.get();
        int result02 = futureTask2.get();
        System.out.println("*********" + (result01 + result02));

    }

}
