package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;
import org.springframework.data.domain.Page;

public interface SanPhamService {
	public List<SanPhamOutput> getAllSanPham();
	public SanPham createSanPham(SanPham sanPham);
	public SanPham update(SanPham sanPham);
	public boolean deleteSanPhamById(long id);
	public SanPhamOutput findById(long id);
	public List<SanPhamOutput> getSanPhamTheoDanhMuc(int danhMucSp );
	public List<SanPhamOutput> sanPhamNoiBat();
	public List<SanPhamOutput> sanPhamLienQuan(int danhMucSp );
	public List<SanPhamOutput> getNameSanPham();
	public List<SanPhamOutput> getSanPhamVoiSoLuong();
	ListSanPhamOutput getSanPhamTheoPage(String linkDanhMuc, int numberPage);
	List<SanPhamOutput> findByTenSanPham(String tenSanPham);
}
