- Dockerfile: Định nghĩa các bước cần thực hiện để tạo server (bao gồm: khởi tạo 1 base container)
- Image: dockerfile tạo ra image, image là 1 snapshot về ứng dụng và môi trường các thông tin liên quan đến application 
- Container: container được tạo ra từ image, đóng gói tất cả các thành phần cần thiết để xây dựng application
- Docker compose: liệt kê các lệnh cần chạy để build image từ dockerfile, run container. Tất cả đều được định nghĩa trong docker file.

Nếu không có docker-compose, thực hiện bằng tay:
- docker build -t my-spring-app . (Tạo Image cho Spring từ Dockerfile)
- docker run --name postgres_container --network spring-postgres-net -d postgres:15-alpine (Tạo và chạy Container DB)
- docker run --name spring_app_container --network spring-postgres-net --link postgres_container -p 8080:8080 -d my-spring-app (Tạo và chạy Container App, tìm cách nối mạng sang Container DB)
