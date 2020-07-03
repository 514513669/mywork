package com.mrlong.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private final Map<String, Object> map = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * 写
     * 需要原子 + 独立  过程不能被插入
     */
    public void put(String key, Object object) {
        // 加锁共享锁（写锁）
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写操作开始");
            map.put(key, object);
            System.out.println(Thread.currentThread().getName() + "\t写操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            rwLock.writeLock().unlock();
        }
    }

    /**
     * 读操作
     */
    public void get(String key) {
        // 加锁共享锁（读锁）
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取数据");
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取数据完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}


/**
 * 读写锁
 * 读 读 共享
 * 写 写 不共享
 *
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 1:51 下午
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final String is = String.valueOf(i);
            new Thread(() -> {
                myCache.put(is, is + "我的资源");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            String is = String.valueOf(i);
            new Thread(() -> {
                myCache.get(is);
            }, String.valueOf(i)).start();
        }

    }

}
