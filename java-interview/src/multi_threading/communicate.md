Giao tiếp giữa các thread trong Java
Trong Java, các thread có thể giao tiếp với nhau bằng cách sử dụng các phương thức wait(), notify() và notifyAll(). Các phương thức này cho phép một thread chờ đợi cho một sự kiện từ thread khác hoặc thông báo cho thread khác khi công việc đã hoàn thành.

Cơ chế hoạt động của wait(), notify(), và notifyAll():
wait():

Khi một thread gọi phương thức wait() trên một đối tượng, thread đó sẽ nhường lại khóa của đối tượng đó và vào trạng thái chờ (waiting).

Thread sẽ chờ đợi cho đến khi một thread khác thông báo (notify) rằng công việc đã hoàn thành và nó có thể tiếp tục thực thi.

Trong khi thread đang chờ, các thread khác có thể lấy khóa và tiếp tục công việc của mình.

notify():

Khi một thread gọi phương thức notify() trên một đối tượng, nó thông báo cho một thread khác đang chờ trên cùng đối tượng đó rằng có thể tiếp tục thực thi.

Tuy nhiên, chỉ có một thread được thông báo và có thể tiếp tục thực thi, các thread còn lại sẽ vẫn tiếp tục chờ.

notifyAll():

Khi một thread gọi phương thức notifyAll(), tất cả các thread đang chờ trên đối tượng đó sẽ được thông báo và có thể tiếp tục thực thi.

Thường dùng trong trường hợp có nhiều thread đang chờ và bạn muốn tất cả chúng đều được thông báo.

Quy tắc sử dụng wait(), notify() và notifyAll():
Các phương thức wait(), notify(), và notifyAll() phải được gọi trong một khối synchronized (có khóa) để đảm bảo tính đồng bộ.

Nếu các phương thức này được gọi ngoài một khối synchronized, Java sẽ ném ra IllegalMonitorStateException vì các phương thức này cần quyền truy cập vào khóa của đối tượng (monitor lock) khi thao tác.
