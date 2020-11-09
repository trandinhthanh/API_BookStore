package com.book.store.modelConvert;

public class NguoiDungOutput {

    private long idNguoiDung;

    private String tenNguoiDung;

    private String email;

    private String soDienThoai;

    private String diaChi;

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
}
