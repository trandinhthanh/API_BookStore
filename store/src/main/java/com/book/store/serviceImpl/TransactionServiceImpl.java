package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.GiaoDich;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<GiaoDich> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public GiaoDich createTransaction(GiaoDich giaoDich) {
		
		return transactionRepository.save(giaoDich);
	}

	@Override
	public GiaoDich Update(GiaoDich giaoDich) {
		
		return transactionRepository.save(giaoDich);
	}

	@Override
	public void deleteTransactionById(long id) {
		
		transactionRepository.deleteById(id);
	}

	@Override
	public Optional<GiaoDich> findById(long id) {
		
		return transactionRepository.findById(id);
	}
}
