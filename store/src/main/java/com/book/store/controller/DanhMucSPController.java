package com.book.store.controller;

import java.util.List;

import com.book.store.model.DanhMucSanPham;
import com.book.store.service.DanhMucSPService;
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
@RequestMapping("danhMucSP")
@CrossOrigin(origins = "*")
public class DanhMucSPController {
	@Autowired
	private DanhMucSPService danhMucSPService;
	
	@GetMapping("/listDanhMucSanPham")
	public ResponseEntity<List<DanhMucSanPham>>  getAllDanhMucSanPham(){
		List<DanhMucSanPham> list = danhMucSPService.getAllDanhMucSanPham();
		return new ResponseEntity<List<DanhMucSanPham>>(list, HttpStatus.OK);
	}

	@GetMapping("/getDanhMucSPHoatDong")
	public ResponseEntity<List<DanhMucSanPham>>  getDanhMucSPHoatDong(){
		List<DanhMucSanPham> list = danhMucSPService.getDanhMucSPHoatDong();
		return new ResponseEntity<List<DanhMucSanPham>>(list, HttpStatus.OK);
	}

	@GetMapping("/getDanhMucById/{idDanhMucSP}")
	public ResponseEntity<DanhMucSanPham>  getDanhMucById(@PathVariable("idDanhMucSP") long idDanhMucSP){
		return new ResponseEntity<DanhMucSanPham>(danhMucSPService.findDanhMucSanPham(idDanhMucSP), HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createDanhMucSanPham(@RequestBody DanhMucSanPham danhMucSP, UriComponentsBuilder ucBuilder){
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSPService.getAllDanhMucSanPham();
		for( DanhMucSanPham danhmucSP : listDanhMucSanPham)
			if(danhMucSP.getTenDanhMuc().equals(danhmucSP.getTenDanhMuc())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				danhMucSPService.createDanhMucSanPham(danhMucSP);
			} 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody DanhMucSanPham danhMucSP, UriComponentsBuilder ucBuilder){
		if (danhMucSPService.update(danhMucSP) == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }

	@GetMapping("/updateTrangThai/{idDanhMucSP}/{trangThai}")
	public ResponseEntity<Void> updateTrangThaiById(@PathVariable("idDanhMucSP") long idDanhMucSP,@PathVariable("trangThai") String trangThai){
		if (danhMucSPService.updateTrangThaiById(idDanhMucSP, trangThai)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findByTenDanhMuc/{tenDanhMuc}")
	public ResponseEntity<List<DanhMucSanPham>>  findByTenDanhMuc(@PathVariable("tenDanhMuc") String tenDanhMuc){
		List<DanhMucSanPham> list = danhMucSPService.findByTenDanhMuc(tenDanhMuc);
		return new ResponseEntity<List<DanhMucSanPham>>(list, HttpStatus.OK);
	}
}
