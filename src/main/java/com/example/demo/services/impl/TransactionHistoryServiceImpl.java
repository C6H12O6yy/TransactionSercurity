package com.example.demo.services.impl;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.TransactionHistory;
import com.example.demo.repository.ITransactionHistoryRepository;
import com.example.demo.security.AESUtil;
import com.example.demo.services.ITransactionHistoryService;

@Service
public class TransactionHistoryServiceImpl implements ITransactionHistoryService {

	@Autowired
    private ITransactionHistoryRepository repository;

    private final SecretKey aesKey;

    public TransactionHistoryServiceImpl() throws Exception {
        this.aesKey = AESUtil.generateKey();
    }

    @Override
    public void saveTransactionHistory(TransactionHistory transactionHistory) throws Exception {
        String encryptedAccount = AESUtil.encrypt(transactionHistory.getAccount(), aesKey);
        transactionHistory.setAccount(encryptedAccount);
        repository.save(transactionHistory);
    }
}