package com.book.store.model;

import java.util.List;

public class DoanhSo {
    private int tongSoTaiKhoan;
    private int tongDonHang;
    private double tongTienLoi;
    private double tongTienThuVe;
    List<DoanhSoSanPham> doanhSoSanPhamList;

    public int getTongSoTaiKhoan() {
        return tongSoTaiKhoan;
    }

    public void setTongSoTaiKhoan(int tongSoTaiKhoan) {
        this.tongSoTaiKhoan = tongSoTaiKhoan;
    }

    public int getTongDonHang() {
        return tongDonHang;
    }

    public void setTongDonHang(int tongDonHang) {
        this.tongDonHang = tongDonHang;
    }

    public double getTongTienLoi() {
        return tongTienLoi;
    }

    public void setTongTienLoi(double tongTienLoi) {
        this.tongTienLoi = tongTienLoi;
    }

    public double getTongTienThuVe() {
        return tongTienThuVe;
    }

    public void setTongTienThuVe(double tongTienThuVe) {
        this.tongTienThuVe = tongTienThuVe;
    }

    public List<DoanhSoSanPham> getDoanhSoSanPhamList() {
        return doanhSoSanPhamList;
    }

    public void setDoanhSoSanPhamList(List<DoanhSoSanPham> doanhSoSanPhamList) {
        this.doanhSoSanPhamList = doanhSoSanPhamList;
    }
}
