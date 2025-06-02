package multi_threading.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AtomicIntegerExample {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Gửi 1000 tác vụ tăng bộ đếm
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                counter.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " incremented counter to " + counter.get());
            });
        }

        // Đóng executor và đợi
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // In kết quả
        System.out.println("Final counter value: " + counter.get());
    }
}

