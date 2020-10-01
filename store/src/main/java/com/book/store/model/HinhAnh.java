package com.book.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "HinhAnh")
public class HinhAnh {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private long id;
	
	@Column(name="tenHinh")
    private String tenHinh;

	@Column(name="tepHinhAnh")
    private String tepHinhAnh;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenHinh() {
		return tenHinh;
	}

	public void setTenHinh(String tenHinh) {
		this.tenHinh = tenHinh;
	}

	public String getTepHinhAnh() {
		return tepHinhAnh;
	}

	public void setTepHinhAnh(String tepHinhAnh) {
		this.tepHinhAnh = tepHinhAnh;
	}
}