package com.salon2.salon2.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.salon2.salon2.model.Admin;
import com.salon2.salon2.model.Layanan;
import com.salon2.salon2.repository.AdminRepository;
import com.salon2.salon2.repository.LayananRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final LayananRepository layananRepository;

    public DataSeeder(
            AdminRepository adminRepository,
            LayananRepository layananRepository
    ) {
        this.adminRepository = adminRepository;
        this.layananRepository = layananRepository;
    }

    @Override
    public void run(String... args) {

        if (adminRepository.count() == 0) {

            Admin admin1 = new Admin();
            admin1.setNamaAdmin("Reva");
            admin1.setUsername("reva");
            admin1.setPassword("admin123");

            adminRepository.save(admin1);

            Admin admin2 = new Admin();
            admin2.setNamaAdmin("Nasya");
            admin2.setUsername("nasya");
            admin2.setPassword("admin123");

            adminRepository.save(admin2);

            Admin admin3 = new Admin();
            admin3.setNamaAdmin("Lisa");
            admin3.setUsername("lisa");
            admin3.setPassword("admin123");

            adminRepository.save(admin3);
        }

        if (layananRepository.count() == 0) {

            Layanan layanan = new Layanan();

            layanan.setNamaLayanan("Haircut");

            layanan.setHarga(150000.0);

            layananRepository.save(layanan);
        }
    }
}