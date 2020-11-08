package com.book.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GiaoDich")
public class GiaoDich {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idGiaoDich")
	private long idGiaoDich;
	
	@Column(name="trangThai")
	private String trangThai;
	
	@Column(name="idKhachHang")
	private long idKhachHang;
	
	@Column(name="tenKhachHang")
	private String tenKhachHang;
	
	@Column(name="soDienThoai")
	private String soDienThoai;
	
	@Column(name="diaChiGiaoHang")
	private String diaChiGiaoHang;
	
	@Column(name="soTien")
	private double soTien;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ghiChu")
	private String ghiChu;
	
	@Column(name="ngayTao")
	private LocalDate ngayTao;

	public long getIdGiaoDich() {
		return idGiaoDich;
	}

	public void setIdGiaoDich(long idGiaoDich) {
		this.idGiaoDich = idGiaoDich;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public long getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(long idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public LocalDate getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(LocalDate ngayTao) {
		this.ngayTao = ngayTao;
	}
}
