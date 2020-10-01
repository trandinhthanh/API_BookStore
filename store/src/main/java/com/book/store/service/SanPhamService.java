package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.SanPham;
import org.springframework.data.domain.Page;

public interface SanPhamService {
	public List<SanPham> getAllSanPham();
	public SanPham createSanPham(SanPham sanPham);
	public SanPham update(SanPham sanPham);
	public void deleteSanPhamById(long id);
	public Optional<SanPham> findById(long id);
	public List<SanPham> getSanPhamTheoDanhMuc(int danhMucSp );
	public List<SanPham> sanPhamNoiBat();
	public List<SanPham> sanPhamLienQuan(int danhMucSp );
	public List<SanPham> getNameSanPham();
	public Page<SanPham> getSanPhamByPage(int page);
	public List<SanPham> getSanPhamVoiSoLuong();
}
