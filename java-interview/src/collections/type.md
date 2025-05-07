# Collections API trong Java

Collections API của Java cung cấp nhiều giao diện và lớp để xử lý các tập hợp dữ liệu. Dưới đây là các giao diện và lớp chính trong Collections API.

## 1. List
- **Đặc điểm**: Cho phép phần tử trùng lặp.
- **Lớp triển khai**:
    - `ArrayList`: Dữ liệu được lưu trữ trong mảng, hỗ trợ truy xuất ngẫu nhiên với độ phức tạp O(1).
    - `LinkedList`: Dữ liệu được lưu trữ dưới dạng danh sách liên kết, hỗ trợ thêm và xóa phần tử với độ phức tạp O(1).

## 2. Set
- **Đặc điểm**: Không cho phép phần tử trùng lặp.
- **Lớp triển khai**:
    - `HashSet`: Lưu trữ phần tử không có thứ tự, sử dụng bảng băm.
    - `LinkedHashSet`: Lưu trữ theo thứ tự chèn vào, sử dụng bảng băm và danh sách liên kết.
    - `TreeSet`: Lưu trữ và sắp xếp phần tử theo thứ tự (mặc định tăng dần).

## 3. Queue
- **Đặc điểm**: Lưu trữ dữ liệu theo kiểu FIFO (First In First Out).
- **Lớp triển khai**:
    - `PriorityQueue`: Lưu trữ phần tử theo thứ tự ưu tiên (priority), không phải theo FIFO.

## 4. BlockingQueue
- **Đặc điểm**: Mở rộng từ `Queue`, giúp triển khai mô hình Producer-Consumer.
- **Lớp triển khai**:
    - `ArrayBlockingQueue`
    - `LinkedBlockingQueue`

## 5. Map
- **Đặc điểm**: Lưu trữ dữ liệu dưới dạng cặp khóa-giá trị (key-value).
- **Lớp triển khai**:
    - `HashMap`: Lưu trữ không theo thứ tự.
    - `LinkedHashMap`: Lưu trữ theo thứ tự chèn vào.
    - `TreeMap`: Lưu trữ theo thứ tự đã sắp xếp.

# Sự khác biệt giữa ArrayList và LinkedList

## 1. Cấu trúc dữ liệu bên trong
- **ArrayList**: Sử dụng mảng (array) làm cấu trúc dữ liệu nội bộ.
- **LinkedList**: Sử dụng danh sách liên kết (linked list) với các nút (nodes) có con trỏ trước và sau, giống như danh sách liên kết đôi (doubly linked list).

## 2. Thêm phần tử vào danh sách
- **ArrayList**: Khi thêm phần tử vào bất kỳ vị trí nào trong danh sách (ngoài cuối danh sách), sẽ phải dịch chuyển các phần tử khác để tạo không gian cho phần tử mới. Điều này dẫn đến độ phức tạp thời gian là O(n).
- **LinkedList**: Việc thêm phần tử vào bất kỳ vị trí nào trong danh sách chỉ cần tạo một nút mới và điều chỉnh các con trỏ trước và sau. Điều này thực hiện nhanh hơn và có độ phức tạp thời gian O(1) khi thêm vào đầu hoặc cuối danh sách.

## 3. Truy cập phần tử ngẫu nhiên
- **ArrayList**: Vì được lưu trữ trong một mảng, `ArrayList` cho phép truy cập ngẫu nhiên các phần tử qua chỉ số (index) với độ phức tạp thời gian O(1). Đây là một điểm mạnh của `ArrayList`.
- **LinkedList**: Để truy cập một phần tử tại vị trí cụ thể, ta phải duyệt qua các nút từ đầu hoặc cuối danh sách cho đến vị trí cần truy cập, dẫn đến độ phức tạp thời gian là O(n).

## 4. Tốc độ đọc và ghi
- **ArrayList**: Được tối ưu hóa cho các ứng dụng có tần suất đọc cao vì có thể truy cập trực tiếp các phần tử thông qua chỉ số với thời gian rất nhanh (O(1)). Tuy nhiên, khi thực hiện các phép ghi (insert/remove) vào các vị trí ngẫu nhiên, độ phức tạp thời gian sẽ cao.
- **LinkedList**: Thích hợp hơn trong các tình huống có tần suất ghi (thêm, xóa) cao, nhưng sẽ chậm khi cần phải truy cập ngẫu nhiên các phần tử vì phải duyệt qua các nút trong danh sách.

## 5. Khi nào nên sử dụng
- **ArrayList**: Thích hợp khi ứng dụng có nhiều phép đọc và ít phép ghi. Ví dụ như khi bạn cần truy cập các phần tử theo chỉ số một cách nhanh chóng.
- **LinkedList**: Phù hợp hơn khi bạn có nhiều thao tác thêm, xóa phần tử tại các vị trí bất kỳ trong danh sách và không yêu cầu truy cập ngẫu nhiên các phần tử quá thường xuyên.

## Tóm lại
- **ArrayList** là lựa chọn tốt cho các ứng dụng đọc nhiều hơn ghi, với khả năng truy cập nhanh vào các phần tử qua chỉ số.
- **LinkedList** là lựa chọn tốt cho các ứng dụng có nhiều thao tác thêm, xóa phần tử, nhưng có chi phí cao khi truy cập các phần tử ngẫu nhiên.



# So sánh HashMap, LinkedHashMap, và TreeMap

## 1. HashMap
- **Đặc điểm**: Lưu trữ dữ liệu theo bảng băm. Không đảm bảo thứ tự của phần tử.
- **Ưu điểm**: Tìm kiếm, thêm, xóa phần tử với độ phức tạp O(1) trung bình.
- **Nhược điểm**: Không đảm bảo thứ tự khi duyệt qua các phần tử.

## 2. LinkedHashMap
- **Đặc điểm**: Giống `HashMap`, nhưng duy trì thứ tự chèn vào của các phần tử.
- **Ưu điểm**: Duy trì thứ tự phần tử chèn vào, thuận tiện khi cần duyệt theo thứ tự.
- **Nhược điểm**: Tốc độ có thể chậm hơn một chút so với `HashMap` do phải duy trì thứ tự.

## 3. TreeMap
- **Đặc điểm**: Lưu trữ dữ liệu theo thứ tự đã sắp xếp (theo mặc định tăng dần).
- **Ưu điểm**: Duy trì thứ tự sắp xếp của các phần tử, hỗ trợ tìm kiếm theo phạm vi.
- **Nhược điểm**: Các thao tác thêm, xóa phần tử có độ phức tạp O(log n) do sử dụng cây tìm kiếm nhị phân.

# So sánh Queue và BlockingQueue

## 1. Queue
- **Đặc điểm**: Lưu trữ dữ liệu theo kiểu FIFO (First In First Out).
- **Lớp triển khai**:
    - `PriorityQueue`: Lưu trữ các phần tử theo thứ tự ưu tiên.
    - `LinkedList`: Có thể dùng làm `Queue` (FIFO).
- **Ưu điểm**: Đơn giản, dễ sử dụng.
- **Nhược điểm**: Không hỗ trợ các thao tác đồng bộ (thread-safe).

## 2. BlockingQueue
- **Đặc điểm**: Mở rộng từ `Queue`, hỗ trợ các thao tác đồng bộ, phù hợp cho mô hình Producer-Consumer.
- **Lớp triển khai**:
    - `ArrayBlockingQueue`
    - `LinkedBlockingQueue`
- **Ưu điểm**: Các thao tác như thêm vào và lấy ra sẽ tự động bị chặn (blocked) nếu không thể thực hiện ngay lập tức.
- **Nhược điểm**: Cần phải xử lý các tình huống khi hàng đợi đầy hoặc trống.



