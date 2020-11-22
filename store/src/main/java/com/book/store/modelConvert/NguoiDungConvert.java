package com.book.store.modelConvert;

import javax.persistence.Column;
import java.time.LocalDate;

public class NguoiDungConvert {

    private long idNguoiDung;
    
    private String tenNguoiDung;
    
    private String email;
    
    private String soDienThoai;
    
    private String diaChi;
    
    private boolean laQuanLy;
    
    private LocalDate ngayTao;
    
    private String trangThai;

    public long getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(long idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
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

    public boolean isLaQuanLy() {
        return laQuanLy;
    }

    public void setLaQuanLy(boolean laQuanLy) {
        this.laQuanLy = laQuanLy;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
