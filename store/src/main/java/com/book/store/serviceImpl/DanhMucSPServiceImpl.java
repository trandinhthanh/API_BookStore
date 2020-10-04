package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.DanhMucSanPham;
import com.book.store.repository.DanhMucSPRepository;
import com.book.store.service.DanhMucSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DanhMucSPServiceImpl implements DanhMucSPService {

	@Autowired
	private DanhMucSPRepository danhMucSPRepository;
	@Override
	public List<DanhMucSanPham> getAllDanhMucSanPham() {
		return danhMucSPRepository.findAll();
	}

	@Override
	public DanhMucSanPham createDanhMucSanPham(DanhMucSanPham danhMucSp) {
		return danhMucSPRepository.save(danhMucSp);
	}

	@Override
	public DanhMucSanPham update(DanhMucSanPham danhMucSp) {
		return danhMucSPRepository.save(danhMucSp);
	}

	@Override
	public void deleteDanhMucSanPhamById(long id) {
		danhMucSPRepository.deleteById(id);
	}

	@Override
	public Optional<DanhMucSanPham> findById(long id) {
		return danhMucSPRepository.findById(id);
	}

	@Override
	public List<DanhMucSanPham> findDanhMucSanPham(long id) {
		return danhMucSPRepository.findId(id);
	}

}
