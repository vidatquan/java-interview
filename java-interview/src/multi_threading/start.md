Trong Java, không thể gọi phương thức start() trên một thread nhiều lần. Một khi thread đã được khởi động, nó chỉ có thể thực thi một lần duy nhất, và sau khi hoàn thành việc thực thi phương thức run(), nó sẽ vào trạng thái chết (dead state). Nếu bạn cố gắng khởi động lại một thread, Java sẽ ném ra một ngoại lệ IllegalThreadStateException.

Vòng đời của một Thread:
Mới (New): Một thread được tạo ra nhưng chưa được khởi động.

Runnable: Khi phương thức start() được gọi, thread sẽ chuyển sang trạng thái runnable, và scheduler của thread sẽ phân phối thời gian CPU để thực thi phương thức run().

Blocked/Waiting: Một thread có thể vào trạng thái chờ hoặc bị khóa nếu nó đang chờ tài nguyên hoặc đồng bộ hóa.

Hoàn thành/Dead: Sau khi thread hoàn thành việc thực thi (khi phương thức run() hoàn thành), thread sẽ vào trạng thái chết (dead state) và không thể được khởi động lại.

Quy tắc chính:
Sau khi phương thức run() đã hoàn thành, thread không thể được khởi động lại. Nếu bạn cố gắng gọi phương thức start() một lần nữa trên thread đã hoàn thành, Java sẽ ném ra IllegalThreadStateException.

Ví dụ:
java
Copy
class MyThread extends Thread {
@Override
public void run() {
System.out.println(Thread.currentThread().getName() + " is running.");
}
}

public class ThreadExample {
public static void main(String[] args) {
MyThread thread = new MyThread();

        // Khởi động thread lần đầu tiên
        thread.start();

        // Gọi start một lần nữa sẽ ném ra IllegalThreadStateException vì thread đã ở trạng thái "dead"
        try {
            thread.start();  // Cố gắng gọi start lại trên một thread đã được khởi động
        } catch (IllegalThreadStateException e) {
            System.out.println("Ngoại lệ bị bắt: " + e.getMessage());
        }
    }
}
Giải thích:
Lần gọi đầu tiên start(): Thread sẽ bắt đầu và thực thi phương thức run().

Lần gọi thứ hai start(): Vì thread đã hoàn thành việc thực thi, gọi start() lần nữa sẽ ném ra IllegalThreadStateException.

Tại sao lại như vậy?
Các thread trong Java được thiết kế là đơn vị thực thi một lần. Một khi thread đã hoàn thành công việc, nó không thể tái sử dụng hoặc khởi động lại. Việc cố gắng khởi động lại một thread là vô nghĩa vì tài nguyên của nó (như bộ nhớ, thời gian CPU, v.v.) đã được giải phóng khi thread vào trạng thái chết (dead state).

Hành vi này giúp các thread được sử dụng một cách hiệu quả và ngăn ngừa các hành vi không mong muốn hoặc lỗi khi cố gắng khởi động lại một thread đã kết thúc.