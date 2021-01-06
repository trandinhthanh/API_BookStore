package com.book.store.controller;

import java.util.List;

import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;
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


	@GetMapping("/getSanPhamByID/{id}")
	public SanPhamOutput getSanPhamByID(@PathVariable("id") long id){
		return sanPhamService.findById(id);
	}

	@GetMapping("/listSanPhamTheoDanhMuc/{idDanhMucSP}")
	public ResponseEntity<List<SanPhamOutput>>  getSanPhamsByCatalog(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPhamOutput> list = sanPhamService.getSanPhamTheoDanhMuc(idDanhMucSP);
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPhamTheoPage/{linkDanhMuc}/{numberPage}")
	public ResponseEntity<ListSanPhamOutput>  listSanPhamTheoPage(@PathVariable("linkDanhMuc") String linkDanhMuc, @PathVariable("numberPage") int numberPage){
		ListSanPhamOutput list = sanPhamService.getSanPhamTheoPage(linkDanhMuc, numberPage);
		return new ResponseEntity<ListSanPhamOutput>(list, HttpStatus.OK);
	}

	@GetMapping("/listSanPhamLienQuan/{idDanhMucSP}")
	public ResponseEntity<List<SanPhamOutput>>  getRelatedSanPham(@PathVariable("idDanhMucSP") int idDanhMucSP){
		List<SanPhamOutput> list = sanPhamService.sanPhamLienQuan(idDanhMucSP);
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@GetMapping("/findByTenSanPham/{tenSanPham}")
	public ResponseEntity<List<SanPhamOutput>>  findByTenSanPham(@PathVariable("tenSanPham") String tenSanPham){
		List<SanPhamOutput> list = sanPhamService.findByTenSanPham(tenSanPham);
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

	@GetMapping("/getListSanPhamGiamGia")
	public ResponseEntity<List<SanPhamOutput>> getSanPhamByID(){
		List<SanPhamOutput> list = sanPhamService.getListSanPhamGiamGia();
		return new ResponseEntity<List<SanPhamOutput>>(list, HttpStatus.OK);
	}

	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<SanPham> createSanPham(@RequestBody SanPham sanPham){
		SanPham output = sanPhamService.createSanPham(sanPham);
		if(output == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(output ,HttpStatus.CREATED);
	}

	@GetMapping(value="/updateLuotXemByIdSanPham/{idSanPham}",headers="Accept=application/json")
	public void update(@PathVariable("idSanPham") long idSanPham){
		sanPhamService.updateLuotXemByIdSanPham(idSanPham);
	}

	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<SanPham> update(@RequestBody SanPham sanPham){
		SanPham output = sanPhamService.update(sanPham);
		if( sanPham == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>( output,HttpStatus.OK);
    }
	//cập nhật trang Thai sản phẩm
	@GetMapping("/updateTrangThai/{idSanPham}/{trangThai}")
	public ResponseEntity<Void> updateTrangThai(@PathVariable("idSanPham") long idSanPham, @PathVariable("trangThai") String trangThai){
		if(sanPhamService.updateTrangThai(idSanPham, trangThai) == false){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/locSanPham/{idDanhMucSP}/{loaiSapXep}/{loaiTrangThai}")
	public ResponseEntity<List<SanPhamOutput>>  locSanPham(@PathVariable("idDanhMucSP") int idDanhMucSP, @PathVariable("loaiSapXep") String loaiSapXep,@PathVariable("loaiTrangThai") int loaiTrangThai){
		List<SanPhamOutput> list = sanPhamService.locSanPham(idDanhMucSP, loaiSapXep, loaiTrangThai);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
}
