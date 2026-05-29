# Bước 1: Sử dụng base image là JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Bước 2: Tạo một thư mục làm việc bên trong container
WORKDIR /app

# Bước 3: Copy file jar đã build (từ thư mục target/ hoặc build/libs/) vào container
# Lưu ý: Bạn cần chạy lệnh `.\mvnw clean package -DskipTests` hoặc `./gradlew build` trước ở máy thật
COPY target/*.jar app.jar

# Bước 4: Ra lệnh cho container chạy file jar này khi khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]
