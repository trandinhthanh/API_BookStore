package com.book.store.serviceImpl;

import com.book.store.model.DoanhSo;
import com.book.store.repository.NguoiDungRepository;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.DoanhSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Service
public class DoanhSoServiceImpl implements DoanhSoService {
    @Autowired
    NguoiDungRepository nguoiDungRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public DoanhSo getDoanhSo(LocalDate fromDate, LocalDate toDate) {
        DoanhSo doanhSo = new DoanhSo();
        if(fromDate == null && toDate == null){
            doanhSo.setTongSoTaiKhoan(nguoiDungRepository.countUser());
            doanhSo.setTongDonHang(transactionRepository.countGiaoDich());
            doanhSo.setTongTienLoi(transactionRepository.sumTienLoi());
            doanhSo.setTongTienThuVe(transactionRepository.sumTienThuVe());
        }else {
            doanhSo.setTongSoTaiKhoan(nguoiDungRepository.countUserByDate(fromDate, toDate));
            doanhSo.setTongDonHang(transactionRepository.countGiaoDichByDate(fromDate, toDate));
            doanhSo.setTongTienLoi(transactionRepository.sumTienLoiByDate(fromDate, toDate));
            doanhSo.setTongTienThuVe(transactionRepository.sumTienThuVeByDate(fromDate, toDate));
        }
        return doanhSo;
    }
}
