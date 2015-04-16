package com.buptcoder.acm;

import java.util.concurrent.*;

public class MultipleThread {
    public void testThread() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
    }

    public static long time(Executor executor, int concurrency,
            final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();
                    }
                }

            });
        }
        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNanos;
    }
    
    public static void main(String[] args) {
        System.out.println((-2147483648)/(-1));
    }
}
