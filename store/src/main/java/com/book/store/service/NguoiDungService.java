package com.book.store.service;

import com.book.store.model.NguoiDung;

import java.util.List;
import java.util.Optional;


public interface NguoiDungService {
	public List<NguoiDung> getAllNguoiDung();
	public NguoiDung createNguoiDung(NguoiDung nguoiDung);
	public NguoiDung update(NguoiDung nguoiDung);
	public void deleteNguoiDungById(long id);
	public Optional<NguoiDung> findById(long id);
	NguoiDung kiemTraDangNhap(String email, String matKhau);
}
