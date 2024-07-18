package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.TransactionHistory;
import com.example.demo.services.ITransactionHistoryService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionHistoryController {

    @Autowired
    private ITransactionHistoryService transactionHistoryService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTransactionHistory(@RequestBody TransactionHistory transactionHistory) {
        try {
            transactionHistory.setTime(LocalDateTime.now());
            transactionHistoryService.saveTransactionHistory(transactionHistory);
            return ResponseEntity.ok("Transaction saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error occurred while saving transaction");
        }
    }
}