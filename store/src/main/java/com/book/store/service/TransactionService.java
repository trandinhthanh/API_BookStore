package com.book.store.service;

import com.book.store.model.GiaoDich;
import com.book.store.modelConvert.ChiTietDonHangOutput;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TransactionService {
	List<ChiTietDonHangOutput> getAllTransaction();
	boolean createTransaction(GiaoDich giaoDich);
	boolean updateTrangThai(long idGiaoDich,String trangThai);
	ChiTietDonHangOutput findById(long id);
	ChiTietDonHangOutput chiTietNguoiDung(long id);
	List<ChiTietDonHangOutput> getTransactionByDate(LocalDate fromDate, LocalDate toDate);
	List<ChiTietDonHangOutput> findByTenKhachHang(String tenKhachHang);
	List<GiaoDich> findByIdKhachHang(long idKhachHang);
	boolean checkTonKho(long idKhachHang);
}
