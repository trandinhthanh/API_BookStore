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
	
	@Column(name="id")
	private long id;
	
	@Column(name="idNguoiGiaoDich")
	private long idNguoiGiaoDich;

	@Column(name="laNguoiDung")
	private boolean laNguoiDung;
	
	@Column(name="idSanPham")
	private int idSanPham;
	
	@Column(name="soLuong")
	private int soLuong;
	
	@Column(name="tien")
	private double tien;

	@Column(name="ngayTao")
	private LocalDate ngayTao;

	@Column(name="nguoiTao")
	private String nguoiTao;
	
	@Column(name="trangThai")
	private String trangThai;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdNguoiGiaoDich() {
		return idNguoiGiaoDich;
	}

	public void setIdNguoiGiaoDich(long idNguoiGiaoDich) {
		this.idNguoiGiaoDich = idNguoiGiaoDich;
	}

	public boolean isLaNguoiDung() {
		return laNguoiDung;
	}

	public void setLaNguoiDung(boolean laNguoiDung) {
		this.laNguoiDung = laNguoiDung;
	}

	public int getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(int idSanPham) {
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

	public String getNguoiTao() {
		return nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		this.nguoiTao = nguoiTao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
