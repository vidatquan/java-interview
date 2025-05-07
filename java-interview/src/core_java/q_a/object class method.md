# Các phương thức kế thừa từ lớp `Object` trong Java

Mỗi lớp trong Java, dù là lớp người dùng tự định nghĩa hay các lớp có sẵn trong thư viện, đều kế thừa một số phương thức từ lớp **`Object`**. Đây là lớp gốc của tất cả các lớp trong Java, vì vậy mọi lớp đều có những phương thức này.

## 1. **Các phương thức có thể ghi đè (Override):**
- **`equals(Object obj)`**: Phương thức này được sử dụng để so sánh xem hai đối tượng có bằng nhau không. Lớp `Object` cung cấp phương thức mặc định là so sánh tham chiếu (so sánh xem chúng có phải là cùng một đối tượng trong bộ nhớ hay không).
- **`hashCode()`**: Phương thức này trả về một mã băm (hash code) cho đối tượng. Nếu bạn ghi đè phương thức `equals()`, bạn cũng nên ghi đè `hashCode()` để đảm bảo tính nhất quán.
- **`clone()`**: Phương thức này được sử dụng để sao chép một đối tượng. Lớp `Object` cung cấp một phương thức sao chép theo kiểu nông (shallow copy). Để sử dụng phương thức này, lớp phải triển khai `Cloneable`.
- **`toString()`**: Phương thức này trả về một chuỗi mô tả đối tượng. Bạn có thể ghi đè nó để cung cấp mô tả cụ thể hơn cho đối tượng của bạn.

## 2. **Các phương thức không thể ghi đè nhưng có thể sử dụng trong đa luồng (Multithreading):**
- **`wait()`**: Phương thức này được sử dụng để khiến luồng hiện tại tạm dừng và chờ cho đến khi nó được thông báo (notify) hoặc thông báo hết thời gian chờ.
- **`notify()`**: Được sử dụng để thông báo một luồng đang chờ trong một đối tượng đã khóa có thể tiếp tục thực thi.
- **`notifyAll()`**: Thông báo tất cả các luồng đang chờ trong đối tượng đã khóa có thể tiếp tục.

## 3. **Tóm tắt:**
- Mỗi lớp trong Java đều kế thừa các phương thức từ lớp **`Object`**, bao gồm: `equals()`, `hashCode()`, `finalize()`, `clone()`, `toString()`, và các phương thức liên quan đến đa luồng như `wait()`, `notify()`, `notifyAll()`.
- Các phương thức **`equals()`, `hashCode()`, `clone()`, `toString()`** có thể được **ghi đè** để thay đổi hành vi mặc định của chúng.
- Các phương thức **`wait()`, `notify()`, `notifyAll()`** không thể được ghi đè, nhưng có thể được sử dụng trong các tình huống đa luồng để điều khiển việc đồng bộ hóa.
