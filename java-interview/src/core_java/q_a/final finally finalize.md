1. final trong Java
   Khái niệm:
   final là một từ khóa trong Java dùng để khai báo các đối tượng mà không thể thay đổi sau khi được gán giá trị.

Cách sử dụng:
Với biến: Khi khai báo một biến với final, giá trị của biến đó không thể thay đổi sau khi được gán một lần.

java
Copy
final int i = 10;
i = 20; // Lỗi: Không thể thay đổi giá trị của i vì nó là final
Với đối tượng: Nếu khai báo một tham chiếu đối tượng với final, bạn không thể thay đổi tham chiếu này để trỏ đến một đối tượng khác, nhưng bạn vẫn có thể thay đổi nội dung bên trong đối tượng đó.

java
Copy
final StringBuilder sb = new StringBuilder("Hello");
sb = new StringBuilder("World"); // Lỗi: Không thể thay đổi tham chiếu vì nó là final
sb.append(" Java"); // Đúng: Nội dung của đối tượng vẫn có thể thay đổi
Với lớp: Nếu một lớp được khai báo với final, lớp đó không thể được kế thừa (inheritance).

java
Copy
final class MyClass {
// Không thể kế thừa MyClass
}
Với phương thức: Nếu một phương thức được khai báo với final, phương thức đó không thể bị ghi đè (override) trong lớp con.

java
Copy
class Parent {
public final void show() {
System.out.println("This is a final method");
}
}
2. finally trong Java
   Khái niệm:
   finally là một khối mã trong xử lý ngoại lệ (exception handling) được sử dụng cùng với try và catch. Khối finally luôn được thực thi, bất kể có ngoại lệ xảy ra hay không.

Cách sử dụng:
Sử dụng với try-catch: Mã trong khối finally luôn được thực thi sau khi các khối try và catch hoàn thành, dùng để thực hiện các công việc cần làm sau khi xử lý ngoại lệ, chẳng hạn như đóng kết nối cơ sở dữ liệu hoặc giải phóng tài nguyên.

java
Copy
try {
// Mã có thể gây ra ngoại lệ
} catch (Exception e) {
// Xử lý ngoại lệ
} finally {
// Mã sẽ luôn được thực thi, dù có ngoại lệ hay không
System.out.println("This will always execute");
}
Sử dụng mà không có catch: Bạn có thể sử dụng finally mà không cần catch. Tuy nhiên, finally vẫn sẽ được thực thi nếu có ngoại lệ hoặc không có ngoại lệ.

java
Copy
try {
// Mã có thể gây ra ngoại lệ
} finally {
// Mã luôn được thực thi
System.out.println("This will always execute");
}
Java 7 trở lên: Khi sử dụng try-with-resources (tính năng mới trong Java 7), các tài nguyên được khai báo trong try sẽ tự động được đóng, do đó bạn không cần phải sử dụng finally để đóng tài nguyên nữa.

java
Copy
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
// Đọc file
} catch (IOException e) {
// Xử lý ngoại lệ
} // Tài nguyên sẽ tự động được đóng khi ra khỏi khối try
3. finalize() trong Java
   Khái niệm:
   finalize() là một phương thức trong lớp Object, được gọi khi garbage collector (GC) chuẩn bị giải phóng bộ nhớ của một đối tượng không còn tham chiếu tới.

Cảnh báo:
Không nên phụ thuộc vào finalize() để dọn dẹp tài nguyên, vì bạn không thể kiểm soát khi nào garbage collector sẽ chạy, do đó phương thức này có thể không được gọi ngay lập tức.

finalize() có thể được override trong lớp của bạn, nhưng việc sử dụng nó để dọn dẹp tài nguyên như đóng kết nối cơ sở dữ liệu, file, socket là không an toàn và không khuyến khích.

Ví dụ:
java
Copy
@Override
protected void finalize() throws Throwable {
// Dọn dẹp tài nguyên trước khi đối tượng bị garbage collector thu hồi
System.out.println("Finalizing object");
super.finalize();
}
📌 Tổng kết
Từ khóa	Mục đích sử dụng	Ví dụ
final	Được sử dụng để tạo ra các hằng số, ngăn chặn kế thừa lớp, ngăn chặn ghi đè phương thức.	final int i = 10; / final class MyClass {}
finally	Được sử dụng trong exception handling để đảm bảo mã luôn được thực thi dù có xảy ra ngoại lệ hay không.	finally { System.out.println("Clean up"); }
finalize()	Được gọi khi garbage collector thu hồi đối tượng, nhưng không nên dùng để dọn dẹp tài nguyên.	protected void finalize() { System.out.println("Finalizing"); }