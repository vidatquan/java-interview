# Tổng Hợp Kiến Thức về Constructor trong Java

## 1. Constructor là gì?
- **Constructor** là một phương thức đặc biệt được sử dụng để khởi tạo đối tượng khi nó được tạo ra.
- Nó có cùng tên với tên lớp, khác với các phương thức thông thường có tên riêng.
- Constructor chỉ được gọi một lần khi đối tượng của lớp đó được tạo ra.

## 2. Khác biệt giữa Constructor và Các Phương Thức Thông Thường:
- **Tên**:
    - **Constructor** có cùng tên với tên lớp.
    - Các phương thức thông thường có tên khác với tên lớp.

- **Mục Đích**:
    - **Constructor** dùng để khởi tạo các thuộc tính (fields) của đối tượng khi đối tượng được tạo.
    - **Các phương thức thông thường** dùng để thực hiện các hành động hoặc thao tác trên đối tượng đã được khởi tạo.

- **Lần Gọi**:
    - **Constructor** chỉ được gọi **một lần duy nhất** khi đối tượng được tạo ra, ví dụ: `Accord car = new Accord();`.
    - **Các phương thức thông thường** có thể được gọi bất kỳ lúc nào sau khi đối tượng đã được khởi tạo.

- **Kiểu Trả Về**:
    - **Constructor** không có kiểu trả về, không thể dùng `void` hoặc bất kỳ kiểu trả về nào.
    - **Các phương thức thông thường** phải có kiểu trả về (ví dụ: `void`, `int`, `String`,...).

## 3. Gọi Constructor từ Constructor khác:
- Bạn có thể **gọi một constructor từ constructor khác** trong cùng một lớp bằng cách sử dụng từ khóa `this()`. Điều này cho phép bạn tạo ra các constructor khác nhau với các tham số khác nhau (constructor overloading).

```java
class Accord {
    private String model;
    private int year;

    // Constructor 1
    public Accord(String model) {
        this.model = model;
    }

    // Constructor 2
    public Accord(String model, int year) {
        this(model); // Gọi Constructor 1
        this.year = year;
    }
}
```

4. Gọi Constructor của Lớp Cha:
Khi một lớp kế thừa từ lớp khác, bạn có thể gọi constructor của lớp cha từ constructor của lớp con bằng cách sử dụng từ khóa super(). Điều này cần thiết khi lớp cha có constructor nhận tham số và bạn muốn truyền giá trị cho nó khi tạo đối tượng của lớp con.

6. Tóm Tắt:
      Constructor: Dùng để khởi tạo đối tượng, có cùng tên với lớp, không có kiểu trả về, chỉ được gọi khi đối tượng được tạo ra.

this(): Dùng để gọi constructor khác trong cùng một lớp (chaining constructor).

super(): Dùng để gọi constructor của lớp cha từ lớp con.