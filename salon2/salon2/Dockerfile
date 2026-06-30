# Gunakan base image Maven untuk build jar
FROM maven:3-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Gunakan base image JDK untuk menjalankan aplikasinya
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]