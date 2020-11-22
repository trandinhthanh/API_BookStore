package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.GiaoDich;
import com.book.store.modelConvert.ChiTietDonHangOutput;
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
	public ResponseEntity<List<ChiTietDonHangOutput>>  getAllTransaction(){
		List<ChiTietDonHangOutput> list = transactionService.getAllTransaction();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listTransaction/{id}")
	public ResponseEntity<ChiTietDonHangOutput> getNewByID(@PathVariable("id") long id){
		return new ResponseEntity<>(transactionService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createTransaction(@RequestBody GiaoDich giaoDich){
		if(transactionService.createTransaction(giaoDich)){
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	    return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@GetMapping("/updateTrangThai/{idGiaoDich}/{trangThai}")
	public ResponseEntity<GiaoDich> delete(@PathVariable("idGiaoDich") long idGiaoDich, @PathVariable("trangThai") String trangThai){
		if (transactionService.updateTrangThai(idGiaoDich, trangThai)) {
			return new ResponseEntity<GiaoDich>(HttpStatus.OK);
		}
		return new ResponseEntity<GiaoDich>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getChiTiet/{idNguoiGiaoDich}")
	public ResponseEntity<ChiTietDonHangOutput> getDetailById(@PathVariable("idNguoiGiaoDich") long idNguoiGiaoDich){
		ChiTietDonHangOutput detailNguoiDung = transactionService.chiTietNguoiDung(idNguoiGiaoDich);
		return new ResponseEntity<ChiTietDonHangOutput>(detailNguoiDung, HttpStatus.OK);
	}
}
