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

	@Column(name="id")
	private long id;

	@Column(name="tenDanhMuc")
	private String tenDanhMuc;

	@Column(name="linkDanhMuc")
	private String linkDanhMuc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
