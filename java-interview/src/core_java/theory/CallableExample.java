package core_java.theory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//Có 2 cách chính để tạo và khởi chạy Thread trực tiếp: Thread và Runnable.
//Callable là để tạo tác vụ có kết quả, và cần chạy thông qua ExecutorService, chứ không phải Thread thuần.

public class CallableExample {
    public static void main(String[] args) throws Exception {
        // 1. Tạo ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 2. Tạo Callable task
        Callable<String> task = () -> {
            Thread.sleep(1000); // mô phỏng xử lý mất thời gian
            return "Kết quả từ Callable";
        };

        // 3. Gửi task cho executor để xử lý
        Future<String> future = executor.submit(task);

        // 4. Làm việc khác nếu muốn...

        // 5. Lấy kết quả từ Callable
        String result = future.get(); // đợi kết quả (blocking)
        System.out.println("Kết quả: " + result);

        // 6. Tắt Executor
        executor.shutdown();
    }
}
