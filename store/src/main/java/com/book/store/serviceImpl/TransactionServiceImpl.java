package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.Transaction;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<Transaction> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction Update(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}

	@Override
	public void deleteTransactionById(long id) {
		
		transactionRepository.deleteById(id);
	}

	@Override
	public Optional<Transaction> findById(long id) {
		
		return transactionRepository.findById(id);
	}
}
