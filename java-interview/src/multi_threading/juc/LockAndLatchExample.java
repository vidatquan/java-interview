package multi_threading.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockAndLatchExample {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int sharedResource = 0;
    private static final int NUM_TASKS = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(NUM_TASKS);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Gửi 5 tác vụ
        for (int i = 0; i < NUM_TASKS; i++) {
            executor.submit(() -> {
                lock.lock();
                try {
                    sharedResource++;
                    System.out.println(Thread.currentThread().getName() + " incremented to " + sharedResource);
                } finally {
                    lock.unlock();
                }
                latch.countDown();
            });
        }

        // Đợi tất cả tác vụ hoàn thành
        latch.await();
        System.out.println("Final shared resource value: " + sharedResource);

        // Đóng executor
        executor.shutdown();
    }
}
