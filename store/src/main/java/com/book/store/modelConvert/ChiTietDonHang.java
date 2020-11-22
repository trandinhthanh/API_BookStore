package com.book.store.modelConvert;

import java.time.LocalDate;

public interface ChiTietDonHang {
    long getIdDonHang();
    long getIdSanPham();
    int getSoLuong();
    double getGia();
    String getTenSanPham();
    int getPhanTramGiam();
    LocalDate getNgayBatDau();
    LocalDate getNgayKetThuc();
}
