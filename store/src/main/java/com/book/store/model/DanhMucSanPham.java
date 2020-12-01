package com.book.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DanhMucSanPham")
public class DanhMucSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="idDanhMucSP")
	private long idDanhMucSP;

	@Column(name="tenDanhMuc")
	private String tenDanhMuc;

	@Column(name="linkDanhMuc")
	private String linkDanhMuc;

	@Column(name="trangThai")
	private String trangThai;

	public long getIdDanhMucSP() {
		return idDanhMucSP;
	}

	public void setIdDanhMucSP(long idDanhMucSP) {
		this.idDanhMucSP = idDanhMucSP;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getLinkDanhMuc() {
		return linkDanhMuc;
	}

	public void setLinkDanhMuc(String linkDanhMuc) {
		this.linkDanhMuc = linkDanhMuc;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
