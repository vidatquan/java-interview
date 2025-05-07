Enhanced @Deprecated Annotation
Mở rộng @Deprecated: Java 9 cải tiến cách sử dụng chú thích @Deprecated, bao gồm khả năng chỉ định lý do tại sao một thành phần bị đánh dấu là deprecated và khi nào nó sẽ bị loại bỏ.

Ví dụ:

java
Copy
@Deprecated(since="9", forRemoval=true)
public void oldMethod() {
// logic
}
4. Private Methods in Interfaces
   Java 9 cho phép khai báo phương thức private trong các interface. Điều này giúp tái sử dụng mã trong các phương thức default mà không cần phải sử dụng phương thức public hoặc protected.

Ví dụ:

java
Copy
interface MyInterface {
private void helperMethod() {
// logic
}

    default void defaultMethod() {
        helperMethod();
    }
}
5. Process API Updates
   Java 9 cải thiện API ProcessBuilder và cung cấp API Process mới để kiểm soát và quản lý các tiến trình hệ điều hành bên ngoài.

Lợi ích:

Giúp tương tác với các tiến trình hệ thống tốt hơn, quản lý các tiến trình con và cải thiện khả năng kiểm tra tiến trình.

Ví dụ:

java
Copy
Process process = new ProcessBuilder("someCommand").start();
6. Stack Walking API
   API Stack Walking mới giúp lập trình viên có thể dễ dàng lấy thông tin về stack trace mà không cần phải sử dụng các phương thức truyền thống như Thread.getStackTrace().

Ví dụ:

java
Copy
StackWalker walker = StackWalker.getInstance();
walker.forEach(frame -> System.out.println(frame.getClassName()));
7. HTTP/2 Client (Incubator)
   HTTP/2 Client là tính năng thử nghiệm trong Java 9, cung cấp API mới để hỗ trợ HTTP/2 (giao thức web nhanh hơn và hiệu quả hơn so với HTTP/1.1).

Ví dụ:

java
Copy
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder(URI.create("http://example.com"))
.build();
client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
.thenApply(HttpResponse::body)
.thenAccept(System.out::println);
8. Improved Stream API
   Java 9 bổ sung một số phương thức mới vào Stream API:

takeWhile(): Lọc phần tử trong Stream dựa trên một điều kiện cho đến khi điều kiện không còn đúng.

dropWhile(): Bỏ qua các phần tử trong Stream cho đến khi điều kiện không còn đúng.

ofNullable(): Khởi tạo Stream từ giá trị có thể là null.

Ví dụ:

java
Copy
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
numbers.takeWhile(n -> n < 4).forEach(System.out::println);  // 1, 2, 3
9. Immutable Collections
   Java 9 giới thiệu các phương thức tạo Collections không thể thay đổi (immutable) thông qua các phương thức như List.of(), Set.of(), và Map.of(). Điều này giúp giảm thiểu sự thay đổi không mong muốn trong các collection.

Ví dụ:

java
Copy
List<String> immutableList = List.of("a", "b", "c");
10. Enhanced Optional
    Optional API được cải tiến với các phương thức mới như ifPresentOrElse(), stream(), và or() để làm việc với giá trị rỗng (empty) dễ dàng hơn.

Ví dụ:

java
Copy
Optional<String> optional = Optional.of("Hello");
optional.ifPresentOrElse(System.out::println, () -> System.out.println("Empty"));
11. Improved @SafeVarargs
    Java 9 cải tiến @SafeVarargs cho phép bạn đảm bảo an toàn với các tham số varargs khi sử dụng chúng trong các phương thức final hoặc static.

12. Enhanced Java Compilation
    Cải thiện công cụ javac để hỗ trợ biên dịch nhanh hơn và tốt hơn.

Javac giờ đây có thể biên dịch nhanh hơn với các cải tiến trong việc xử lý thông tin mô-đun.