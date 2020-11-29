package com.book.store.service;

import java.util.List;

import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;

public interface SanPhamService {
	List<SanPhamOutput> getAllSanPham();
	SanPham createSanPham(SanPham sanPham);
	SanPham update(SanPham sanPham);
	boolean updateTrangThai(long idSanPham, String trangThai);
	SanPhamOutput findById(long id);
	List<SanPhamOutput> getSanPhamTheoDanhMuc(int danhMucSp );
	List<SanPhamOutput> sanPhamNoiBat();
	List<SanPhamOutput> sanPhamLienQuan(int danhMucSp );
	List<SanPhamOutput> getNameSanPham();
	List<SanPhamOutput> getSanPhamVoiSoLuong();
	ListSanPhamOutput getSanPhamTheoPage(String linkDanhMuc, int numberPage);
	List<SanPhamOutput> findByTenSanPham(String tenSanPham);
	List<SanPhamOutput> getListSanPhamGiamGia();
	void updateLuotXemByIdSanPham(long idSanPham);
}
