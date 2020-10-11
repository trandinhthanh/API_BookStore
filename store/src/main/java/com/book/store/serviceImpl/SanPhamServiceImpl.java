package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.book.store.model.GiamGia;
import com.book.store.model.HinhAnh;
import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;
import com.book.store.repository.GiamGiaRepository;
import com.book.store.repository.HinhAnhRepository;
import com.book.store.repository.SanPhamRepository;
import com.book.store.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Autowired
	private GiamGiaRepository giamGiaRepository;

	@Autowired
	private HinhAnhRepository hinhAnhRepository;
	
	@Override
	public List<SanPhamOutput> getAllSanPham() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.findAll();
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}

	@Override
	public SanPham createSanPham(SanPham product) {
		List<SanPham> listSanPhams = sanPhamRepository.findAll();
		for( SanPham products : listSanPhams) {
			if(product.getTenSanPham().equals(products.getTenSanPham())) {
				return null;
			}
		}
		return sanPhamRepository.save(product);
	}

	@Override
	public SanPham update(SanPham product) {
		Optional<SanPham> listSanPham = sanPhamRepository.findById(product.getIdSanPham());
		if (!listSanPham.isPresent()) {
			return null;
		}
		return sanPhamRepository.save(product);
	}

	@Override
	public boolean deleteSanPhamById(long id) {
		Optional<SanPham> listSanPham = sanPhamRepository.findById(id);
		if (!listSanPham.isPresent()) {
			return false;
		}
		try {
			sanPhamRepository.deleteById(id);
		}catch (Exception e){
			return false;
		}
		return true;
	}

	@Override
	public SanPhamOutput findById(long id) {
		return convertToSanPhamOutput(sanPhamRepository.findById(id).get());
	}

	@Override
	public List<SanPhamOutput> getSanPhamTheoDanhMuc(int idDanhMucSP ) {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.getSanPhamTheoDanhMuc(idDanhMucSP);
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}
	
	@Override
	public List<SanPhamOutput> sanPhamNoiBat() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.sanPhamNoiBat();
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}
	@Override
	public List<SanPhamOutput> sanPhamLienQuan(int idDanhMucSP ) {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.sanPhamLienQuan(idDanhMucSP);
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}

	@Override
	public List<SanPhamOutput> getNameSanPham() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.getTenSanPham();
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}
	@Override
	public List<SanPhamOutput> getSanPhamVoiSoLuong() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.getSanPhamVoiSoLuong();
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}

	@Override
	public ListSanPhamOutput getSanPhamTheoPage(String linkDanhMuc, int numberPage){
		ListSanPhamOutput listSanPhamOutput = new ListSanPhamOutput();
		int pageSize = 12;
		List<SanPhamOutput> outputs = new ArrayList<>();
		Page<SanPham> pageSanPham = sanPhamRepository.findByIdDanhMucSP( linkDanhMuc, PageRequest.of(numberPage - 1, pageSize));
		for (SanPham s: pageSanPham.getContent()) {
			outputs.add(convertToSanPhamOutput(s));
		}
		listSanPhamOutput.setSanPhamOutputs(outputs);
		listSanPhamOutput.setTotalPages(pageSanPham.getTotalPages());
		return listSanPhamOutput;
	}

	@Override
	public List<SanPhamOutput> findByTenSanPham(String tenSanPham){
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.findByTenSanPhamContainingIgnoreCase(tenSanPham);
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}

	private SanPhamOutput convertToSanPhamOutput(SanPham sanPham){
		List<String> links = new ArrayList<>();
		SanPhamOutput sanPhamOutput = new SanPhamOutput();
		sanPhamOutput.setIdSanPham(sanPham.getIdSanPham());
		sanPhamOutput.setIdDanhMucSP(sanPham.getIdDanhMucSP());
		sanPhamOutput.setTenSanPham(sanPham.getTenSanPham());
		sanPhamOutput.setGia(sanPham.getGia());
		sanPhamOutput.setMoTa(sanPham.getMoTa());
		sanPhamOutput.setTacGia(sanPham.getTacGia());
		sanPhamOutput.setNhaXuatBan(sanPham.getNhaXuatBan());
		if(sanPham.getIdGiamGia() > 0) {
			GiamGia giamGia = giamGiaRepository.findById((long) sanPham.getIdGiamGia()).get();
			if(giamGia.getNgayBatDau().isEqual(LocalDate.now()) || giamGia.getNgayKetThuc().isEqual(LocalDate.now()) || giamGia.getNgayBatDau().isBefore(LocalDate.now()) && (giamGia.getNgayKetThuc().isAfter(LocalDate.now()))){
				sanPhamOutput.setGiamGia(giamGia.getPhanTramGiam());
			}
		}
		List<HinhAnh> listHinhAnh = hinhAnhRepository.getHinhAnhByIdSanPham(sanPham.getIdSanPham());
		for (HinhAnh hinhAnh: listHinhAnh) {
			if(hinhAnh.getSapXep() == 1){
				sanPhamOutput.setLinkHinhChinh(hinhAnh.getLink());
				links.add(hinhAnh.getLink());
			}else {
				links.add(hinhAnh.getLink());
			}
		}
		sanPhamOutput.setDanhSachLinkHinh(links);
		sanPhamOutput.setLuotThich(sanPham.getLuotThich());
		sanPhamOutput.setLuotXem(sanPham.getLuotXem());
		sanPhamOutput.setSoLuong(sanPham.getSoLuong());
		sanPhamOutput.setTrangThai(sanPham.getTrangThai());
		sanPhamOutput.setNgayTao(sanPham.getNgayTao());
		sanPhamOutput.setNguoiTao(sanPham.getNguoiTao());
		sanPhamOutput.setNgayThayDoi(sanPham.getNgayThayDoi());
		sanPhamOutput.setNguoiThayDoi(sanPham.getNguoiThayDoi());
		return sanPhamOutput;
	}
	
}
