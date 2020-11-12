package com.book.store.service;

import com.book.store.model.HinhAnh;

import java.util.List;
import java.util.Optional;


public interface HinhAnhService {
	
	boolean save(List<HinhAnh> dshinhAnh);
	Optional<HinhAnh> getFile(long id);
}
