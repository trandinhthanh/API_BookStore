package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.SanPham;
import com.book.store.repository.SanPhamRepository;
import com.book.store.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;
	
	@Override
	public List<SanPham> getAllSanPham() {
		return sanPhamRepository.findAll();
	}
	@Override
	public Page<SanPham> getSanPhamByPage(int page) {
		return sanPhamRepository.findAll(PageRequest.of(page, 12));
	}
	@Override
	public SanPham createSanPham(SanPham product) {
		return sanPhamRepository.save(product);
	}

	@Override
	public SanPham update(SanPham product) {
		return sanPhamRepository.save(product);
	}

	@Override
	public void deleteSanPhamById(long id) {
		sanPhamRepository.deleteById(id);
	}

	@Override
	public Optional<SanPham> findById(long id) {
		return sanPhamRepository.findById(id);
	}

	@Override
	public List<SanPham> getSanPhamTheoDanhMuc(int idDanhMucSP ) {

		return sanPhamRepository.getSanPhamTheoDanhMuc(idDanhMucSP);
	}
	
	@Override
	public List<SanPham> sanPhamNoiBat() {

		return sanPhamRepository.sanPhamNoiBat();
	}
	@Override
	public List<SanPham> sanPhamLienQuan(int idDanhMucSP ) {

		return sanPhamRepository.sanPhamLienQuan(idDanhMucSP);
	}

	@Override
	public List<SanPham> getNameSanPham() {

		return sanPhamRepository.getTenSanPham();
	}
	@Override
	public List<SanPham> getSanPhamVoiSoLuong() {
		return sanPhamRepository.getSanPhamVoiSoLuong();
	}
	
}
