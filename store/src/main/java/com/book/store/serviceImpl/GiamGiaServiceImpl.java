package com.book.store.serviceImpl;

import com.book.store.model.GiamGia;
import com.book.store.repository.GiamGiaRepository;
import com.book.store.repository.SanPhamRepository;
import com.book.store.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class GiamGiaServiceImpl implements GiamGiaService {
    @Autowired
    GiamGiaRepository giamGiaRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<GiamGia> getGiamGiaHoatDong() {
        return giamGiaRepository.getGiamGiaHoatDong();
    }

    @Override
    public List<GiamGia> getAllGiamGia() {
        List<GiamGia> output = new ArrayList<>();
        for (GiamGia giamGia: giamGiaRepository.findAll()){
            giamGia.setTrangThai(kiemTraTrangThai(giamGia));
            output.add(giamGia);
        }
        return output;
    }

    @Override
    public GiamGia getGiamGiaById(long idGiamGia) {
        GiamGia giamGia = giamGiaRepository.findById(idGiamGia).get();
        giamGia.setTrangThai(kiemTraTrangThai(giamGia));
        return giamGia;
    }

    @Override
    public GiamGia create(GiamGia giamGia) {
        List<GiamGia> listGiamGias = giamGiaRepository.findAll();
        for( GiamGia g : listGiamGias) {
            if(g.getTenGiamGia().equals(giamGia.getTenGiamGia())) {
                return null;
            }
        }
        giamGia.setNgayTao(LocalDate.now());
        return giamGiaRepository.save(giamGia);
    }

    @Override
    public GiamGia update(GiamGia giamGia) {
        GiamGia getGiamGia = giamGiaRepository.findById(giamGia.getIdGiamGia()).get();
        if( getGiamGia != null){
            giamGia.setNguoiTao(getGiamGia.getNguoiTao());
            giamGia.setNgayTao(getGiamGia.getNgayTao());
            giamGia.setNgayThayDoi(LocalDate.now());
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
        sanPhamRepository.updateIdGiamGia(idGiamGia);
        return true;
    }

    @Override
    public List<GiamGia> findByTrangThai(String trangThai) {
        return giamGiaRepository.findByTrangThaiContainingIgnoreCase(trangThai);
    }

    @Override
    public List<GiamGia> findByTenGiamGia(String tenGiamGia) {
        return giamGiaRepository.findByTenGiamGiaContainingIgnoreCase(tenGiamGia);
    }

    private String kiemTraTrangThai(GiamGia giamGia){
        if(giamGia.getNgayBatDau().isEqual(LocalDate.now()) || giamGia.getNgayKetThuc().isEqual(LocalDate.now()) || giamGia.getNgayBatDau().isBefore(LocalDate.now()) && (giamGia.getNgayKetThuc().isAfter(LocalDate.now()))){
            return "Đang hoạt động";
        }
        return "Kết thúc";
    }
}
