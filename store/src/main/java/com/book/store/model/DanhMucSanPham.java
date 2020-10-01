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

	@Column(name="image")
	private String image;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
