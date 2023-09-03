package com.example.backendb.controller;

import com.example.backendb.entity.Installment;
import com.example.backendb.service.InstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/installments")
public class InstallmentController {

    @Autowired
    private InstallmentService installmentService;

    @GetMapping("/getInstall/{id}")
    public ResponseEntity<Installment> getInstallmentById(@PathVariable Long id) {
        Installment installment = installmentService.getInstallmentById(id);
        return ResponseEntity.ok(installment);
    }

    @PostMapping("/addInstall")
    public ResponseEntity<Installment> createInstallment(@RequestBody Installment installment) {
        Installment newInstallment = installmentService.createInstallment(installment);
        return ResponseEntity.status(HttpStatus.CREATED).body(newInstallment);
    }

    @PutMapping("/updateInstall/{id}")
    public ResponseEntity<Installment> updateInstallment(@PathVariable Long id, @RequestBody Installment installment) {
        Installment updatedInstallment = installmentService.updateInstallment(id, installment);
        return ResponseEntity.ok(updatedInstallment);
    }

    @DeleteMapping("/deleteInstall/{id}")
    public ResponseEntity<Void> deleteInstallment(@PathVariable Long id) {
        installmentService.deleteInstallment(id);
        return ResponseEntity.noContent().build();
    }
}

