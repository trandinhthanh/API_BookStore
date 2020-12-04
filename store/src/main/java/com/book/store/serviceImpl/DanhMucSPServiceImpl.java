package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DanhMucSanPham;
import com.book.store.repository.DanhMucSPRepository;
import com.book.store.service.DanhMucSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class DanhMucSPServiceImpl implements DanhMucSPService {

	@Autowired
	private DanhMucSPRepository danhMucSPRepository;

	@Override
	public List<DanhMucSanPham> getAllDanhMucSanPham() {
		return danhMucSPRepository.findAll();
	}

	@Override
	public List<DanhMucSanPham> getDanhMucSPHoatDong() {
		return danhMucSPRepository.getDanhMucSPHoatDong();
	}

	@Override
	public DanhMucSanPham createDanhMucSanPham(DanhMucSanPham danhMucSp) {
		return danhMucSPRepository.save(danhMucSp);
	}

	@Override
	public DanhMucSanPham update(DanhMucSanPham danhMucSp) {
		DanhMucSanPham listDanhMucSanPham = danhMucSPRepository.findId(danhMucSp.getIdDanhMucSP());
		if (listDanhMucSanPham == null || danhMucSPRepository.findByTenDanhMucContainingIgnoreCase(danhMucSp.getTenDanhMuc()).size() > 0) {
			return null;
		}
		return danhMucSPRepository.save(danhMucSp);
	}

	@Override
	public Optional<DanhMucSanPham> findById(long id) {
		return danhMucSPRepository.findById(id);
	}

	@Override
	public DanhMucSanPham findDanhMucSanPham(long id) {
		return danhMucSPRepository.findId(id);
	}

	@Override
	public boolean updateTrangThaiById(long idDanhMucSP, String trangThai) {
		if(danhMucSPRepository.updateTrangThaiById(idDanhMucSP, trangThai) > 0 ){
			return true;
		}
		return false;
	}

	@Override
	public List<DanhMucSanPham> findByTenDanhMuc(String tenDanhMuc) {
		return danhMucSPRepository.findByTenDanhMucContainingIgnoreCase(tenDanhMuc);
	}

}
