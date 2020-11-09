package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.NguoiDungInput;
import com.book.store.modelConvert.NguoiDungOutput;
import com.book.store.repository.NguoiDungRepository;
import com.book.store.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Override
	public NguoiDung createNguoiDung(NguoiDung nguoiDung) {
		nguoiDung.setNgayTao(LocalDate.now());
		return nguoiDungRepository.save(nguoiDung);
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
		return output;
	}

	@Override
	public NguoiDung kiemTraDangNhap(String email, String matKhau) {
		NguoiDung nguoiDung = nguoiDungRepository.kiemTraDangNhap(email, matKhau);
		if(nguoiDung != null){
			nguoiDung.setMatKhau(null);
			return nguoiDung;
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
	public List<NguoiDung> getAllNguoiDung() {
		return nguoiDungRepository.findAll();
	}

}
