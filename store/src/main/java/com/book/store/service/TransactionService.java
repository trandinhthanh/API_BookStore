package com.book.store.service;

import com.book.store.model.GiaoDich;
import com.book.store.modelConvert.ChiTietDonHangOutput;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
	List<ChiTietDonHangOutput> getAllTransaction();
	boolean createTransaction(GiaoDich giaoDich);
	boolean updateTrangThai(long idGiaoDich,String trangThai);
	ChiTietDonHangOutput findById(long id);
	ChiTietDonHangOutput chiTietNguoiDung(long id);
}
