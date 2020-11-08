package com.book.store.serviceImpl;

import java.time.LocalDate;
import java.util.*;

import com.book.store.model.GiaoDich;
import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.ChiTietDonHang;
import com.book.store.modelConvert.ChiTietDonHangOutput;
import com.book.store.modelConvert.SanPhamThanhTien;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public List<GiaoDich> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public GiaoDich createTransaction(GiaoDich giaoDich) {
		
		return transactionRepository.save(giaoDich);
	}

	@Override
	public GiaoDich Update(GiaoDich giaoDich) {
		
		return transactionRepository.save(giaoDich);
	}

	@Override
	public void deleteTransactionById(long id) {
		
		transactionRepository.deleteById(id);
	}

	@Override
	public Optional<GiaoDich> findById(long id) {
		return transactionRepository.findById(id);
	}

	@Override
	public ChiTietDonHangOutput chiTietNguoiDung(long id) {
		NguoiDung nguoiDung = transactionRepository.getChiTietKhachHangInterface(id);
		List<ChiTietDonHang> chiTietDonHang = transactionRepository.getListChiTietDonHang(id);

		ChiTietDonHangOutput output = new ChiTietDonHangOutput();
		output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		output.setDiaChi(nguoiDung.getDiaChi());
		output.setEmail(nguoiDung.getEmail());
		output.setSoDienThoai(nguoiDung.getSoDienThoai());

		List<SanPhamThanhTien> sanPhamThanhTiens = new ArrayList<>();

		Double thanhTien 		   = 0.0;
		Double tong				   = 0.0;
		LocalDate toDay            = LocalDate.now();
		for (ChiTietDonHang donHang: chiTietDonHang) {

			if ((donHang.getNgayBatDau() != null && donHang.getNgayBatDau().compareTo(toDay) > 0) &&
					(donHang.getNgayKetThuc() !=  null && donHang.getNgayKetThuc().compareTo(toDay) <0)
					&&  donHang.getPhanTramGiam() != 0) {
				int giamGia = donHang.getPhanTramGiam();
				thanhTien = (donHang.getSoLuong() * donHang.getGia()) * (donHang.getPhanTramGiam() / 100);
			} else {
				thanhTien = (donHang.getSoLuong() * donHang.getGia());
			}
			SanPhamThanhTien sanPhamThanhTien = new SanPhamThanhTien();
			sanPhamThanhTien.setTenSanPham(donHang.getTenSanPham());
			sanPhamThanhTien.setGia(thanhTien);
			sanPhamThanhTiens.add(sanPhamThanhTien);

			tong += thanhTien;
		}
		output.setSanPhamThanhTiens(sanPhamThanhTiens);
		output.setTongCong(tong);

		return output;
	}
}
