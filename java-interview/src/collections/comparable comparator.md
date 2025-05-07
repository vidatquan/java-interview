1. Comparable Interface
   Đặc điểm:

Comparable là một giao diện được sử dụng để cung cấp khả năng xắp xếp tự nhiên cho các đối tượng của lớp.

Giao diện này thuộc java.lang package.

Cách sử dụng:

Khi một lớp implement giao diện Comparable, lớp đó phải cung cấp phương thức compareTo(), để so sánh hai đối tượng của lớp đó.

Phương thức compareTo() phải trả về một giá trị:

Giá trị âm nếu đối tượng hiện tại (this) phải đứng trước đối tượng so sánh.

Giá trị dương nếu đối tượng hiện tại (this) phải đứng sau đối tượng so sánh.

Giá trị bằng 0 nếu hai đối tượng là giống nhau.

Ví dụ:

java
Copy
public class Employee implements Comparable<Employee> {
private String name;
private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee other) {
        return this.age - other.age;  // So sánh theo tuổi
    }
}
Ứng dụng:

Khi bạn thêm các đối tượng vào các collection như TreeSet, TreeMap, nếu lớp của đối tượng implement Comparable, thì chúng sẽ được sắp xếp theo thứ tự tự nhiên (mặc định) của đối tượng đó.

2. Comparator Interface
   Đặc điểm:

Comparator là một giao diện được sử dụng để xây dựng các cách sắp xếp tùy chỉnh cho các đối tượng.

Giao diện này thuộc java.util package.

Cách sử dụng:

Khi bạn cần một cách sắp xếp tùy chỉnh khác, bạn có thể tạo một lớp implement giao diện Comparator và cung cấp phương thức compare() của giao diện này.

Phương thức compare() trong Comparator so sánh hai đối tượng và trả về giá trị âm, dương hoặc 0 tương tự như trong compareTo() của Comparable.

Ví dụ:

java
Copy
public class EmployeeComparator implements Comparator<Employee> {
@Override
public int compare(Employee e1, Employee e2) {
return e1.name.compareTo(e2.name);  // So sánh theo tên
}
}
Ứng dụng:

Comparator được sử dụng khi bạn muốn sắp xếp đối tượng theo nhiều cách khác nhau mà không thay đổi lớp của đối tượng đó.

Bạn có thể truyền Comparator vào các phương thức của collection (như TreeSet, TreeMap, Collections.sort()) để quyết định cách so sánh.

3. Sự khác biệt chính giữa Comparable và Comparator:
   Comparable:

Dùng khi bạn muốn xác định cách sắp xếp mặc định cho các đối tượng của lớp.

Lớp của bạn phải implement giao diện Comparable và cung cấp phương thức compareTo().

Dùng khi bạn chỉ cần một cách sắp xếp duy nhất (thường là sắp xếp theo một thuộc tính mặc định của đối tượng).

Comparator:

Dùng khi bạn muốn tạo nhiều cách sắp xếp tùy chỉnh cho các đối tượng.

Bạn có thể tạo nhiều Comparator khác nhau để sắp xếp theo các thuộc tính khác nhau.

Dùng khi bạn cần thay đổi cách so sánh giữa các đối tượng mà không thay đổi lớp của đối tượng đó.

4. Tóm lại:
   Comparable là sự lựa chọn khi bạn muốn cung cấp một cách sắp xếp mặc định cho đối tượng của lớp.

Comparator là sự lựa chọn khi bạn cần nhiều cách sắp xếp tùy chỉnh mà không làm thay đổi lớp của đối tượng.

Các Comparator có thể được sử dụng linh hoạt hơn so với Comparable và có thể được truyền vào các phương thức sắp xếp trong các collection để cho phép thay đổi cách sắp xếp đối tượng theo nhiều cách khác nhau.