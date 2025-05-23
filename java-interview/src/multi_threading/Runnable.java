package multi_threading;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();  // Bắt đầu thread
    }
}