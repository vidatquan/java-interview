Thread Synchronization:
Trong Java, synchronization là một cơ chế quan trọng khi chúng ta có nhiều thread truy cập vào cùng một đối tượng hoặc dữ liệu. Nếu không có cơ chế đồng bộ, các thread có thể thao tác đồng thời lên cùng dữ liệu, dẫn đến lỗi dữ liệu không nhất quán hoặc sự xung đột giữa các thread.

Vấn đề khi không có synchronization:
Khi có nhiều thread truy cập vào cùng một đối tượng hoặc tài nguyên, chúng có thể thay đổi giá trị của tài nguyên đó cùng lúc, dẫn đến lỗi race condition. Ví dụ, nếu hai thread cùng sửa đổi giá trị của một biến mà không có sự đồng bộ, kết quả cuối cùng có thể không chính xác.

Cách hoạt động của synchronization:
Khi một phương thức hoặc đoạn mã được đánh dấu với từ khóa synchronized, chỉ một thread có thể truy cập vào phương thức đó tại một thời điểm. Các thread khác phải chờ cho đến khi thread đầu tiên hoàn thành công việc của nó và giải phóng khóa (lock) trên phương thức hoặc đối tượng đó.

Synchronized method: Khi phương thức được đánh dấu là synchronized, thread đầu tiên vào phương thức sẽ chiếm khóa trên đối tượng hoặc lớp (nếu phương thức là static) đó.

Synchronized block: Bạn có thể sử dụng synchronized trong một khối mã thay vì toàn bộ phương thức để đồng bộ hóa một phần cụ thể của phương thức.

Synchronized static method: Nếu phương thức là static, khóa sẽ được áp dụng cho toàn bộ lớp, không phải cho đối tượng cụ thể.

Ví dụ về synchronized method:
java
Copy
class Counter {
    private int count = 0;

    // Phương thức synchronized, chỉ cho phép một thread vào cùng lúc
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SyncExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Tạo nhiều thread truy cập vào cùng một đối tượng
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());  // Kết quả đúng: 2000
    }
}
Trong ví dụ này, phương thức increment() được đánh dấu là synchronized, giúp đảm bảo rằng chỉ một thread có thể thay đổi giá trị count tại một thời điểm. Điều này tránh được race condition.

Synchronized block:
Đôi khi, bạn chỉ muốn đồng bộ hóa một phần mã thay vì toàn bộ phương thức. Trong trường hợp này, bạn có thể sử dụng synchronized block.

Ví dụ về synchronized block:
java
Copy
class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {  // Chỉ đồng bộ hóa phần mã này
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
Synchronized static method:
Nếu bạn muốn đồng bộ hóa phương thức static, khóa sẽ được áp dụng cho toàn bộ lớp thay vì đối tượng cụ thể.

Ví dụ về synchronized static method:
java
Copy
class SharedResource {
    private static int count = 0;

    // Synchronized static method
    public synchronized static void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
Lý do sử dụng synchronized:
Tránh lỗi dữ liệu không nhất quán: Khi nhiều thread truy cập vào cùng một tài nguyên hoặc đối tượng, việc sử dụng synchronized giúp đảm bảo rằng chỉ có một thread được phép truy cập tại một thời điểm, tránh sự xung đột.

Bảo vệ tài nguyên chung: Giúp bảo vệ các tài nguyên chung khỏi sự thay đổi đồng thời không kiểm soát, đảm bảo tính chính xác của dữ liệu.

Tóm lại:
synchronized là một công cụ quan trọng giúp kiểm soát truy cập đồng thời vào tài nguyên hoặc đối tượng chung.

Phương thức synchronized giúp khóa toàn bộ phương thức, đảm bảo rằng một thread duy nhất có thể truy cập vào phương thức đó tại một thời điểm.

Khối synchronized giúp đồng bộ hóa một phần mã trong phương thức, giúp tăng tính linh hoạt.

Static synchronized method đồng bộ hóa phương thức ở cấp lớp, giúp bảo vệ tài nguyên toàn cục.

Bằng cách sử dụng synchronization, bạn có thể đảm bảo sự an toàn khi làm việc với các thread trong môi trường đa luồng, tránh các vấn đề như race condition và dữ liệu không chính xác.