package com.example.backendb.service;

import com.example.backendb.entity.Installment;
import com.example.backendb.exception.ResourceNotFoundException;
import com.example.backendb.repository.InstallmentRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class InstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;

    public Installment getInstallmentById(Long id) {
        return installmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Installment not found with id " + id));
    }

    public Installment createInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }

    public Installment updateInstallment(Long id, Installment installment) {
        Installment existingInstallment = getInstallmentById(id);
        existingInstallment.setCustomerId(installment.getCustomerId());
        existingInstallment.setLoanBalance(installment.getLoanBalance());
        existingInstallment.setUsedAmount(installment.getUsedAmount());
        existingInstallment.setInstallmentPlan(installment.getInstallmentPlan());
        return installmentRepository.save(existingInstallment);
    }

    public void deleteInstallment(Long id) {
        Installment existingInstallment = getInstallmentById(id);
        installmentRepository.delete(existingInstallment);
    }
}

