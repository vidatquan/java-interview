## 🔍 So sánh `==` và `equals()` trong Java

### 🟨 1. Toán tử `==` (Double Equals)

* Dùng để **so sánh địa chỉ ô nhớ (reference)** chứ **không so sánh nội dung (giá trị)** của đối tượng.
* Thường được gọi là **so sánh nông (shallow comparison)**.

#### 📌 Ví dụ:

```java
User u1 = new User(1, "John");
User u2 = new User(1, "John");

System.out.println(u1 == u2); // ❌ false: vì khác vùng nhớ
```

---

### 🟨 2. Phương thức `equals()`

* Mặc định kế thừa từ lớp `Object` và cũng **so sánh theo reference**, giống `==`.
* Nếu không override, `equals()` sẽ cho kết quả giống `==`.

#### 📌 Ví dụ:

```java
System.out.println(u1.equals(u2)); // ❌ false nếu chưa override
```

#### ✅ Ví dụ override `equals()`:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User user = (User) obj;
    return id == user.id && name.equals(user.name);
}
```

---

### 🟢 3. Ngoại lệ: `String`, `Wrapper Class`, `Enum`

* Các lớp như `String`, `Integer`, `Double`, `Enum` đã **override sẵn `equals()` để so sánh giá trị** (deep comparison).

#### 📌 Ví dụ:

```java
String s1 = new String("abc");
String s2 = new String("abc");

System.out.println(s1 == s2);        // ❌ false (khác vùng nhớ)
System.out.println(s1.equals(s2));   // ✅ true (so sánh nội dung)
```

Tương tự với `Integer`, `Double`, `Character`, `Boolean`,...

---

## 📌 Tổng kết so sánh

| Mục                        | `==` (toán tử so sánh)                         | `equals()` (phương thức)                      |
| -------------------------- | ---------------------------------------------- | --------------------------------------------- |
| So sánh gì?                | So sánh địa chỉ (reference)                    | So sánh nội dung nếu đã override              |
| Mặc định hoạt động ra sao? | So sánh reference                              | So sánh reference (nếu chưa override)         |
| Cần override không?        | Không                                          | Có nếu muốn so sánh theo giá trị              |
| Dùng cho kiểu nào?         | Thường dùng với primitive & kiểm tra reference | Dùng cho object để so sánh nội dung           |
| Ví dụ đúng                 | `s1 == s2` với `int`, `char`, `boolean`        | `str1.equals(str2)` với String, Wrapper, Enum |
