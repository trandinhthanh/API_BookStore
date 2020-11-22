package com.book.store.serviceImpl;

import com.book.store.model.GiamGia;
import com.book.store.repository.GiamGiaRepository;
import com.book.store.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GiamGiaServiceImpl implements GiamGiaService {
    @Autowired
    GiamGiaRepository giamGiaRepository;

    @Override
    public List<GiamGia> getGiamGiaHoatDong() {
        return giamGiaRepository.getGiamGiaHoatDong();
    }

    @Override
    public List<GiamGia> getAllGiamGia() {
        return giamGiaRepository.findAll();
    }

    @Override
    public GiamGia getGiamGiaById(long idGiamGia) {
        return giamGiaRepository.findById(idGiamGia).get();
    }

    @Override
    public GiamGia create(GiamGia giamGia) {
        if(giamGiaRepository.findById(giamGia.getIdGiamGia()) == null){
            return giamGiaRepository.save(giamGia);
        }
        return null;
    }

    @Override
    public GiamGia update(GiamGia giamGia) {
        if(giamGiaRepository.findById(giamGia.getIdGiamGia()) != null){
            return giamGiaRepository.save(giamGia);
        }
        return null;
    }

    @Override
    public boolean delete(long idGiamGia) {
        if(giamGiaRepository.findById(idGiamGia) == null){
            return false;
        }
        giamGiaRepository.deleteById(idGiamGia);
        return true;
    }
}
