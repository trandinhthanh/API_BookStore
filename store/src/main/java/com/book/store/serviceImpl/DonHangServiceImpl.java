package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.book.store.model.DonHang;
import com.book.store.repository.DonHangRepository;
import com.book.store.service.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DonHangServiceImpl implements DonHangService {
	@Autowired
	private DonHangRepository donHangRepository;
	
	@Override
	public List<DonHang> getAllDonHang() {
		
		return donHangRepository.findAll();
	}

	@Override
	public DonHang createDonHang(DonHang donHang) {
		donHang.setNgayTao(LocalDate.now());
		donHang.setTrangThai("0");
		return donHangRepository.save(donHang);
	}

	@Override
	public boolean updateDonHang(DonHang donHang) {
		int status = donHangRepository.updateSoLuong(donHang.getSoLuong(), donHang.getIdNguoiGiaoDich(), donHang.getIdSanPham());
		if(status > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDonHang(DonHang donHang) {
		int status = donHangRepository.deleteDongHang(donHang);
		if(status > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<DonHang> findByIdNguoiGiaoDich(long idNguoiGiaoDich) {
		return donHangRepository.findByIdNguoiGiaoDichContaining(idNguoiGiaoDich);
	}
}
