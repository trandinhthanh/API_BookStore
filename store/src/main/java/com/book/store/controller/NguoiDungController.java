package com.book.store.controller;

import java.util.List;

import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.NguoiDungConvert;
import com.book.store.modelConvert.NguoiDungInput;
import com.book.store.modelConvert.NguoiDungOutput;
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

@RestController
@RequestMapping("nguoiDung")
@CrossOrigin(origins = "*")
public class NguoiDungController {
    
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping("/listNguoiDung")
	public ResponseEntity<List<NguoiDungConvert>>  getAllNguoiDung(){
		List<NguoiDungConvert> list = nguoiDungService.getAllNguoiDung();
		return new ResponseEntity<List<NguoiDungConvert>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getNguoiDung/{id}")
	public ResponseEntity<NguoiDungOutput> getProductByID(@PathVariable("id") long id){
		NguoiDungOutput output = nguoiDungService.findById(id);
		return new ResponseEntity<NguoiDungOutput>(output, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Boolean> createNguoiDung(@RequestBody NguoiDung nguoiDung ){
//		nguoiDung.setMatKhau(Base64.getEncoder().encodeToString(nguoiDung.getMatKhau().getBytes()));
		if(nguoiDungService.createNguoiDung(nguoiDung)) {
			return new ResponseEntity<Boolean>(true ,HttpStatus.CREATED);
		}
		return new ResponseEntity<Boolean>(false ,HttpStatus.NOT_FOUND);
	}
	
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Boolean> update(@RequestBody NguoiDung nguoiDung){
		if (nguoiDungService.update(nguoiDung)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

    }


	@PostMapping(value="/editUserByUser",headers="Accept=application/json")
	public ResponseEntity<Boolean> update(@RequestBody NguoiDungInput input){
		if (nguoiDungService.editUserByUser(input)) {
			return new ResponseEntity<>(true ,HttpStatus.OK);
		}
		return new ResponseEntity<>(false ,HttpStatus.NOT_FOUND);
	}

	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<NguoiDung> delete(@PathVariable("id") long id){
		if (nguoiDungService.deleteNguoiDungById(id)) {
			return new ResponseEntity<NguoiDung>(HttpStatus.OK);
		}
		return new ResponseEntity<NguoiDung>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/dangNhap",headers="Accept=application/json")
	public ResponseEntity<NguoiDungOutput> dangNhap(@RequestBody NguoiDung nguoiDung ){
		NguoiDungOutput nd = nguoiDungService.kiemTraDangNhap(nguoiDung.getEmail(), nguoiDung.getMatKhau());
		if( nd != null){
			return new ResponseEntity<>( nd ,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value="/dangNhapAdmin",headers="Accept=application/json")
	public ResponseEntity<NguoiDungOutput> dangNhapAdmin(@RequestBody NguoiDung nguoiDung ){
		NguoiDungOutput nd = nguoiDungService.kiemTraDangNhapAdmin(nguoiDung.getEmail(), nguoiDung.getMatKhau());
		if( nd != null){
			return new ResponseEntity<>( nd ,HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/blockUser/{idNguoiDung}")
	public ResponseEntity<Boolean> blockUser(@PathVariable("idNguoiDung") long idNguoiDung){
		if(nguoiDungService.blockUser(idNguoiDung)) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(true, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
