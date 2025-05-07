Generics là một tính năng được giới thiệu từ phiên bản Java 1.5, cho phép lập trình viên định nghĩa các lớp, phương thức hoặc giao diện với các loại dữ liệu tổng quát. Điều này giúp tăng tính tái sử dụng mã nguồn và giảm thiểu lỗi khi sử dụng kiểu dữ liệu không phù hợp.

Trước khi có Generics, khi làm việc với các collection (như List, Set, v.v.), bạn không thể chỉ định rõ kiểu dữ liệu mà collection chứa, dẫn đến việc có thể thêm các đối tượng không phù hợp vào trong collection. Ví dụ, nếu bạn có một List mà không sử dụng Generics, bạn có thể vô tình thêm một chuỗi vào một danh sách chỉ chứa các số nguyên, mà không gặp lỗi trong quá trình biên dịch.

Với Generics, bạn có thể chỉ định rõ kiểu dữ liệu mà collection sẽ chứa, như sau:

java
Copy
List<Integer> employeeIds = new ArrayList<>();
employeeIds.add(1); // Hợp lệ
employeeIds.add("John"); // Lỗi biên dịch
Nhờ vậy, việc kiểm tra kiểu dữ liệu sẽ được thực hiện ngay trong thời gian biên dịch, giúp tránh được các lỗi thời gian chạy.

Type Erasure trong Java:

Type Erasure là quá trình mà trình biên dịch Java sẽ loại bỏ thông tin về kiểu dữ liệu Generics khi biên dịch mã nguồn thành bytecode. Quá trình này xảy ra vì lý do tương thích với các phiên bản Java cũ hơn (trước Java 1.5). Do đó, các mã nguồn cũ viết trên các phiên bản Java trước không cần phải sửa đổi để chạy trên JVM mới.

Ví dụ, khi biên dịch mã nguồn có sử dụng Generics, trình biên dịch sẽ xóa bỏ thông tin về kiểu dữ liệu, và thay vào đó sử dụng kiểu đối tượng (Object) cho các tham số Generics. Điều này có nghĩa là trong thời gian chạy, không có thông tin nào về kiểu dữ liệu cụ thể của các tham số Generics, mặc dù nó được sử dụng ở thời gian biên dịch.

Vì thế, Java không có "runtime Generics", mà chỉ có Generics tại thời gian biên dịch. Đây là lý do khiến mã Java cũ có thể chạy trên các JVM mới mà không gặp vấn đề tương thích.