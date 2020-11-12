package com.book.store.service;

import com.book.store.model.GiaoDich;
import com.book.store.modelConvert.ChiTietDonHangOutput;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
	List<GiaoDich> getAllTransaction();
	boolean createTransaction(GiaoDich giaoDich);
	GiaoDich Update(GiaoDich giaoDich);
	void deleteTransactionById(long id);
	Optional<GiaoDich> findById(long id);
	ChiTietDonHangOutput chiTietNguoiDung(long id);
}
