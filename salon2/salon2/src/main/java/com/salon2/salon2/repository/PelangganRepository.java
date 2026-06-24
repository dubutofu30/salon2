package com.salon2.salon2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon2.salon2.model.Pelanggan;

public interface PelangganRepository extends JpaRepository<Pelanggan, Integer> {
}