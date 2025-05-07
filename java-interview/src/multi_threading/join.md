Phương thức join() trong Java
Phương thức join() trong Java cho phép một thread chờ đợi một thread khác hoàn thành trước khi tiếp tục thực thi. Khi một thread gọi join() trên một thread khác, thread hiện tại sẽ tạm dừng và chờ đợi cho đến khi thread mà nó gọi join() hoàn thành công việc của mình. Điều này rất hữu ích khi bạn muốn đảm bảo rằng các thread thực thi theo thứ tự nhất định.

Các phiên bản của phương thức join():
Có ba phiên bản của phương thức join():

join() (không tham số):

Phiên bản này sẽ khiến thread gọi join() phải đợi cho đến khi thread mà join() được gọi hoàn thành (chết).

Thread gọi join() sẽ tạm dừng và chờ đợi cho thread mà nó gọi join() hoàn thành công việc trước khi tiếp tục.

Nếu thread đang thực thi bị gián đoạn, một InterruptedException sẽ được ném ra.

Ví dụ:

java
Copy
class MyThread extends Thread {
@Override
public void run() {
System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
}
}

public class JoinExample {
public static void main(String[] args) throws InterruptedException {
MyThread thread1 = new MyThread();
MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        thread1.join();  // Main thread sẽ đợi thread1 hoàn thành
        System.out.println("Thread1 has finished, now main thread resumes.");

        thread2.join();  // Main thread sẽ đợi thread2 hoàn thành
        System.out.println("Thread2 has finished, now main thread completes.");
    }
}
join(long milliseconds):

Phiên bản này khiến thread gọi join() phải chờ đợi trong một khoảng thời gian nhất định (số mili giây) cho đến khi thread được gọi join() hoàn thành hoặc thời gian chờ hết.

Thread hiện tại sẽ không chờ đợi vô hạn, thay vào đó, nó sẽ chờ trong khoảng thời gian đã cho, sau đó sẽ tiếp tục thực thi dù cho thread khác đã hoàn thành hay chưa.

Ví dụ:

java
Copy
class MyThread extends Thread {
@Override
public void run() {
try {
Thread.sleep(3000);  // Giả lập thời gian thực thi
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Thread " + Thread.currentThread().getName() + " has finished.");
}
}

public class JoinExample {
public static void main(String[] args) throws InterruptedException {
MyThread thread1 = new MyThread();
thread1.start();

        thread1.join(2000);  // Chờ tối đa 2000 mili giây
        System.out.println("Main thread resumes after waiting for thread1 (max 2000ms).");
    }
}
join(long milliseconds, int nanoseconds):

Phiên bản này cho phép bạn chờ đợi trong một khoảng thời gian chính xác, bao gồm cả mili giây và nano giây.

Đây là một sự mở rộng của phiên bản trước, cho phép xác định thời gian chờ một cách chính xác hơn.

Ví dụ:

java
Copy
class MyThread extends Thread {
@Override
public void run() {
try {
Thread.sleep(3000);  // Giả lập thời gian thực thi
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Thread " + Thread.currentThread().getName() + " has finished.");
}
}

public class JoinExample {
public static void main(String[] args) throws InterruptedException {
MyThread thread1 = new MyThread();
thread1.start();

        thread1.join(2000, 500000);  // Chờ tối đa 2000ms và 500 nanoseconds
        System.out.println("Main thread resumes after waiting for thread1 (max 2000ms 500ns).");
    }
}
Lý do sử dụng phương thức join():
Đảm bảo thứ tự thực thi: Khi bạn muốn đảm bảo rằng một thread phải hoàn thành công việc trước khi thread khác tiếp tục, phương thức join() giúp thực hiện điều này.

Điều khiển luồng: join() giúp quản lý việc đồng bộ giữa các thread, đảm bảo các thread có thể làm việc một cách có tổ chức và không xung đột với nhau.

Chờ đợi kết quả từ thread: Đôi khi bạn cần chờ đợi kết quả từ một thread trước khi tiếp tục thực thi, phương thức join() sẽ giúp bạn làm điều này.

Tóm lại:
join() giúp thread hiện tại chờ đợi cho thread khác hoàn thành công việc của nó.

Phiên bản không tham số sẽ chờ đợi vô hạn cho đến khi thread hoàn thành.

Phiên bản với thời gian chờ (milliseconds và nanoseconds) cho phép thread chờ đợi trong một khoảng thời gian giới hạn.

join() giúp đồng bộ hóa và đảm bảo thứ tự thực thi giữa các thread trong các ứng dụng đa luồng.