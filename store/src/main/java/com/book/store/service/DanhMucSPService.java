package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DanhMucSanPham;
import org.springframework.data.repository.query.Param;


public interface DanhMucSPService {
	List<DanhMucSanPham> getAllDanhMucSanPham();
	public List<DanhMucSanPham> getDanhMucSPHoatDong();
	DanhMucSanPham createDanhMucSanPham(DanhMucSanPham danhMucSp);
	DanhMucSanPham update(DanhMucSanPham danhMucSp);
	Optional<DanhMucSanPham> findById(long id);
	DanhMucSanPham findDanhMucSanPham(@Param("id") long id);
	boolean updateTrangThaiById(long idDanhMucSP, String trangThai);
	List<DanhMucSanPham> findByTenDanhMuc(String tenDanhMuc);
}
