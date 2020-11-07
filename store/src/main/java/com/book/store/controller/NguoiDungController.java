package com.book.store.controller;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.book.store.model.NguoiDung;
import com.book.store.service.NguoiDungService;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("nguoiDung")
@CrossOrigin(origins = "*")
public class NguoiDungController {
    
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping("/listNguoiDung")
	public ResponseEntity<List<NguoiDung>>  getAllNguoiDung(){
		List<NguoiDung> list = nguoiDungService.getAllNguoiDung();
		return new ResponseEntity<List<NguoiDung>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getNguoiDung/{id}")
	public Optional<NguoiDung> getProductByID(@PathVariable("id") long id){
		return nguoiDungService.findById(id);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Boolean> createNguoiDung(@RequestBody NguoiDung nguoiDung ){
		nguoiDung.setMatKhau(Base64.getEncoder().encodeToString(nguoiDung.getMatKhau().getBytes()));
		List<NguoiDung> listNguoiDung = nguoiDungService.getAllNguoiDung();
		for( NguoiDung nd : listNguoiDung){
			if(nguoiDung.getEmail().equals(nd.getEmail())) {
				return new ResponseEntity<Boolean>(false ,HttpStatus.NOT_FOUND);
			}
		}
		nguoiDungService.createNguoiDung(nguoiDung);
		return new ResponseEntity<Boolean>(true ,HttpStatus.CREATED);
	}
	
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody NguoiDung nguoiDung){
		Optional<NguoiDung> listNguoiDung = nguoiDungService.findById(nguoiDung.getIdNguoiDung());
		if (!listNguoiDung.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			nguoiDungService.update(nguoiDung);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<NguoiDung> delete(@PathVariable("id") long id){
		Optional<NguoiDung> listNguoiDung = nguoiDungService.findById(id);
		if (!listNguoiDung.isPresent()) {
			return new ResponseEntity<NguoiDung>(HttpStatus.NOT_FOUND);
		}
		else
			nguoiDungService.deleteNguoiDungById(id);
		return new ResponseEntity<NguoiDung>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value="/dangNhap",headers="Accept=application/json")
	public ResponseEntity<NguoiDung> dangNhap(@RequestBody NguoiDung nguoiDung ){
		NguoiDung nd = nguoiDungService.kiemTraDangNhap(nguoiDung.getEmail(), nguoiDung.getMatKhau());
		if( nd != null){
			return new ResponseEntity<NguoiDung>( nd ,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<NguoiDung>(HttpStatus.NOT_FOUND);
	}
}
