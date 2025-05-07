hương thức wait() trong thread
Phương thức wait() là một phương thức của lớp Object trong Java, được sử dụng để giao tiếp giữa các thread. Nó cho phép một thread tạm dừng thực thi và chờ đợi cho đến khi một thread khác thông báo cho nó biết rằng nó có thể tiếp tục.

Cách thức hoạt động của phương thức wait():
Thread gọi wait(): Khi một thread gọi phương thức wait() trên một đối tượng, nó nhường lại khóa của đối tượng đó (khóa monitor) và chuyển sang trạng thái waiting.

Điều này có nghĩa là thread sẽ chờ đợi cho đến khi một thread khác thông báo cho nó bằng cách gọi phương thức notify() hoặc notifyAll() trên đối tượng đó.

Trong khi thread đang chờ đợi, các thread khác có thể thực hiện công việc của chúng.

Khối đồng bộ hóa (synchronized): Phương thức wait() chỉ có thể được gọi trong một khối synchronized. Điều này có nghĩa là thread phải giữ khóa của đối tượng trước khi gọi wait(). Nếu không, Java sẽ ném ra IllegalMonitorStateException.

Sử dụng của wait() trong giao tiếp giữa các thread:
Phương thức wait() thường được sử dụng trong các tình huống đồng bộ hóa khi một thread cần chờ cho một sự kiện xảy ra trước khi tiếp tục thực thi. Ví dụ, trong mô hình producer-consumer, một thread sản xuất (producer) có thể gọi wait() nếu nó không thể sản xuất thêm dữ liệu, và một thread tiêu thụ (consumer) sẽ gọi notify() để thông báo rằng dữ liệu đã sẵn sàng để tiêu thụ.

Ví dụ về sử dụng wait() và notify():
Giả sử chúng ta có một hệ thống producer-consumer trong đó một thread sản xuất dữ liệu và một thread tiêu thụ dữ liệu. Producer sẽ gọi wait() khi bộ đệm đầy, và consumer sẽ gọi notify() khi có dữ liệu tiêu thụ xong.

java
Copy
class DataBuffer {
private int data;
private boolean available = false;

    // Producer method
    public synchronized void produce(int data) throws InterruptedException {
        while (available) {
            wait();  // Nếu dữ liệu đã có sẵn, producer sẽ chờ
        }
        this.data = data;
        available = true;
        System.out.println("Produced: " + data);
        notify();  // Thông báo consumer rằng dữ liệu đã sẵn sàng
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();  // Nếu không có dữ liệu, consumer sẽ chờ
        }
        available = false;
        System.out.println("Consumed: " + data);
        notify();  // Thông báo producer rằng chỗ trống đã có sẵn
        return data;
    }
}

public class ProducerConsumerExample {
public static void main(String[] args) {
DataBuffer buffer = new DataBuffer();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
Giải thích:
Producer thread: Khi sản xuất dữ liệu, nếu bộ đệm đã đầy (available = true), nó sẽ gọi phương thức wait() để dừng lại cho đến khi có thông báo từ consumer.

Consumer thread: Khi tiêu thụ dữ liệu, nếu không có dữ liệu (available = false), nó sẽ gọi phương thức wait() để chờ cho đến khi có dữ liệu mới được producer sản xuất. Sau khi tiêu thụ xong, nó gọi notify() để thông báo producer rằng bộ đệm có không gian trống để sản xuất dữ liệu.

Tóm lại:
Phương thức wait() giúp một thread tạm dừng thực thi và chờ đợi cho đến khi một thread khác gọi phương thức notify() hoặc notifyAll().

Phương thức wait() là một phần của cơ chế giao tiếp giữa các thread, đặc biệt trong các mô hình như producer-consumer, nơi mà các thread cần đồng bộ hóa việc truy cập và thay đổi tài nguyên chung.

Phương thức wait() chỉ có thể được gọi trong một khối synchronized để đảm bảo rằng thread giữ được khóa của đối tượng khi gọi wait().







