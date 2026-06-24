package com.salon2.salon2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon2.salon2.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}