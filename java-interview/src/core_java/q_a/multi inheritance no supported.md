# Lý do Java không hỗ trợ kế thừa đa lớp (Multiple Inheritance)

## 1. **Lý do Java không hỗ trợ kế thừa đa lớp (Multiple Inheritance):**

Java không hỗ trợ **kế thừa đa lớp** (multiple inheritance) trực tiếp giữa các lớp, vì điều này có thể gây ra một số vấn đề nghiêm trọng, đặc biệt là khi các lớp cha có phương thức trùng lặp.

### **Vấn đề xảy ra khi kế thừa đa lớp:**
- Khi một lớp con kế thừa từ hai lớp cha và cả hai lớp cha có phương thức với cùng tên (ví dụ như phương thức `money`), thì khi gọi phương thức đó từ đối tượng của lớp con, trình biên dịch sẽ không biết phải gọi phương thức nào.
- Ví dụ, trong trường hợp lớp con **RichConfusedKid** kế thừa từ cả **Father** và **Mother**, nếu cả hai lớp cha đều có phương thức `money`, trình biên dịch sẽ không biết nên gọi phương thức `money` của lớp nào.

### **Vấn đề "Diamond Problem" (Vấn đề kim cương):**
- Một vấn đề nghiêm trọng khác mà kế thừa đa lớp có thể gây ra là **vấn đề kim cương**. Nếu có một lớp **GrandParent** có phương thức `money`, và **Father** và **Mother** kế thừa từ **GrandParent** và có phương thức `money`, thì khi lớp **RichConfusedKid** kế thừa từ cả **Father** và **Mother**, trình biên dịch sẽ không thể xác định phương thức `money` nào từ **GrandParent**, **Father**, hoặc **Mother** nên được gọi.
- Điều này làm cho việc xác định phương thức chính xác trở nên rất khó khăn và có thể dẫn đến lỗi biên dịch.

## 2. **Java và Đa Kế Thừa:**
- Java không hỗ trợ kế thừa đa lớp giữa các lớp (classes). Điều này có thể gây ra mâu thuẫn và khó khăn khi quyết định phương thức nào cần được gọi.
- Tuy nhiên, Java hỗ trợ **đa kế thừa giao diện (interface)**, cho phép một lớp triển khai nhiều giao diện mà không gặp phải các vấn đề như trong kế thừa đa lớp. Khi lớp triển khai nhiều giao diện, nếu các giao diện có phương thức trùng tên, lớp đó phải ghi đè phương thức để làm rõ hành vi.

## 3. **Giải pháp của Java:**
- **Sử dụng giao diện (Interfaces):** Java khuyến khích sử dụng giao diện để đạt được hành vi của đa kế thừa mà không gặp phải các vấn đề phức tạp như trong kế thừa đa lớp. Giao diện trong Java có thể chứa phương thức trừu tượng mà không có cài đặt, và lớp có thể triển khai nhiều giao diện mà không gặp phải vấn đề xung đột phương thức.
- **Từ Java 8**, giao diện có thể có phương thức mặc định (`default`), giúp cung cấp cài đặt mặc định cho các phương thức trong giao diện mà các lớp triển khai không cần phải cài đặt lại.

## 4. **Tóm tắt:**
- **Java không hỗ trợ kế thừa đa lớp** vì có thể gây ra các vấn đề như xung đột phương thức và **vấn đề kim cương**.
- Java khuyến khích sử dụng **giao diện (interface)** để giải quyết các vấn đề của kế thừa đa lớp và hỗ trợ **đa kế thừa giao diện**.
- **Vấn đề kim cương** xảy ra khi một lớp kế thừa từ nhiều lớp có các phương thức giống nhau, làm cho việc xác định phương thức nào cần gọi trở nên phức tạp.
