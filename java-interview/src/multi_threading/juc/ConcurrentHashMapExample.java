package multi_threading.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};

        // Tạo thread pool với 2 luồng
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Gửi tác vụ đếm từ
        for (String word : words) {
            executor.submit(() -> {
                wordCount.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
                System.out.println(Thread.currentThread().getName() + " updated count for " + word);
            });
        }

        // Đóng executor và đợi
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // In kết quả
        System.out.println("Word counts: " + wordCount);
    }
}
