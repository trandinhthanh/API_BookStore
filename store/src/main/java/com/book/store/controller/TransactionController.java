package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.Transaction;
import com.book.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
@RestController
@RequestMapping("transaction")
@CrossOrigin(origins = "*")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/listTransaction")
	public ResponseEntity<List<Transaction>>  getAllTransaction(){
		List<Transaction> list = transactionService.getAllTransaction();
		return new ResponseEntity<List<Transaction>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listTransaction/{id}")
	public Optional<Transaction> getNewByID(@PathVariable("id") long id){
		return transactionService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createTransaction(@RequestBody Transaction transaction){
		transactionService.createTransaction(transaction);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Transaction transaction){
		Optional<Transaction> listTransaction = transactionService.findById(transaction.getId());
		if (!listTransaction.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			transactionService.Update(transaction);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<Transaction> delete(@PathVariable("id") long id){
		Optional<Transaction> listTransaction = transactionService.findById(id);
		if (!listTransaction.isPresent()) {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		else 
			transactionService.deleteTransactionById(id);
		return new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT);
	}
}
