package com.salon2.salon2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon2.salon2.model.Booking;
import com.salon2.salon2.model.Layanan;
import com.salon2.salon2.model.Payment;
import com.salon2.salon2.model.Pelanggan;
import com.salon2.salon2.repository.BookingRepository;
import com.salon2.salon2.repository.LayananRepository;
import com.salon2.salon2.repository.PaymentRepository;
import com.salon2.salon2.repository.PelangganRepository;

@Controller
public class MainController {

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // --- AREA PUBLIK (PELANGGAN) ---

    @PostMapping("/pelanggan")
    public String tambahPelanggan(Pelanggan pelanggan) {
        pelangganRepository.save(pelanggan);
        return "redirect:/pelanggan";
    }

    @PostMapping("/booking")
    public String tambahBooking(
            @RequestParam Integer idPelanggan,
            @RequestParam String jenisHaircut,
            @RequestParam String tanggalBooking,
            @RequestParam String jamBooking,
            @RequestParam Integer jumlahBooking,
            @RequestParam String metodePayment
    ) {
        Pelanggan pelanggan = pelangganRepository.findById(idPelanggan).orElse(null);
        if (pelanggan == null) return "redirect:/pelanggan";

        Layanan layanan;
        if (layananRepository.findAll().isEmpty()) {
            layanan = new Layanan();
            layanan.setNamaLayanan("Haircut");
            layanan.setHarga(150000.0);
            layananRepository.save(layanan);
        } else {
            layanan = layananRepository.findAll().get(0);
        }

        // Simpan Booking 
        Booking booking = new Booking();
        booking.setPelanggan(pelanggan);
        booking.setLayanan(layanan);
        booking.setJenisHaircut(jenisHaircut);
        booking.setTanggalBooking(tanggalBooking);
        booking.setJamBooking(jamBooking);
        booking.setJumlahBooking(jumlahBooking);
        booking.setStatusBooking("BOOKED");
        bookingRepository.save(booking);

        // Otomatis Simpan Payment 
        Double totalBayar = layanan.getHarga() * jumlahBooking;
        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setMetodePayment(metodePayment);
        payment.setTanggalPayment(tanggalBooking);
        payment.setJumlahBayar(totalBayar);
        payment.setStatusPayment("PAID");
        paymentRepository.save(payment);

        return "redirect:/pelanggan";
    }

    // --- AREA KHUSUS ADMIN ---

    @PostMapping("/admin/layanan")
    public String tambahLayanan(Layanan layanan) {
        layananRepository.save(layanan);
        return "redirect:/dashboard-admin";
    }

    @GetMapping("/admin/booking/batal/{id}")
    public String batalkanBooking(@PathVariable Integer id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking != null) {
            booking.setStatusBooking("CANCELLED");
            bookingRepository.save(booking);
        }
        return "redirect:/dashboard-admin";
    }

    @GetMapping("/admin/booking/hapus/{id}")
    public String hapusBooking(@PathVariable Integer id) {
        bookingRepository.deleteById(id);
        return "redirect:/dashboard-admin";
    }

    @GetMapping("/admin/pelanggan/hapus/{id}")
    public String hapusPelanggan(@PathVariable Integer id) {
        pelangganRepository.deleteById(id);
        return "redirect:/dashboard-admin";
    }
}