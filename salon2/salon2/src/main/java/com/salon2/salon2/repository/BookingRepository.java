package com.salon2.salon2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon2.salon2.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}