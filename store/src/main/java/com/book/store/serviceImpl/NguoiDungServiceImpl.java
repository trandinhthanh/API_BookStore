package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.NguoiDung;
import com.book.store.repository.NguoiDungRepository;
import com.book.store.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepository;
	
	@Override
	public NguoiDung createNguoiDung(NguoiDung nguoiDung) {
		return nguoiDungRepository.save(nguoiDung);
	}

	@Override
	public void deleteNguoiDungById(long id) {
		nguoiDungRepository.deleteById(id);
	}

	@Override
	public NguoiDung update(NguoiDung nguoiDung) {
		return nguoiDungRepository.save(nguoiDung);
	}
	
	@Override
	public Optional<NguoiDung> findById(long id) {
		
		return nguoiDungRepository.findById(id);
	}
	
	@Override
	public List<NguoiDung> getAllNguoiDung() {
		return nguoiDungRepository.findAll();
	}
	
}
