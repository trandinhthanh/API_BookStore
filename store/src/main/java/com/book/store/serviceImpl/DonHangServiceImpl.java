package com.book.store.serviceImpl;

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
	public DonHang createDonHang(DonHang DonHang) {
		
		return donHangRepository.save(DonHang);
	}

	@Override
	public DonHang update(DonHang DonHang) {
		
		return donHangRepository.save(DonHang);
	}

	@Override
	public void deleteDonHangById(long id) {
		
		donHangRepository.deleteById(id);
	}

	@Override
	public Optional<DonHang> findById(long id) {
		
		return donHangRepository.findById(id);
	}
}
