package com.book.store.modelConvert;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ChiTietDonHangOutput {

    private String tenNguoiDung;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private List<SanPhamThanhTien> sanPhamThanhTiens;
    private double tongCong;

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getTongCong() {
        return tongCong;
    }

    public void setTongCong(double tongCong) {
        this.tongCong = tongCong;
    }

    public List<SanPhamThanhTien> getSanPhamThanhTiens() {
        return sanPhamThanhTiens;
    }

    public void setSanPhamThanhTiens(List<SanPhamThanhTien> sanPhamThanhTiens) {
        this.sanPhamThanhTiens = sanPhamThanhTiens;
    }
}
