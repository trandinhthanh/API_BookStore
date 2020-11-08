package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DonHang;
import org.springframework.web.bind.annotation.RequestBody;

public interface DonHangService {
	public List<DonHang> getAllDonHang();
	public DonHang createDonHang(DonHang donHang);
	public boolean updateDonHang(DonHang donHang);
	public boolean deleteDonHang(DonHang donHang);
	public List<DonHang> findByIdNguoiGiaoDich(long idNguoiGiaoDich);
}
