package com.book.store.controller;

import java.util.List;

import com.book.store.model.DanhMucSanPham;
import com.book.store.service.DanhMucSPService;
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
	
	@GetMapping("/findImage/{id}")
    public List<String> getFindImage(@PathVariable("id") long id){
		return danhMucSPService.findDanhMucSanPhamImage(id);
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
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSPService.findDanhMucSanPham(danhMucSP.getId());
		if (listDanhMucSanPham.size()<=0) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			danhMucSPService.update(danhMucSP);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<DanhMucSanPham> delete(@PathVariable("id") long id){
		List<DanhMucSanPham> listDanhMucSanPham = danhMucSPService.findDanhMucSanPham(id);
		if (listDanhMucSanPham.size()<=0) {
			return new ResponseEntity<DanhMucSanPham>(HttpStatus.NOT_FOUND);
		}
		else
			danhMucSPService.deleteDanhMucSanPhamById(id);
		return new ResponseEntity<DanhMucSanPham>(HttpStatus.NO_CONTENT);
	}
}
