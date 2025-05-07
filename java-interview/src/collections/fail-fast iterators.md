1. Fail-Fast Iterators
   Đặc điểm:

Các iterators của các lớp collections truyền thống như ArrayList, HashSet, v.v. sử dụng fail-fast iterators.

Khi bạn tạo một iterator từ một collection truyền thống và bắt đầu duyệt qua các phần tử trong khi có một thay đổi (thêm, xóa) xảy ra trên collection trong cùng một thời điểm, ConcurrentModificationException sẽ được ném ra.

Điều này xảy ra ngay khi bạn thực hiện các thay đổi đồng thời trên collection trong khi đang duyệt qua nó, bất kể đó là môi trường đa luồng hay đơn luồng.

Lý do:

Các fail-fast iterators không cho phép modification đồng thời trên collection khi bạn đang sử dụng iterator để duyệt qua các phần tử, nhằm tránh những kết quả không mong muốn và lỗi không xác định.

Ví dụ:

java
Copy
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);

Iterator<Integer> iterator = list.iterator();
list.add(4);  // Thay đổi collection trong khi đang duyệt qua nó

iterator.next();  // ConcurrentModificationException sẽ được ném ra
2. Fail-Safe Iterators
   Đặc điểm:

Các collection đồng thời như CopyOnWriteArrayList và CopyOnWriteArraySet sử dụng fail-safe iterators.

Những iterator này cho phép thay đổi đồng thời trên collection mà không ném ra bất kỳ ngoại lệ nào. Dù có các thay đổi (thêm, xóa) trong khi đang duyệt qua các phần tử của collection, iterator vẫn có thể tiếp tục làm việc mà không gặp phải ngoại lệ.

Điều này có thể xảy ra trong cả môi trường đơn luồng và đa luồng, giúp chúng an toàn khi sử dụng trong các ứng dụng đa luồng.

Lý do:

Các fail-safe iterators hoạt động bằng cách sao chép dữ liệu của collection vào một bản sao (snapshot) để duyệt qua. Điều này có nghĩa là dù collection có thay đổi trong quá trình duyệt, bạn sẽ chỉ duyệt qua bản sao của collection tại thời điểm bắt đầu vòng lặp.

Ví dụ:

java
Copy
List<Integer> list = new CopyOnWriteArrayList<>();
list.add(1);
list.add(2);
list.add(3);

Iterator<Integer> iterator = list.iterator();
list.add(4);  // Thay đổi collection trong khi đang duyệt qua nó

iterator.next();  // Không có ngoại lệ, iterator sẽ vẫn duyệt qua các phần tử hiện tại
Tóm lại:
Fail-Fast Iterators:

Dùng trong các collection truyền thống (ví dụ: ArrayList, HashSet).

Ném ra ConcurrentModificationException khi collection bị thay đổi trong khi đang duyệt qua nó.

Không cho phép thay đổi đồng thời trong khi duyệt.

Fail-Safe Iterators:

Dùng trong các collection đồng thời (ví dụ: CopyOnWriteArrayList).

Cho phép thay đổi đồng thời mà không gặp ngoại lệ.

Duyệt qua một bản sao của collection nên không bị ảnh hưởng bởi các thay đổi trong quá trình duyệt.

Các fail-safe iterators có thể rất hữu ích trong môi trường đa luồng, nhưng lại có chi phí hiệu suất do phải sao chép dữ liệu mỗi khi có sự thay đổi.