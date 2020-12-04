package com.book.store.service;

import com.book.store.model.GiamGia;

import java.util.List;

public interface GiamGiaService {
    List<GiamGia> getGiamGiaHoatDong();
    List<GiamGia> getAllGiamGia();
    GiamGia getGiamGiaById(long idGiamGia);
    GiamGia create(GiamGia giamGia);
    GiamGia update(GiamGia giamGia);
    boolean delete(long idGiamGia);
    List<GiamGia> findByTrangThai(String trangThai);
    List<GiamGia> findByTenGiamGia(String tenGiamGia);
}
