package com.salon2.salon2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon2.salon2.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}