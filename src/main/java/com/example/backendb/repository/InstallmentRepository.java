package com.example.backendb.repository;

import com.example.backendb.entity.Installment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}
