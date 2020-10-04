package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DanhMucSanPham;
import org.springframework.data.repository.query.Param;


public interface DanhMucSPService {
	public List<DanhMucSanPham> getAllDanhMucSanPham();
	public DanhMucSanPham createDanhMucSanPham(DanhMucSanPham danhMucSp);
	public DanhMucSanPham update(DanhMucSanPham danhMucSp);
	public void deleteDanhMucSanPhamById(long id);
	public Optional<DanhMucSanPham> findById(long id);
	public List<DanhMucSanPham> findDanhMucSanPham(@Param("id") long id);
}
