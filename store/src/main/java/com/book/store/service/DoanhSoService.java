package com.book.store.service;

import com.book.store.model.DoanhSo;

import java.time.LocalDate;

public interface DoanhSoService {
    DoanhSo getDoanhSo(LocalDate formDate, LocalDate toDate);
}
