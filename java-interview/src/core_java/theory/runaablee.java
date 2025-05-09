package core_java.theory;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnale implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

public class runaablee {
    public static void main(String[] args) {
        Thread t2 = new Thread(new MyRunnale());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("Hello World 123"));
        t3.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println("Task 1"));
        executorService.submit(() -> System.out.println("Task 2"));
        executorService.shutdown();
    }
}
