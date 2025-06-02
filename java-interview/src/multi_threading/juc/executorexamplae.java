package multi_threading.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class executorexamplae {
    public static void main(String[] args) {
        // Tạo ThreadPoolExecutor với 3 luồng và hàng đợi có giới hạn
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                3, // corePoolSize: số luồng tối thiểu
                3, // maximumPoolSize: số luồng tối đa
                0L, TimeUnit.MILLISECONDS, // thời gian chờ khi luồng không hoạt động
                new LinkedBlockingQueue<>(10) // hàng đợi giới hạn 10 tác vụ
        );

        // Danh sách để lưu các Future chứa kết quả
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());

                // Mô phỏng công việc nặng
                Thread.sleep(1000);
                if (taskId == 5) {
                    throw new RuntimeException("Error in task " + taskId);
                }

                return taskId * taskId;
            };

            results.add(executor.submit(task));
        }

        // Lấy kết quả từ các tác vụ
        for (Future<Integer> result : results) {
            try {
                System.out.println("Result: " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Task failed: " + e.getMessage());
            }
        }

        // Đóng executor
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

    }
}
