package com.book.store.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idSanPham")
	private long idSanPham;
	
	@Column(name="idDanhMucSP")
	private int idDanhMucSP;
	
	@Column(name="tenSanPham")
	private String tenSanPham;
	
	@Column(name="gia")
	private double gia;
	
	@Column(name="moTa")
	private String moTa;
	
	@Column(name="idGiamGia")
	private int idGiamGia ;

	@Column(name="tacGia")
	private String tacGia;

	@Column(name="nhaXuatBan")
	private String nhaXuatBan;
	
	@Column(name="luotXem")
	private int luotXem;
	
	@Column(name="luotThich")
	private int luotThich;
	
	@Column(name="soLuong")
	private int soLuong;
	
	@Column(name="ngayTao")
	private LocalDate ngayTao;
	
	@Column(name="nguoiTao")
	private String nguoiTao;
	
	@Column(name="ngayThayDoi")
	private LocalDate ngayThayDoi;
	
	@Column(name="nguoiThayDoi")
	private String nguoiThayDoi;
	
	@Column(name="trangThai")
	private String trangThai;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

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

	public int getIdGiamGia() {
		return idGiamGia;
	}

	public void setIdGiamGia(int idGiamGia) {
		this.idGiamGia = idGiamGia;
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
