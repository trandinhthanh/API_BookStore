package com.book.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HinhAnh")
public class HinhAnh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="idHinhAnh")
	private long idHinhAnh;
	
	@Column(name="tenHinh")
    private String tenHinh;

	@Column(name="link")
    private String link;

	@Column(name="idSanPham")
	private long idSanPham;

	@Column(name="sapXep")
	private int sapXep;

	public long getIdHinhAnh() {
		return idHinhAnh;
	}

	public void setIdHinhAnh(long idHinhAnh) {
		this.idHinhAnh = idHinhAnh;
	}

	public String getTenHinh() {
		return tenHinh;
	}

	public void setTenHinh(String tenHinh) {
		this.tenHinh = tenHinh;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public long getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(long idSanPham) {
		this.idSanPham = idSanPham;
	}

	public int getSapXep() {
		return sapXep;
	}

	public void setSapXep(int sapXep) {
		this.sapXep = sapXep;
	}
}