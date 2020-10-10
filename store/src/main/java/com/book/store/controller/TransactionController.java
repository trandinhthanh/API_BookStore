package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.GiaoDich;
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
	public ResponseEntity<List<GiaoDich>>  getAllTransaction(){
		List<GiaoDich> list = transactionService.getAllTransaction();
		return new ResponseEntity<List<GiaoDich>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listTransaction/{id}")
	public Optional<GiaoDich> getNewByID(@PathVariable("id") long id){
		return transactionService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createTransaction(@RequestBody GiaoDich giaoDich){
		transactionService.createTransaction(giaoDich);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody GiaoDich giaoDich){
		Optional<GiaoDich> listTransaction = transactionService.findById(giaoDich.getIdGiaoDich());
		if (!listTransaction.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			transactionService.Update(giaoDich);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<GiaoDich> delete(@PathVariable("id") long id){
		Optional<GiaoDich> listTransaction = transactionService.findById(id);
		if (!listTransaction.isPresent()) {
			return new ResponseEntity<GiaoDich>(HttpStatus.NOT_FOUND);
		}
		else 
			transactionService.deleteTransactionById(id);
		return new ResponseEntity<GiaoDich>(HttpStatus.NO_CONTENT);
	}
}
