package com.example.demo.services;

import com.example.demo.entities.TransactionHistory;

public interface ITransactionHistoryService {
	void saveTransactionHistory(TransactionHistory transactionHistory) throws Exception;

}
