package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DonHang;
import org.springframework.web.bind.annotation.RequestBody;

public interface DonHangService {
	List<DonHang> getAllDonHang();
	DonHang createDonHang(DonHang donHang);
	boolean updateDonHang(DonHang donHang);
	boolean deleteDonHang(DonHang donHang);
	List<DonHang> findByIdNguoiGiaoDich(long idNguoiGiaoDich);
}
