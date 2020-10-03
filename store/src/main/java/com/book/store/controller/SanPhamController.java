package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.SanPham;
import com.book.store.service.SanPhamService;
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
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("sanPham")
@CrossOrigin(origins = "*")
public class SanPhamController {
	@Autowired
	private SanPhamService sanPhamService;
	
	@GetMapping("/listSanPham")
	public ResponseEntity<List<SanPham>>  getAllSanPham(){
		List<SanPham> list = sanPhamService.getAllSanPham();
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listSanPhamByPage/{page}")
	public Page<SanPham> getSanPhamByPage(@PathVariable("page") int page){
		return sanPhamService.getSanPhamByPage(page);
	}
	
	@GetMapping("/listTenSanPham")
	public ResponseEntity<List<SanPham>>  getTenSanPham(){
		List<SanPham> list = sanPhamService.getNameSanPham();
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listSanPham/{id}")
	public Optional<SanPham> getSanPhamByID(@PathVariable("id") long id){
		return sanPhamService.findById(id);
	}
	
	@GetMapping("/listSanPhamTheoDanhMuc/{idDanhMucSP}")
	public ResponseEntity<List<SanPham>>  getSanPhamsByCatalog(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPham> list = sanPhamService.getSanPhamTheoDanhMuc(idDanhMucSP);
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listSanPhamLienQuan/{idDanhMucSP}")
	public ResponseEntity<List<SanPham>>  getRelatedSanPham(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPham> list = sanPhamService.sanPhamLienQuan(idDanhMucSP);
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/listSanPhamNoiBat")
	public ResponseEntity<List<SanPham>>  sanPhamNoiBat(){
		List<SanPham> list = sanPhamService.sanPhamNoiBat();
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/listSanPhamVoiSoLuong")
	public ResponseEntity<List<SanPham>>  getSanPhamVoiSoLuong(){
		List<SanPham> list = sanPhamService.getSanPhamVoiSoLuong();
		return new ResponseEntity<List<SanPham>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createSanPham(@RequestBody SanPham product, UriComponentsBuilder ucBuilder){
		List<SanPham> listSanPhams = sanPhamService.getAllSanPham();
		for( SanPham products : listSanPhams) {
			if(product.getTenSanPham().equals(products.getTenSanPham())) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			else {
				sanPhamService.createSanPham(product);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody SanPham product){
		Optional<SanPham> listSanPham = sanPhamService.findById(product.getId());
		if (!listSanPham.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			sanPhamService.update(product);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<SanPham> delete(@PathVariable("id") long id){
		Optional<SanPham> listSanPham = sanPhamService.findById(id);
		if (!listSanPham.isPresent()) {
			return new ResponseEntity<SanPham>(HttpStatus.NOT_FOUND);
		}
		else 
			sanPhamService.deleteSanPhamById(id);
		return new ResponseEntity<SanPham>(HttpStatus.NO_CONTENT);
	}
	
	
}
