package com.book.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;
	
	@Column(name="tenNguoiDung")
	private String tenNguoiDung;
	
	@Column(name="email")
	private String email;
	
	@Column(name="soDienThoai")
	private String soDienThoai;
	
	@Column(name="diaChi")
	private String diaChi;
	
	@Column(name="matKhau")
	private String matKhau;

	@Column(name="laQuanLy")
	private boolean laQuanLy;
	
	@Column(name="ngayTao")
	private LocalDate ngayTao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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
}
