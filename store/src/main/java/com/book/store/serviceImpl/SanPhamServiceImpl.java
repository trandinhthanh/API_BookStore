package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.*;

import com.book.store.model.DanhMucSanPham;
import com.book.store.model.GiamGia;
import com.book.store.model.HinhAnh;
import com.book.store.model.SanPham;
import com.book.store.modelConvert.ListSanPhamOutput;
import com.book.store.modelConvert.SanPhamOutput;
import com.book.store.repository.DanhMucSPRepository;
import com.book.store.repository.GiamGiaRepository;
import com.book.store.repository.HinhAnhRepository;
import com.book.store.repository.SanPhamRepository;
import com.book.store.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class SanPhamServiceImpl implements SanPhamService {
	@Autowired
	private SanPhamRepository sanPhamRepository;

	@Autowired
	private GiamGiaRepository giamGiaRepository;

	@Autowired
	private HinhAnhRepository hinhAnhRepository;

	@Autowired
	private DanhMucSPRepository danhMucSPRepository;
	
	@Override
	public List<SanPhamOutput> getAllSanPham() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<SanPham> listSanPham = sanPhamRepository.findAll(Sort.by(Sort.Direction.DESC, "idSanPham"));
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
		product.setNgayTao(LocalDate.now());
		return sanPhamRepository.save(product);
	}

	@Override
	public SanPham update(SanPham product) {
		Optional<SanPham> listSanPham = sanPhamRepository.findById(product.getIdSanPham());
		if (!listSanPham.isPresent()) {
			return null;
		}
		product.setNgayThayDoi(LocalDate.now());
		return sanPhamRepository.save(product);
	}

	@Override
	public boolean updateTrangThai(long idSanPham, String trangThai) {
		if (sanPhamRepository.updateTrangThaiByIdSanPham(idSanPham, trangThai) > 0) {
			return true;
		}
		return false;
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
		int pageSize = 8;
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

	@Override
	public List<SanPhamOutput> getListSanPhamGiamGia() {
		List<SanPhamOutput> outputs = new ArrayList<>();
		List<String> listIdGiamGia = giamGiaRepository.getListGiamGiaHoatDong();
		String idGiamGias = String.join("," , listIdGiamGia);
		List<SanPham> listSanPham = sanPhamRepository.getListSanPhamGiamGia(idGiamGias);
		for (SanPham s: listSanPham) {
			outputs.add(convertToSanPhamOutput(s));
		}
		return outputs;
	}

	@Override
	public void updateLuotXemByIdSanPham(long idSanPham) {
		sanPhamRepository.updateLuotXemByIdSanPham(idSanPham);
	}

	@Override
	public List<SanPhamOutput> locSanPham(int idDanhMucSP, String loaiSapXep, int loaiTrangThai) {
		List<SanPhamOutput> outputs = new ArrayList<>();
		if(idDanhMucSP == 0){
			List<SanPham> listSanPham = sanPhamRepository.findAll();
			for (SanPham s: listSanPham) {
				outputs.add(convertToSanPhamOutput(s));
			}
		}else {
			List<SanPham> listSanPham = sanPhamRepository.getSanPhamTheoDanhMuc(idDanhMucSP);
			for (SanPham s: listSanPham) {
				outputs.add(convertToSanPhamOutput(s));
			}
		}
		if(!outputs.isEmpty()) {
			if (loaiSapXep.equals("cao")) {
				Collections.sort(outputs, new Comparator<SanPhamOutput>() {
					@Override
					public int compare(SanPhamOutput x, SanPhamOutput y) {
						return Double.compare(x.getGia(), y.getGia());
					}
				});

			} else if (loaiSapXep.equals("thap")) {
				Collections.sort(outputs, new Comparator<SanPhamOutput>() {
					@Override
					public int compare(SanPhamOutput x, SanPhamOutput y) {
						return Double.compare(y.getGia(),x.getGia());
					}
				});
			}
		}if(loaiTrangThai == 0){ // dang an
			outputs.removeIf(x -> !"0".equals(x.getTrangThai()));
		}else if(loaiTrangThai == 1){ // con hang
			outputs.removeIf(x -> !"1".equals(x.getTrangThai()) || x.getSoLuong() <= 0 );
		}else if(loaiTrangThai == 2){ // het hang
			outputs.removeIf(x -> !"1".equals(x.getTrangThai()) || x.getSoLuong() > 0 );
		}
		return outputs;
	}

	private SanPhamOutput convertToSanPhamOutput(SanPham sanPham){
		List<String> links = new ArrayList<>();
		SanPhamOutput sanPhamOutput = new SanPhamOutput();
		sanPhamOutput.setIdSanPham(sanPham.getIdSanPham());
		sanPhamOutput.setIdDanhMucSP(sanPham.getIdDanhMucSP());
		sanPhamOutput.setIdGiamGia(sanPham.getIdGiamGia());
		DanhMucSanPham danhMucSanPham = danhMucSPRepository.findId(sanPham.getIdDanhMucSP());
		sanPhamOutput.setTenDanhMucSP(danhMucSanPham.getTenDanhMuc());
		sanPhamOutput.setTenSanPham(sanPham.getTenSanPham());
		sanPhamOutput.setGiaGoc(sanPham.getGiaGoc());
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
		for (int i = 0; i < listHinhAnh.size(); i++) {
			HinhAnh hinhAnh = listHinhAnh.get(i);
			if(i == 0){
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
