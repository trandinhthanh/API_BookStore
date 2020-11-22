package com.book.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DonHang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idDonHang")
	private long idDonHang;
	
	@Column(name="idNguoiGiaoDich")
	private long idNguoiGiaoDich;

	@Column(name="idGiaoDich")
	private long idGiaoDich;
	
	@Column(name="idSanPham")
	private long idSanPham;
	
	@Column(name="soLuong")
	private int soLuong;
	
	@Column(name="tien")
	private double tien;

	@Column(name="ngayTao")
	private LocalDate ngayTao;
	
	@Column(name="trangThai")
	private String trangThai;

	public long getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(long idDonHang) {
		this.idDonHang = idDonHang;
	}

	public long getIdNguoiGiaoDich() {
		return idNguoiGiaoDich;
	}

	public void setIdNguoiGiaoDich(long idNguoiGiaoDich) {
		this.idNguoiGiaoDich = idNguoiGiaoDich;
	}

	public long getIdGiaoDich() {
		return idGiaoDich;
	}

	public void setIdGiaoDich(long idGiaoDich) {
		this.idGiaoDich = idGiaoDich;
	}

	public long getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(long idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTien() {
		return tien;
	}

	public void setTien(double tien) {
		this.tien = tien;
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
