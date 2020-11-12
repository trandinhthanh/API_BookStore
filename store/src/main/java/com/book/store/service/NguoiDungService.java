package com.book.store.service;

import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.NguoiDungInput;
import com.book.store.modelConvert.NguoiDungOutput;

import java.util.List;


public interface NguoiDungService {
	List<NguoiDung> getAllNguoiDung();
	NguoiDung createNguoiDung(NguoiDung nguoiDung);
	boolean update(NguoiDung nguoiDung);
	boolean deleteNguoiDungById(long id);
	NguoiDungOutput findById(long id);
	NguoiDung kiemTraDangNhap(String email, String matKhau);
	boolean editUserByUser(NguoiDungInput input);
}
