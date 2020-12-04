package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.NguoiDungConvert;
import com.book.store.modelConvert.NguoiDungInput;
import com.book.store.modelConvert.NguoiDungOutput;
import com.book.store.repository.NguoiDungRepository;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public boolean createNguoiDung(NguoiDung nguoiDung) {
		nguoiDung.setNgayTao(LocalDate.now());
		List<NguoiDung> listNguoiDung = nguoiDungRepository.findAll();
		for( NguoiDung nd : listNguoiDung){
			if(nguoiDung.getEmail().equals(nd.getEmail())) {
				return false;
			}
		}
		nguoiDungRepository.save(nguoiDung);
		return true;
	}

	@Override
	public boolean deleteNguoiDungById(long id) {
		Optional<NguoiDung> listNguoiDung = nguoiDungRepository.findById(id);
		if (!listNguoiDung.isPresent()) {
			return false;
		}
		nguoiDungRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean update(NguoiDung nguoiDung) {
		Optional<NguoiDung> listNguoiDung = nguoiDungRepository.findById(nguoiDung.getIdNguoiDung());
		if (!listNguoiDung.isPresent()) {
			return false;
		}
		nguoiDungRepository.save(nguoiDung);
		return true;
	}
	
	@Override
	public NguoiDungOutput findById(long id) {
		NguoiDungOutput output = new NguoiDungOutput();
		NguoiDung nguoiDung = nguoiDungRepository.findById(id).get();
		output.setIdNguoiDung(nguoiDung.getIdNguoiDung());
		output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		output.setDiaChi(nguoiDung.getDiaChi());
		output.setEmail(nguoiDung.getEmail());
		output.setSoDienThoai(nguoiDung.getSoDienThoai());
		output.setTrangThai(nguoiDung.getTrangThai());
		return output;
	}

	@Override
	public NguoiDungOutput kiemTraDangNhap(String email, String matKhau) {
		NguoiDung nguoiDung = nguoiDungRepository.kiemTraDangNhap(email, matKhau);
		if(nguoiDung != null && !nguoiDung.isLaQuanLy() && nguoiDung.getTrangThai().equals("1")){
			NguoiDungOutput output = new NguoiDungOutput();
			output.setIdNguoiDung(nguoiDung.getIdNguoiDung());
			output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
			output.setDiaChi(nguoiDung.getDiaChi());
			output.setEmail(nguoiDung.getEmail());
			output.setSoDienThoai(nguoiDung.getSoDienThoai());
			return output;
		}
		return null;
	}

	@Override
	public NguoiDungOutput kiemTraDangNhapAdmin(String email, String matKhau) {
		NguoiDung nguoiDung = nguoiDungRepository.kiemTraDangNhap(email, matKhau);
		if(nguoiDung != null && nguoiDung.isLaQuanLy()){
			NguoiDungOutput output = new NguoiDungOutput();
			output.setIdNguoiDung(nguoiDung.getIdNguoiDung());
			output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
			output.setDiaChi(nguoiDung.getDiaChi());
			output.setEmail(nguoiDung.getEmail());
			output.setSoDienThoai(nguoiDung.getSoDienThoai());
			return output;
		}
		return null;
	}

	@Override
	public boolean editUserByUser(NguoiDungInput input) {
		NguoiDung nguoiDung = nguoiDungRepository.findById(input.getIdNguoiDung()).get();
		if(input.getMatKhauCu() == ""){
		}
		else if(nguoiDung.getMatKhau() == input.getMatKhauCu()) {
			nguoiDung.setMatKhau(input.getMatKhauMoi());
		}
		else {
			return false;
		}
		nguoiDung.setTenNguoiDung(input.getTenNguoiDung());
		nguoiDung.setSoDienThoai(input.getSoDienThoai());
		nguoiDung.setDiaChi(input.getDiaChi());
		nguoiDung.setEmail(input.getEmail());
		nguoiDungRepository.save(nguoiDung);
		return true;
	}

	@Override
	public boolean blockUser(long idNguoiDung, String trangThai) {
		if(nguoiDungRepository.blockUser(idNguoiDung, trangThai) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<NguoiDungConvert> locTaiKhoan(int laQuanLy) {
		List<NguoiDung> nguoiDungList = nguoiDungRepository.locTaiKhoan(laQuanLy);
		return convertToNguoiDungConvert(nguoiDungList);
	}

	@Override
	public List<NguoiDungConvert> findByTenNguoiDung(String tenNguoiDung) {
		List<NguoiDung> nguoiDungList = nguoiDungRepository.findByTenNguoiDungContainingIgnoreCase(tenNguoiDung);
		return convertToNguoiDungConvert(nguoiDungList);
	}

	@Override
	public List<NguoiDungConvert> getAllNguoiDung() {
		List<NguoiDung> nguoiDungList = nguoiDungRepository.findAll();
		return convertToNguoiDungConvert(nguoiDungList);
	}

	private List<NguoiDungConvert> convertToNguoiDungConvert(List<NguoiDung> nguoiDungList){
		List<NguoiDungConvert> outputList = new ArrayList<>();
		for (NguoiDung nguoiDung: nguoiDungList) {
			NguoiDungConvert output = new NguoiDungConvert();
			output.setIdNguoiDung(nguoiDung.getIdNguoiDung());
			output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
			output.setDiaChi(nguoiDung.getDiaChi());
			output.setEmail(nguoiDung.getEmail());
			output.setSoDienThoai(nguoiDung.getSoDienThoai());
			output.setLaQuanLy(nguoiDung.isLaQuanLy());
			output.setNgayTao(nguoiDung.getNgayTao());
			if(!nguoiDung.isLaQuanLy()){
				Integer soGiaoDichCancel = transactionRepository.getGiaoDichCancel(nguoiDung.getIdNguoiDung());
				if(nguoiDung.getTrangThai().equals("1")) {
					if (soGiaoDichCancel == null) {
						output.setTrangThai("Đang hoạt động");
					} else {
						output.setTrangThai("Không nhận - " + soGiaoDichCancel);
					}
				}else {
					output.setTrangThai("Đã khóa");
				}
			}else {
				if(nguoiDung.getTrangThai().equals("1")) {
					output.setTrangThai("Đang hoạt động");
				}
				else {
					output.setTrangThai("Đã khóa");
				}
			}
			outputList.add(output);
		}
		return outputList;
	}
}
