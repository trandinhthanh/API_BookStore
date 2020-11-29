package com.book.store.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface HinhAnhService {

	byte[] getImg(String id);
	boolean saveImg(long idSanPham, List<MultipartFile> images);
	boolean deleteByLink(long idSanPham, String link);
}
