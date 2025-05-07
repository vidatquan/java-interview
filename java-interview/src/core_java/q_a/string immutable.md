## 🔒 Tính bất biến (Immutability) của `String` trong Java

### ✅ Định nghĩa

* `String` trong Java là một **class bất biến**: một khi bạn đã tạo ra một đối tượng `String`, bạn **không thể thay đổi nội dung của nó**.
* Mỗi khi bạn "thay đổi" chuỗi, **một đối tượng mới được tạo ra**, còn đối tượng cũ **không bị thay đổi**.

---

## 🌟 Ưu điểm của `String` bất biến

| Ưu điểm                        | Giải thích                                                             |
| ------------------------------ | ---------------------------------------------------------------------- |
| ✅ **Tiết kiệm bộ nhớ**         | Nhờ vào **String Pool**, các chuỗi giống nhau dùng chung một vùng nhớ. |
| ✅ **An toàn trong đa luồng**   | Không lo bị thay đổi dữ liệu khi truy cập đồng thời bởi nhiều thread.  |
| ✅ **Bảo mật hơn**              | Dữ liệu nhạy cảm (mật khẩu, token) không bị sửa ngẫu nhiên.            |
| ✅ **Dễ sử dụng trong HashMap** | Vì giá trị không thay đổi, `hashCode` cũng không thay đổi.             |
| ✅ **Đơn giản hơn khi debug**   | Vì không có thay đổi đột ngột, logic xử lý chuỗi dễ theo dõi hơn.      |

---

## ⚠️ Nhược điểm của `String` bất biến

| Nhược điểm                                          | Giải thích                                                                                         |
| --------------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| ❌ **Tốn hiệu năng khi thay đổi chuỗi nhiều lần**    | Mỗi lần thay đổi tạo ra một đối tượng mới → **tốn bộ nhớ và CPU**, nhất là trong vòng lặp.         |
| ❌ **Không phù hợp với chuỗi thay đổi thường xuyên** | Trong các bài toán xử lý văn bản lớn, nối chuỗi lặp lại → nên dùng `StringBuilder`/`StringBuffer`. |
| ❌ **Gây hiểu nhầm cho lập trình viên mới**          | Có thể nghĩ rằng gán lại chuỗi là thay đổi chuỗi ban đầu, nhưng thật ra là tạo mới đối tượng.      |

---

## 🔄 Giải pháp khi cần thay đổi chuỗi nhiều lần

| Tình huống                    | Giải pháp đề xuất                           |
| ----------------------------- | ------------------------------------------- |
| Thay đổi chuỗi nhiều lần      | Sử dụng `StringBuilder` (không thread-safe) |
| Thay đổi chuỗi trong đa luồng | Sử dụng `StringBuffer` (thread-safe)        |

---

## 📌 Kết luận

Tính bất biến của `String` là **thiết kế có chủ ý** trong Java nhằm phục vụ:

* **Tối ưu bộ nhớ**
* **An toàn trong đa luồng**
* **Bảo mật**

Tuy nhiên, với các bài toán thao tác chuỗi nặng, cần sử dụng `StringBuilder` hoặc `StringBuffer` để **tránh lãng phí tài nguyên**.
