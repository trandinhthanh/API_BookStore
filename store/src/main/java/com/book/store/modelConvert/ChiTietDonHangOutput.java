package com.book.store.modelConvert;

import java.time.LocalDate;
import java.util.List;


public class ChiTietDonHangOutput {
    private long idGiaoDich;
    private String tenNguoiDung;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private List<SanPhamThanhTien> sanPhamThanhTiens;
    private double tongCong;
    private LocalDate ngayMua;
    private String ghiChu;
    private String trangThai;
    private String loaiThanhToan;

    public long getIdGiaoDich() {
        return idGiaoDich;
    }

    public void setIdGiaoDich(long idGiaoDich) {
        this.idGiaoDich = idGiaoDich;
    }

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

    public LocalDate getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiThanhToan() {
        return loaiThanhToan;
    }

    public void setLoaiThanhToan(String loaiThanhToan) {
        this.loaiThanhToan = loaiThanhToan;
    }
}
