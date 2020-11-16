package com.book.store.modelConvert;

import java.time.LocalDate;
import java.util.List;

public class SanPhamOutput {
	private long idSanPham;

	private int idDanhMucSP;

	private String tenDanhMucSP;

	private String tenSanPham;

	private double gia;

	private String moTa;

	private int giamGia ;

	private String tacGia;

	private String nhaXuatBan;

	private String linkHinhChinh;

	private List<String> danhSachLinkHinh;

	private int luotXem;

	private int luotThich;

	private int soLuong;

	private LocalDate ngayTao;

	private String nguoiTao;

	private LocalDate ngayThayDoi;

	private String nguoiThayDoi;

	private String trangThai;

	public long getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(long idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getIdDanhMucSP() {
		return idDanhMucSP;
	}

	public void setIdDanhMucSP(int idDanhMucSP) {
		this.idDanhMucSP = idDanhMucSP;
	}

	public String getTenDanhMucSP() {
		return tenDanhMucSP;
	}

	public void setTenDanhMucSP(String tenDanhMucSP) {
		this.tenDanhMucSP = tenDanhMucSP;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getLinkHinhChinh() {
		return linkHinhChinh;
	}

	public void setLinkHinhChinh(String linkHinhChinh) {
		this.linkHinhChinh = linkHinhChinh;
	}

	public List<String> getDanhSachLinkHinh() {
		return danhSachLinkHinh;
	}

	public void setDanhSachLinkHinh(List<String> danhSachLinkHinh) {
		this.danhSachLinkHinh = danhSachLinkHinh;
	}

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}

	public int getLuotThich() {
		return luotThich;
	}

	public void setLuotThich(int luotThich) {
		this.luotThich = luotThich;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public LocalDate getNgayThayDoi() {
		return ngayThayDoi;
	}

	public void setNgayThayDoi(LocalDate ngayThayDoi) {
		this.ngayThayDoi = ngayThayDoi;
	}

	public String getNguoiThayDoi() {
		return nguoiThayDoi;
	}

	public void setNguoiThayDoi(String nguoiThayDoi) {
		this.nguoiThayDoi = nguoiThayDoi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
