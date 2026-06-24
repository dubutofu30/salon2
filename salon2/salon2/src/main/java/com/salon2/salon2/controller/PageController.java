package com.salon2.salon2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salon2.salon2.repository.AdminRepository;
import com.salon2.salon2.repository.BookingRepository;
import com.salon2.salon2.repository.LayananRepository;
import com.salon2.salon2.repository.PaymentRepository;
import com.salon2.salon2.repository.PelangganRepository;

@Controller
public class PageController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private LayananRepository layananRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // Menangani halaman utama dan daftar pelanggan 
    @GetMapping({"/", "/pelanggan"})
    public String pelangganPage(Model model) {
        model.addAttribute("pelangganList", pelangganRepository.findAll());
        model.addAttribute("bookingList", bookingRepository.findAll());
        return "pelanggan";
    }

    @GetMapping("/login-admin")
    public String loginAdminPage() {
        return "login-admin";
    }

    @PostMapping("/login-admin")
    public String prosesLoginAdmin(
            @RequestParam String username,
            @RequestParam String password
    ) {
        if (!username.isBlank() && password.equals("admin123")) {
            return "redirect:/dashboard-admin";
        }
        return "redirect:/login-admin";
    }

    // Menampilkan semua data untuk Admin 
    @GetMapping("/dashboard-admin")
    public String dashboardAdmin(Model model) {
        model.addAttribute("adminList", adminRepository.findAll());
        model.addAttribute("pelangganList", pelangganRepository.findAll());
        model.addAttribute("bookingList", bookingRepository.findAll());
        model.addAttribute("layananList", layananRepository.findAll());
        model.addAttribute("paymentList", paymentRepository.findAll());
        return "dashboard-admin";
    }
}