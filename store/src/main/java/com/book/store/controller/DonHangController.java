package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DonHang;
import com.book.store.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("donHang")
@CrossOrigin(origins = "*")
public class DonHangController {
	@Autowired
	private DonHangService donHangService;
	
	@GetMapping("/listDonHang")
	public ResponseEntity<List<DonHang>>  getAllDonHang(){
		List<DonHang> list = donHangService.getAllDonHang();
		return new ResponseEntity<List<DonHang>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getDonHangByIdNguoiDung/{idNguoiDung}")
	public List<DonHang> getByIdNguoiGiaoDich(@PathVariable("idNguoiDung") long idNguoiDung){
		return donHangService.findByIdNguoiGiaoDich(idNguoiDung);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createDonHang(@RequestBody DonHang donHang){
		donHangService.createDonHang(donHang);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody DonHang donHang){
		boolean statusUpdate = donHangService.updateDonHang(donHang);
		if (statusUpdate) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
	//delete
	@PostMapping(value="/delete",headers="Accept=application/json")
	public ResponseEntity<DonHang> delete(@RequestBody DonHang donHang){
		if (donHangService.deleteDonHang(donHang)) {
			return new ResponseEntity<DonHang>(HttpStatus.OK);
		}
		return new ResponseEntity<DonHang>(HttpStatus.NOT_FOUND);
	}
}
