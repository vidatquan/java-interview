Java 8 đã mang đến rất nhiều tính năng mới và cải tiến mạnh mẽ, làm thay đổi cách viết và sử dụng mã nguồn trong Java. Dưới đây là các tính năng mới nổi bật trong Java 8:

1. Lambda Expressions
   Lambda expressions giúp bạn viết mã ngắn gọn và dễ hiểu hơn, đặc biệt là khi làm việc với các interface hàm (functional interfaces). Lambda cho phép bạn truyền các hành vi (behavior) dưới dạng đối số trong các phương thức.

Cú pháp: (parameter) -> expression

Ví dụ:

java
Copy
// Trước Java 8:
List<String> names = Arrays.asList("John", "Jane", "Jack");
Collections.sort(names, new Comparator<String>() {
@Override
public int compare(String o1, String o2) {
return o1.compareTo(o2);
}
});

// Sau Java 8 sử dụng Lambda:
Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
2. Functional Interfaces
   Một functional interface là một interface chỉ có một phương thức duy nhất. Các interface này là cơ sở để sử dụng lambda expressions.

Ví dụ: Runnable, Callable, Comparator, Predicate, Function, v.v.

Bạn có thể sử dụng annotation @FunctionalInterface để chỉ ra rằng một interface là functional.

Ví dụ:

java
Copy
@FunctionalInterface
public interface MyFunction {
int apply(int a, int b);
}
3. Streams API
   Streams API là một cách mạnh mẽ để xử lý dữ liệu theo kiểu hàm, hỗ trợ các thao tác như lọc, sắp xếp, giảm dần (reduce), nhóm (grouping), v.v. Stream có thể giúp bạn xử lý các tập hợp (collections) một cách dễ dàng và hiệu quả hơn.

Các stream có thể là sequential (mặc định) hoặc parallel.

Ví dụ:

java
Copy
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = numbers.stream()
.map(n -> n * n)
.collect(Collectors.toList());
4. Default Methods
   Java 8 cho phép bạn định nghĩa các default methods trong interfaces. Điều này giúp tránh việc phải thay đổi toàn bộ các lớp implement interface khi thêm phương thức mới vào interface.

Cú pháp: default <return-type> methodName() { }

Ví dụ:

java
Copy
public interface MyInterface {
default void greet() {
System.out.println("Hello from default method!");
}
}
5. Method References
   Method references là một cú pháp ngắn gọn để tham chiếu đến phương thức thay vì phải gọi nó qua biểu thức lambda.

Các loại method reference: static method, instance method, constructor reference.

Ví dụ:

java
Copy
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.forEach(System.out::println); // Sử dụng method reference
6. Optional Class
   Optional là một lớp được giới thiệu để xử lý giá trị null an toàn, tránh lỗi NullPointerException.

Optional giúp bạn kiểm tra nếu giá trị có tồn tại hay không mà không cần phải kiểm tra null thủ công.

Ví dụ:

java
Copy
Optional<String> name = Optional.of("John");
name.ifPresent(n -> System.out.println(n)); // In ra "John" nếu có giá trị
7. New Date and Time API (java.time)
   Java 8 giới thiệu một API mới cho việc làm việc với ngày và giờ, thay thế cho java.util.Date và java.util.Calendar. API mới bao gồm các lớp như LocalDate, LocalTime, LocalDateTime, ZonedDateTime, Duration, và Period.

Ví dụ:

java
Copy
LocalDate today = LocalDate.now();
LocalDate nextWeek = today.plusWeeks(1);
System.out.println(nextWeek);
8. Nashorn JavaScript Engine
   Java 8 tích hợp một engine JavaScript mới có tên Nashorn, giúp thực thi mã JavaScript trực tiếp từ Java với hiệu suất tốt hơn so với Rhino (JavaScript engine trước đó).

Ví dụ:

java
Copy
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JavaScript!')");
9. Streams Parallel Processing
   Streams API cho phép bạn xử lý dữ liệu song song (parallel) rất dễ dàng bằng cách sử dụng phương thức parallel(), giúp tận dụng nhiều lõi CPU và tăng tốc xử lý các dữ liệu lớn.

Ví dụ:

java
Copy
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream()
.mapToInt(Integer::intValue)
.sum();
10. Collectors API
    Collectors là một lớp tiện ích giúp thực hiện các phép toán thu thập và nhóm dữ liệu, như toList(), groupingBy(), partitioningBy(), joining(), và nhiều cái khác.

Ví dụ:

java
Copy
List<String> words = Arrays.asList("apple", "banana", "cherry");
String result = words.stream()
.collect(Collectors.joining(", "));
System.out.println(result);  // Output: apple, banana, cherry
11. Base64 Encoding/Decoding
    Java 8 thêm vào các phương thức mã hóa và giải mã Base64 trong lớp java.util.Base64, giúp việc xử lý chuỗi Base64 dễ dàng hơn.

Ví dụ:

java
Copy
String encoded = Base64.getEncoder().encodeToString("Hello".getBytes());
System.out.println(encoded);  // Output: SGVsbG8=
12. Parallel Array Sorting
    Java 8 cung cấp một phương thức để sắp xếp mảng song song một cách dễ dàng với Arrays.parallelSort(), giúp tăng hiệu suất cho các mảng lớn.

Ví dụ:

java
Copy
int[] numbers = {5, 3, 8, 1, 4};
Arrays.parallelSort(numbers);
System.out.println(Arrays.toString(numbers));  // Output: [1, 3, 4, 5, 8]
Tóm tắt:
Java 8 mang đến nhiều tính năng mạnh mẽ, đặc biệt là các tính năng liên quan đến lập trình hàm (functional programming) như Lambda Expressions, Streams API, và Method References. Những cải tiến này không chỉ giúp viết mã dễ dàng hơn mà còn nâng cao hiệu suất và tính linh hoạt của ứng dụng.






You said:
FunctionalInterface nói rõ hơn


ChatGPT said:
@FunctionalInterface là một annotation trong Java 8 dùng để chỉ rõ rằng một interface là một functional interface. Một functional interface là một interface có chỉ một phương thức trừu tượng (abstract method) duy nhất. Các functional interface là cơ sở để sử dụng lambda expressions và method references trong Java.

Đặc điểm của Functional Interface:
Chỉ có một phương thức trừu tượng: Một functional interface chỉ có thể có một phương thức trừu tượng. Tuy nhiên, nó có thể có nhiều phương thức mặc định (default) hoặc phương thức tĩnh (static).

Có thể có phương thức default và static: Ngoài phương thức trừu tượng duy nhất, functional interface có thể có các phương thức default hoặc static.

@FunctionalInterface là tùy chọn: Bạn có thể đánh dấu một interface là functional bằng cách sử dụng annotation @FunctionalInterface. Mặc dù annotation này không bắt buộc, nhưng nó giúp biên dịch Java kiểm tra rằng interface này chỉ có một phương thức trừu tượng và đảm bảo rằng bạn không vô tình thêm phương thức trừu tượng thứ hai.

Cú pháp của Functional Interface:
java
Copy
@FunctionalInterface
public interface MyFunctionalInterface {
void abstractMethod();  // Phương thức trừu tượng duy nhất

    // Phương thức default
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
    
    // Phương thức static
    static void staticMethod() {
        System.out.println("This is a static method");
    }
}
Ví dụ về Functional Interface:
Functional Interface cơ bản:
Đây là ví dụ đơn giản về một functional interface có một phương thức trừu tượng duy nhất.

java
Copy
@FunctionalInterface
public interface MyFunction {
int add(int a, int b);  // Phương thức trừu tượng duy nhất
}
Bạn có thể sử dụng lambda expression để triển khai interface này:

java
Copy
public class Main {
public static void main(String[] args) {
// Sử dụng lambda để triển khai MyFunction
MyFunction addition = (a, b) -> a + b;

        System.out.println(addition.add(5, 3));  // Output: 8
    }
}
Functional Interface với default method:
Functional interface có thể chứa phương thức default, giúp cung cấp các phương thức mặc định mà không cần phải triển khai lại trong các lớp implement interface đó.

java
Copy
@FunctionalInterface
public interface MyCalculator {
int calculate(int a, int b);

    // Phương thức default
    default void printResult(int result) {
        System.out.println("The result is: " + result);
    }
}
Sử dụng:

java
Copy
public class Main {
public static void main(String[] args) {
MyCalculator add = (a, b) -> a + b;
int result = add.calculate(10, 20);
add.printResult(result);  // Output: The result is: 30
}
}
Functional Interface với static method:
Functional interface có thể có phương thức static. Tuy nhiên, phương thức static không phải là phương thức trừu tượng và không cần phải được triển khai lại trong lớp implement interface.

java
Copy
@FunctionalInterface
public interface MyMath {
int multiply(int a, int b);

    // Phương thức static
    static int subtract(int a, int b) {
        return a - b;
    }
}
Sử dụng:

java
Copy
public class Main {
public static void main(String[] args) {
MyMath multiplication = (a, b) -> a * b;
System.out.println(multiplication.multiply(5, 3));  // Output: 15

        System.out.println(MyMath.subtract(10, 5));  // Output: 5
    }
}
Các lợi ích của Functional Interface:
Tính linh hoạt: Functional interfaces cung cấp một cơ chế mạnh mẽ để sử dụng lambda expressions, giúp làm giảm sự phức tạp của mã nguồn khi cần truyền các hành vi (behavior) như đối số của phương thức.

Tăng tính tái sử dụng: Bạn có thể sử dụng functional interface trong các API như Streams API và Collections để thực hiện các thao tác phức tạp mà không cần phải viết mã thừa.

Dễ đọc và bảo trì mã: Lambda expressions và functional interface giúp mã ngắn gọn và dễ hiểu hơn so với việc sử dụng các class cồng kềnh.

Các Interface trong Java 8 là Functional Interface:
Runnable: Interface dùng cho các luồng.

Callable: Tương tự như Runnable nhưng có thể trả về một giá trị.

Comparator: Dùng để so sánh các đối tượng.

Predicate: Dùng để kiểm tra các điều kiện và trả về giá trị boolean.

Function: Dùng để áp dụng một hàm với đầu vào và trả về kết quả.

Consumer: Dùng để tiêu thụ một đối tượng mà không trả về giá trị.

Ví dụ thực tế về sử dụng Functional Interface với Lambda Expression:
Giả sử bạn muốn xử lý một danh sách các số và in ra các số chẵn:

java
Copy
import java.util.Arrays;
import java.util.List;

public class Main {
public static void main(String[] args) {
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Dùng lambda expression để lọc và in ra các số chẵn
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });
    }
}
Tóm lại:
Functional Interface chỉ có một phương thức trừu tượng duy nhất và có thể có thêm phương thức mặc định hoặc phương thức tĩnh.

Chúng là cơ sở để sử dụng lambda expressions và method references trong Java.

Annotation @FunctionalInterface giúp đảm bảo rằng interface chỉ có một phương thức trừu tượng, tránh việc thêm các phương thức không cần thiết.