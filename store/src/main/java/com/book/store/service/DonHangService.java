package com.book.store.service;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DonHang;

public interface DonHangService {
	public List<DonHang> getAllDonHang();
	public DonHang createDonHang(DonHang donHang);
	public DonHang update(DonHang donHang);
	public void deleteDonHangById(long id);
	public Optional<DonHang> findById(long id);
}
