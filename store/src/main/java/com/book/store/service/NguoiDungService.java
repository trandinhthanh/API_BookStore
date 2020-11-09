package com.book.store.service;

import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.NguoiDungInput;
import com.book.store.modelConvert.NguoiDungOutput;

import java.util.List;
import java.util.Optional;


public interface NguoiDungService {
	public List<NguoiDung> getAllNguoiDung();
	public NguoiDung createNguoiDung(NguoiDung nguoiDung);
	public boolean update(NguoiDung nguoiDung);
	public boolean deleteNguoiDungById(long id);
	public NguoiDungOutput findById(long id);
	NguoiDung kiemTraDangNhap(String email, String matKhau);
	boolean editUserByUser(NguoiDungInput input);
}
