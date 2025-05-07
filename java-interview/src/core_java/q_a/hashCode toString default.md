# Tổng hợp về `hashCode()` và `toString()` trong Java

Trong Java, các phương thức **`hashCode()`** và **`toString()`** là hai phương thức được định nghĩa trong lớp **`Object`**, và **mỗi lớp trong Java đều kế thừa chúng** từ **`Object`**. Đây là những phương thức cơ bản mà mọi lớp trong Java đều có, và có thể được **ghi đè** (override) nếu cần thiết.

## 1. **`hashCode()` trong Java**

- **Mục đích**: Phương thức **`hashCode()`** trả về một **mã băm** (hash code) cho đối tượng. Mã băm này được sử dụng để phân phối các đối tượng trong các cấu trúc dữ liệu như **`HashMap`**, **`HashSet`**, hoặc **`Hashtable`**.
- **Mặc định của `hashCode()`**:
    - Nếu bạn **không ghi đè** phương thức **`hashCode()`**, thì phương thức mặc định trong lớp **`Object`** sẽ trả về **mã băm** dựa trên **địa chỉ bộ nhớ** của đối tượng.
    - Điều này có nghĩa là nếu bạn không ghi đè `hashCode()`, đối tượng sẽ được phân biệt dựa trên **vị trí trong bộ nhớ**.

### **Khi nào cần ghi đè `hashCode()`?**
- **Khi bạn ghi đè `equals()`**, bạn phải ghi đè **`hashCode()`** để đảm bảo tính nhất quán giữa hai phương thức này. Nếu hai đối tượng **bằng nhau** (theo `equals()`), chúng phải có **mã băm giống nhau**.
- Nếu bạn không ghi đè **`hashCode()`**, hai đối tượng có cùng giá trị thuộc tính có thể trả về mã băm khác nhau, gây lỗi trong việc so sánh các đối tượng trong các cấu trúc dữ liệu như `HashSet` hay `HashMap`.

### **Ví dụ về `hashCode()` mặc định và khi ghi đè**:
```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Ghi đè hashCode để tính mã băm dựa trên thuộc tính của đối tượng
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);

        System.out.println(p1.hashCode());  // Mã băm của p1 (dựa trên name và age)
        System.out.println(p2.hashCode());  // Mã băm của p2 (dựa trên name và age)
        System.out.println(p1.equals(p2)); // true (cùng tên và tuổi)
    }
}
```
## 2. **`toString()` trong Java**

- **Mục đích**: Phương thức **`toString()`** trả về một **chuỗi mô tả** cho đối tượng. Phương thức này thường được sử dụng để in ra thông tin của đối tượng khi bạn gọi `System.out.println()`.
- **Mặc định của `toString()`**:
    - Nếu bạn **không ghi đè** phương thức **`toString()`**, phương thức mặc định từ lớp **`Object`** sẽ trả về một chuỗi có dạng: **`getClass().getName() + '@' + Integer.toHexString(hashCode())`**.
    - Điều này có nghĩa là chuỗi mặc định trả về sẽ chứa tên lớp và mã băm của đối tượng, thay vì thông tin chi tiết về các thuộc tính của đối tượng.

### **Khi nào cần ghi đè `toString()`?**
- Bạn nên **ghi đè `toString()`** để cung cấp một **mô tả chi tiết** về đối tượng, bao gồm các thuộc tính của đối tượng (như tên, tuổi, địa chỉ, v.v.).
- Điều này giúp bạn dễ dàng kiểm tra và in thông tin của đối tượng trong quá trình phát triển và debug.

### **Ví dụ về `toString()` mặc định và khi ghi đè**:
```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Ghi đè toString để in ra thông tin chi tiết về đối tượng
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        System.out.println(p1.toString());  // Output: Person{name='Alice', age=30}
    }
}
```
## 3. **Các phương thức quan trọng khác trong lớp `Object`**

Ngoài **`hashCode()`** và **`toString()`**, lớp **`Object`** còn có một số phương thức quan trọng khác mà mọi lớp trong Java đều kế thừa:

### **`equals()`**
- Phương thức **`equals()`** được sử dụng để so sánh hai đối tượng xem chúng có bằng nhau không. Mặc định, **`equals()`** so sánh tham chiếu bộ nhớ, tức là nó kiểm tra xem hai đối tượng có phải là cùng một đối tượng hay không.
- Nếu bạn muốn so sánh hai đối tượng theo giá trị của chúng (chẳng hạn như so sánh các thuộc tính), bạn nên **ghi đè `equals()`**.

### **`clone()`**
- Phương thức **`clone()`** được sử dụng để sao chép một đối tượng. Tuy nhiên, để sử dụng phương thức này, lớp phải triển khai giao diện **`Cloneable`**.
- Mặc định, phương thức **`clone()`** thực hiện sao chép theo kiểu nông (shallow copy), nghĩa là chỉ sao chép các tham chiếu, không sao chép các đối tượng con.

### **`finalize()`**
- Phương thức **`finalize()`** được gọi trước khi một đối tượng bị garbage collector xóa bỏ. Phương thức này có thể được ghi đè để làm sạch tài nguyên (như đóng file, giải phóng bộ nhớ, v.v.) trước khi đối tượng bị xóa.

### **`wait()`, `notify()`, `notifyAll()`**
- Các phương thức này được sử dụng trong **đồng bộ hóa đa luồng** (multithreading). Chúng không thể ghi đè nhưng có thể được sử dụng trong các tình huống như tạm dừng (wait) và thông báo (notify) các luồng khác.

## 4. **Tóm tắt về `hashCode()` và `toString()` trong lớp `Object`:**

| **Phương thức**    | **Mục đích**                                                                                               | **Mặc định**                                                                                 | **Khi nào ghi đè**                                                        |
|--------------------|------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| **`hashCode()`**    | Tạo một mã băm duy nhất cho đối tượng, dùng trong các cấu trúc dữ liệu như `HashMap`, `HashSet`.            | Trả về mã băm dựa trên địa chỉ bộ nhớ của đối tượng.                                          | Khi bạn sử dụng đối tượng trong các cấu trúc dữ liệu như `HashMap`, `HashSet` và muốn so sánh các đối tượng theo giá trị thuộc tính. |
| **`toString()`**    | Trả về chuỗi mô tả đối tượng.                                                                                 | Trả về thông tin lớp đối tượng và mã băm của đối tượng (địa chỉ bộ nhớ).                      | Khi bạn muốn in ra thông tin chi tiết của đối tượng, ví dụ trong debug.   |

## 5. **Kết luận:**
- **`hashCode()`** và **`toString()`** là hai phương thức rất quan trọng trong Java. **`hashCode()`** giúp sử dụng các đối tượng trong các cấu trúc dữ liệu như **`HashMap`** và **`HashSet`**, trong khi **`toString()`** giúp cung cấp một cách để mô tả đối tượng dưới dạng chuỗi.
- Cả hai phương thức đều có phương thức mặc định trong lớp `Object`, nhưng bạn nên **ghi đè** chúng khi cần một cách so sánh hoặc mô tả đối tượng chi tiết hơn.
