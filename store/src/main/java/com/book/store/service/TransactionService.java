package com.book.store.service;

import com.book.store.model.Transaction;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
	public List<Transaction> getAllTransaction();
	public Transaction createTransaction(Transaction transaction);
	public Transaction Update(Transaction transaction);
	public void deleteTransactionById(long id);
	public Optional<Transaction> findById(long id);
}
