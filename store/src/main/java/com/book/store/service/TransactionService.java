package com.book.store.service;

import com.book.store.model.GiaoDich;
import com.book.store.modelConvert.ChiTietDonHangOutput;

import java.util.List;
import java.util.Optional;


public interface TransactionService {
	public List<GiaoDich> getAllTransaction();
	public boolean createTransaction(GiaoDich giaoDich);
	public GiaoDich Update(GiaoDich giaoDich);
	public void deleteTransactionById(long id);
	public Optional<GiaoDich> findById(long id);
	public ChiTietDonHangOutput chiTietNguoiDung(long id);
}
