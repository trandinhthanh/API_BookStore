package com.book.store.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slide")
public class Slide {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private long id;

	@Column(name="hinh")
	private String hinh;
	
	@Column(name="link")
	private String link;
	
	@Column(name="tieuDe")
	private String tieuDe;

	@Column(name="ngayTao")
	private LocalDate ngayTao;

	@Column(name="nguoiTao")
	private String nguoiTao;

	@Column(name="ngayThayDoi")
	private LocalDate ngayThayDoi;

	@Column(name="nguoiThayDoi")
	private String nguoiThayDoi;
	
	@Column(name="thuTuHienThi")
	private int thuTuHienThi;
	
	@Column(name="chiTiet")
	private String chiTiet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
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

	public int getThuTuHienThi() {
		return thuTuHienThi;
	}

	public void setThuTuHienThi(int thuTuHienThi) {
		this.thuTuHienThi = thuTuHienThi;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
}
