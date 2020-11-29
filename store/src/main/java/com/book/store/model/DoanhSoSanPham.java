package com.book.store.model;

public class DoanhSoSanPham {
    String tenSanPham;
    String loai;
    int soLuong;
    double tienVon;
    double tienLoi;
    double tienThuVe;

    public DoanhSoSanPham(String tenSanPham, String loai, int soLuong, double tienVon, double tienLoi, double tienThuVe) {
        this.tenSanPham = tenSanPham;
        this.loai = loai;
        this.soLuong = soLuong;
        this.tienVon = tienVon;
        this.tienLoi = tienLoi;
        this.tienThuVe = tienThuVe;
    }

    public DoanhSoSanPham() {
        this.tenSanPham = "";
        this.loai = "";
        this.soLuong = 0;
        this.tienVon = 0.0;
        this.tienLoi = 0.0;
        this.tienThuVe = 0.0;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTienVon() {
        return tienVon;
    }

    public void setTienVon(double tienVon) {
        this.tienVon = tienVon;
    }

    public double getTienLoi() {
        return tienLoi;
    }

    public void setTienLoi(double tienLoi) {
        this.tienLoi = tienLoi;
    }

    public double getTienThuVe() {
        return tienThuVe;
    }

    public void setTienThuVe(double tienThuVe) {
        this.tienThuVe = tienThuVe;
    }
}
