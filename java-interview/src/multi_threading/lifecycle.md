Tóm lại về chu trình trạng thái của một thread:
New: Thread được tạo ra nhưng chưa được khởi động.

Runnable: Thread đã được gọi start() và sẵn sàng để chạy, nhưng chưa được chọn bởi thread scheduler.

Running: Thread đã được thread scheduler chọn và thực thi phương thức run().

Waiting/Blocked: Thread không thể tiếp tục thực thi ngay lập tức (chờ tài nguyên hoặc sự kiện).

Dead/Terminated: Thread đã hoàn thành việc thực thi và không thể khởi động lại.