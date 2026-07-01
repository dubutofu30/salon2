💇‍♀️ Salon2 — Sistem Booking Salon Online

Aplikasi web sederhana untuk manajemen booking salon (Resana Salon), dibangun dengan Spring Boot dan Thymeleaf. Aplikasi ini memiliki dua area utama: halaman publik untuk pelanggan melakukan booking layanan, dan dashboard khusus admin untuk mengelola pelanggan, booking, layanan, dan pembayaran.

🔗 Live Demo

👉 https://salon2-production.up.railway.app/pelanggan

Deploy otomatis via Railway menggunakan Docker.

---

✨ Fitur

Area Pelanggan (Publik)


Registrasi pelanggan — pelanggan baru bisa mendaftarkan nama dan nomor HP.
Booking layanan — memilih pelanggan, jenis haircut, tanggal & jam booking, jumlah orang, dan metode pembayaran.
Pembayaran otomatis — saat booking dibuat, sistem otomatis menghitung total biaya (harga layanan × jumlah booking) dan mencatatnya sebagai pembayaran berstatus PAID.
Daftar booking real-time — pelanggan dapat melihat daftar booking yang sudah masuk pada halaman yang sama.


Area Admin


Login admin — autentikasi sederhana berbasis username & password.
Dashboard admin — menampilkan seluruh data: daftar admin, pelanggan, booking, layanan, dan pembayaran dalam satu halaman.
Manajemen layanan — admin dapat menambahkan layanan baru beserta harganya.
Manajemen booking — admin dapat membatalkan booking (CANCELLED) atau menghapusnya secara permanen.
Manajemen pelanggan — admin dapat menghapus data pelanggan.
Data seeding otomatis — saat aplikasi pertama kali dijalankan, sistem otomatis membuat 3 akun admin default dan 1 layanan awal (Haircut) jika data belum ada

---

🛠️ Tech Stack 

1. Bahasa - Java 17
2. Framework - Spring Boot 3.3.5
3. Web Layer - Spring Web (MVC)
4. Template Engine - hymeleaf
5. ORM / Persistence - Spring Data JPA (Hibernate)
6. Database - PostgreSQL (hosting via Supabase)
7. Build Tool - Maven (Maven Wrapper)
8. Containerization - Docker (multi-stage build)
9. Deployment - Railway
10. Dev Tools - Spring Boot DevTools

---

Initialization

1. Clone Repository
```bash
git clone https://github.com/<username>/<nama-repo>.git
cd salon2
```
2.  environment variables dan referensikan di application.properti
```bash
   spring.datasource.url=jdbc:postgresql://aws-1-ap-southeast-1.pooler.supabase.com:5432/postgres?sslmode=require
   spring.datasource.username=${DB_USERNAME}
   spring.datasource.password=${DB_PASSWORD}
``` 
4. Make sure PostgreSQL is running and the database is created
5. Run the application using Maven Wrapper
```bash
   # Linux / macOS
     ./mvnw spring-boot:run
   # Windows
     mvnw.cmd spring-boot:run
```
6. Run the application using Docker
   docker build -t salon2 .
   docker run -p 8081:8081 salon2
7. Access the aplication at http://localhost:8081
