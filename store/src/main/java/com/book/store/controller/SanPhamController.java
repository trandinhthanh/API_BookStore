package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;
import com.book.store.repository.SanPhamRepository;
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
	public ResponseEntity<List<SanPhamOutput>>  getAllSanPham(){
		List<SanPhamOutput> list = sanPhamService.getAllSanPham();
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/listTenSanPham")
	public ResponseEntity<List<SanPhamOutput>>  getTenSanPham(){
		List<SanPhamOutput> list = sanPhamService.getNameSanPham();
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPham/{id}")
	public SanPhamOutput getSanPhamByID(@PathVariable("id") long id){
		return sanPhamService.findById(id);
	}

	@GetMapping("/listSanPhamTheoDanhMuc/{idDanhMucSP}")
	public ResponseEntity<List<SanPhamOutput>>  getSanPhamsByCatalog(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPhamOutput> list = sanPhamService.getSanPhamTheoDanhMuc(idDanhMucSP);
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPhamTheoPage/{linkDanhMuc}/{numberPage}")
	public ResponseEntity<ListSanPhamOutput>  getSanPhamsByCatalog(@PathVariable("linkDanhMuc") String linkDanhMuc, @PathVariable("numberPage") int numberPage){
		ListSanPhamOutput list = sanPhamService.getSanPhamTheoPage(linkDanhMuc, numberPage);
		return new ResponseEntity<ListSanPhamOutput>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPhamLienQuan/{idDanhMucSP}")
	public ResponseEntity<List<SanPhamOutput>>  getRelatedSanPham(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPhamOutput> list = sanPhamService.sanPhamLienQuan(idDanhMucSP);
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}


	@GetMapping("/listSanPhamNoiBat")
	public ResponseEntity<List<SanPhamOutput>>  sanPhamNoiBat(){
		List<SanPhamOutput> list = sanPhamService.sanPhamNoiBat();
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPhamVoiSoLuong")
	public ResponseEntity<List<SanPhamOutput>>  getSanPhamVoiSoLuong(){
		List<SanPhamOutput> list = sanPhamService.getSanPhamVoiSoLuong();
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createSanPham(@RequestBody SanPham product, UriComponentsBuilder ucBuilder){
		if(sanPhamService.createSanPham(product) == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody SanPham sanPham){
		if(sanPhamService.update(sanPham) == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<SanPham> delete(@PathVariable("id") long id){
		if(sanPhamService.deleteSanPhamById(id) == false){
			return new ResponseEntity<SanPham>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SanPham>(HttpStatus.NO_CONTENT);
	}
	
	
}
