✅ 1. Garbage Collection là gì?
Garbage Collection (GC) là cơ chế tự động thu hồi bộ nhớ trong Java. JVM theo dõi các object nào không còn được tham chiếu và giải phóng vùng nhớ đó để tránh OutOfMemoryError.

✅ 2. Cách GC hoạt động (tóm tắt theo thế hệ)
Java chia bộ nhớ heap thành 2 vùng chính:

🔸 Young Generation (Vùng nhớ mới)
Gồm: Eden và Survivor (S0/S1)

Nơi object mới được tạo

GC ở đây gọi là Minor GC (nhanh, thường xuyên)

🔸 Old Generation (Tenured)
Object sống lâu từ Young sẽ được promotion lên đây

GC ở đây gọi là Major GC / Full GC (nặng, tốn thời gian)

✅ 3. Các loại Garbage Collector trong JVM
🔹 1. Serial GC (-XX:+UseSerialGC)
Dùng 1 luồng để GC

Tạm dừng toàn bộ ứng dụng (Stop The World)

Thích hợp cho máy đơn nhân, ứng dụng nhỏ

bash
Copy
Edit
-XX:+UseSerialGC
🔹 2. Parallel GC (Throughput GC) – mặc định trước Java 9
Dùng nhiều luồng để xử lý GC (song song)

Ưu tiên hiệu suất tổng thể

Ứng dụng không cần đáp ứng thời gian thực

bash
Copy
Edit
-XX:+UseParallelGC
🔹 3. CMS (Concurrent Mark-Sweep GC) (đã deprecated từ Java 9)
Là GC concurrent đầu tiên

Quét và dọn dẹp Old Generation mà giảm Stop-The-World

Không compact memory → dễ fragment

bash
Copy
Edit
-XX:+UseConcMarkSweepGC
🔹 4. G1 GC – Garbage First GC (mặc định từ Java 9+)
Chia heap thành nhiều region nhỏ

GC theo các region nhiều rác trước ("Garbage First")

Hỗ trợ concurrent GC → giảm thời gian dừng

Có thể điều chỉnh thời gian pause

bash
Copy
Edit
-XX:+UseG1GC
🔹 5. ZGC (Low-Latency GC) (Java 11+)
GC gần như không dừng (pause time < 10ms)

Dành cho ứng dụng real-time, Big Data

Hỗ trợ heap lên đến 16 TB

bash
Copy
Edit
-XX:+UseZGC
🔹 6. Shenandoah GC (Red Hat, Java 12+)
GC concurrent toàn bộ

Pause rất ngắn, phù hợp ứng dụng yêu cầu latency thấp

bash
Copy
Edit
-XX:+UseShenandoahGC
✅ 4. GC Tuning – Tối ưu JVM
🔹 Xác định mục tiêu:
Low latency → Dùng G1/ZGC/Shenandoah

High throughput → Dùng ParallelGC

🔹 Một số option quan trọng:
Option	Ý nghĩa
-Xms<size>	Set heap size bắt đầu
-Xmx<size>	Set heap size tối đa
-XX:NewRatio=n	Tỉ lệ giữa old/new generation
-XX:SurvivorRatio=n	Tỉ lệ Eden/Survivor
-XX:+PrintGCDetails	In thông tin chi tiết GC
-XX:+UseStringDeduplication	(G1GC) Giảm duplicate String
-XX:MaxGCPauseMillis=n	(G1GC) Mục tiêu thời gian dừng tối đa
-XX:+HeapDumpOnOutOfMemoryError	Dump heap khi OOM

✅ 5. Kiểm tra GC runtime
Dùng jstat:

bash
Copy
Edit
jstat -gc <pid> 1000
Dùng log GC:

bash
Copy
Edit
-XX:+PrintGC -XX:+PrintGCDetails -Xloggc:gc.log
Visual tools:

VisualVM

JMC (Java Mission Control)

Grafana + Prometheus JVM exporter

✅ Gợi ý cấu hình mẫu (cho G1GC):
bash
Copy
Edit
-XX:+UseG1GC
-XX:MaxGCPauseMillis=200
-XX:+UnlockExperimentalVMOptions
-XX:+UseStringDeduplication
-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
-Xms4g -Xmx4g