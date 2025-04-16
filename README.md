# Microservices Platform

## Giới thiệu

Dự án này là một nền tảng microservices hiện đại được thiết kế để cung cấp một hệ thống phân tán, có khả năng mở rộng và linh hoạt. Kiến trúc này phân tách các dịch vụ thành các module độc lập, mỗi module có thể được phát triển, triển khai và mở rộng một cách riêng biệt.

## Kiến trúc tổng quan

Hệ thống được tổ chức theo mô hình microservices với các thành phần chính sau:

### API Gateway
Đóng vai trò là điểm vào duy nhất cho tất cả các yêu cầu từ client. API Gateway xử lý việc định tuyến yêu cầu đến các dịch vụ phù hợp và tích hợp Load Balancer để phân phối tải công việc hiệu quả.

### Các microservices cốt lõi
- **Statistic Service**: Thu thập và xử lý dữ liệu thống kê trong hệ thống.
- **Account Service**: Quản lý thông tin tài khoản người dùng và xác thực. Được trang bị Load Balancer và Circuit Breaker để đảm bảo tính khả dụng cao.
- **Notification Service**: Xử lý tất cả các thông báo gửi đến người dùng.

### Các dịch vụ hỗ trợ
- **Service Discovery (Eureka)**: Cho phép các dịch vụ đăng ký, khám phá và giao tiếp với nhau một cách động.
- **Config Service**: Quản lý cấu hình tập trung cho tất cả các dịch vụ.
- **Log Analysis (Sleuth)**: Cung cấp theo dõi phân tán và phân tích nhật ký.
- **Monitor Dashboard**: Hiển thị thông tin giám sát và trạng thái của hệ thống.

<img src="Microservices Diagram.png" alt="Kiến trúc Microservices" width="800"/>



