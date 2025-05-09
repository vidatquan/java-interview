package core_java.theory;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

public class thread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

    }
}
