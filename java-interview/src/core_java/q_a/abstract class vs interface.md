# Sự khác biệt giữa Abstract Class và Interface trong Java

## 1. **Lớp Trừu Tượng (Abstract Class):**
- **Phương thức trừu tượng:** Lớp trừu tượng có thể có một hoặc nhiều phương thức trừu tượng (abstract methods). Các phương thức này không có phần thân (body) và cần phải được thực hiện (override) trong các lớp con.
- **Phương thức có cài đặt:** Ngoài các phương thức trừu tượng, lớp trừu tượng có thể có các phương thức có cài đặt (implemented methods).
- **Kế thừa:** Một lớp chỉ có thể kế thừa (extend) một lớp trừu tượng duy nhất (Java không hỗ trợ kế thừa nhiều lớp trừu tượng).
- **Khởi tạo đối tượng:** Không thể tạo đối tượng từ lớp trừu tượng, nhưng có thể tạo đối tượng từ các lớp con kế thừa và cài đặt các phương thức trừu tượng.

## 2. **Giao Diện (Interface):**
- **Tất cả phương thức đều là trừu tượng:** Các phương thức trong giao diện luôn là phương thức trừu tượng (trừ khi giao diện sử dụng Java 8 trở lên với các phương thức mặc định `default`).
- **Không có cài đặt:** Giao diện không chứa cài đặt phương thức, mà chỉ chứa các khai báo phương thức. Các lớp triển khai giao diện cần cung cấp phần thân (body) cho tất cả các phương thức.
- **Kế thừa:** Một lớp có thể triển khai (implement) nhiều giao diện cùng lúc (đa kế thừa).
- **Không thể khởi tạo đối tượng từ giao diện.** Tuy nhiên, có thể khởi tạo đối tượng từ lớp con triển khai giao diện đó.

```java
// Giao diện với phương thức mặc định
interface Animal {
    // Phương thức trừu tượng
    void sound();
    
    // Phương thức mặc định (có cài đặt)
    default void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

// Lớp triển khai giao diện Animal
class Dog implements Animal {
    // Cài đặt phương thức sound
    public void sound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();   // Output: Bark
        dog.sleep();   // Output: Animal is sleeping...
    }
}

```

## 3. **Sự Khác Biệt Chính:**
- **Abstract class** có thể chứa phương thức đã cài đặt, trong khi **interface** không có (trừ khi dùng phương thức mặc định `default` từ Java 8 trở đi).
- **Abstract class** chỉ có thể kế thừa một lớp duy nhất, trong khi **interface** có thể được triển khai bởi nhiều lớp.
- Nếu một lớp có ít nhất một phương thức trừu tượng, thì lớp đó phải được khai báo là **abstract class**; ngược lại, nếu không có phương thức trừu tượng, lớp đó có thể là lớp bình thường.

## Tóm Tắt:
- **Abstract class**: Có thể có phương thức cài đặt, chỉ có thể kế thừa một lớp duy nhất.
- **Interface**: Chứa toàn bộ phương thức trừu tượng, có thể triển khai nhiều giao diện, không có cài đặt phương thức trừu tượng.
