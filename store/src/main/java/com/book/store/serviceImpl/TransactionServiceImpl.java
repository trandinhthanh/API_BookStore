package com.book.store.serviceImpl;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import com.book.store.config.MailConfig;
import com.book.store.config.SpringMailConfig;
import com.book.store.model.GiaoDich;
import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.*;
import com.book.store.repository.DonHangRepository;
import com.book.store.repository.SanPhamRepository;
import com.book.store.repository.TransactionRepository;
import com.book.store.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	DonHangRepository donHangRepository;

	@Autowired
	SanPhamRepository sanPhamRepository;


	private MailConfig mailConfig = new MailConfig();

	private SpringMailConfig springMailConfig = new SpringMailConfig();
	
	@Override
	public List<ChiTietDonHangOutput> getAllTransaction() {
		List<GiaoDich> giaoDichList = transactionRepository.findAll();
		return convertToChiTietDonHangOutput(giaoDichList);
	}

	@Override
	public boolean createTransaction(GiaoDich giaoDich) {
		LocalDate toDay = LocalDate.now();
		try {
				giaoDich.setTrangThai("0");
				giaoDich.setNgayTao(LocalDate.now());
				GiaoDich giaoDichOutput = transactionRepository.save(giaoDich);
				sendMailDonHang(giaoDichOutput);
			List<ChiTietDonHang> chiTietDonHang = transactionRepository.getListChiTietDonHang(giaoDich.getIdKhachHang());
			for (ChiTietDonHang donHang: chiTietDonHang) {
				double thanhTien = 0;
				LocalDate ngayBatDau = donHang.getNgayBatDau();
				LocalDate ngayKetThuc = donHang.getNgayKetThuc();
				if ((ngayBatDau != null && ngayBatDau.compareTo(toDay) < 0) &&
						(ngayKetThuc !=  null && ngayKetThuc.compareTo(toDay) > 0)
						&&  donHang.getPhanTramGiam() != 0) {
					double phatramGiam = 100 - donHang.getPhanTramGiam();
					thanhTien = (donHang.getSoLuong() * donHang.getGia()) * (phatramGiam / 100);
				} else {
					thanhTien = (donHang.getSoLuong() * donHang.getGia());
				}
				long idDonHang = donHang.getIdDonHang();
				donHangRepository.updateByIdDoHang(idDonHang, giaoDichOutput.getIdGiaoDich(), thanhTien);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTrangThai(long idGiaoDich, String trangThai) {
		if(transactionRepository.updateByTrangThai(idGiaoDich, trangThai) > 0){
			return true;
		}
		return false;
	}


	@Override
	public ChiTietDonHangOutput findById(long id) {
		ChiTietDonHangOutput output = new ChiTietDonHangOutput();
		GiaoDich gd = transactionRepository.findById(id).get();
		output.setIdGiaoDich(gd.getIdGiaoDich());
		output.setTenNguoiDung(gd.getTenKhachHang());
		output.setEmail(gd.getEmail());
		output.setDiaChi(gd.getDiaChiGiaoHang());
		output.setSoDienThoai(gd.getSoDienThoai());
		output.setTongCong(gd.getSoTien());
		output.setTrangThai(gd.getTrangThai());
		output.setNgayMua(gd.getNgayTao());
		output.setGhiChu(gd.getGhiChu());
		List<SanPhamByDonHang> sanPhamByDonHangs = donHangRepository.findByIdGiaoDich(gd.getIdGiaoDich());
		List<SanPhamThanhTien> sanPhamThanhTienList = new ArrayList<>();
		for (SanPhamByDonHang sp:sanPhamByDonHangs) {
			SanPhamThanhTien sanPhamThanhTien = new SanPhamThanhTien();
			sanPhamThanhTien.setTenSanPham(sp.getTenSanPham());
			sanPhamThanhTien.setSoLuong(sp.getSoLuong());
			sanPhamThanhTien.setGia(sp.getTien());
			sanPhamThanhTienList.add(sanPhamThanhTien);
		}
		output.setSanPhamThanhTiens(sanPhamThanhTienList);
		return output;
	}

	@Override
	public ChiTietDonHangOutput chiTietNguoiDung(long idNguoiGiaoDich) {
		NguoiDung nguoiDung = transactionRepository.getChiTietKhachHangInterface(idNguoiGiaoDich);
		List<ChiTietDonHang> chiTietDonHang = transactionRepository.getListChiTietDonHang(idNguoiGiaoDich);
		ChiTietDonHangOutput output = new ChiTietDonHangOutput();
		output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		output.setDiaChi(nguoiDung.getDiaChi());
		output.setEmail(nguoiDung.getEmail());
		output.setSoDienThoai(nguoiDung.getSoDienThoai());

		List<SanPhamThanhTien> sanPhamThanhTiens = new ArrayList<>();

		double tong = 0;
		LocalDate toDay = LocalDate.now();
		for (ChiTietDonHang donHang: chiTietDonHang) {
			double thanhTien = 0;
			LocalDate ngayBatDau = donHang.getNgayBatDau();
			LocalDate ngayKetThuc = donHang.getNgayKetThuc();
			if ((ngayBatDau != null && ngayBatDau.compareTo(toDay) < 0) &&
					(ngayKetThuc !=  null && ngayKetThuc.compareTo(toDay) > 0)
					&&  donHang.getPhanTramGiam() != 0) {
				double phatramGiam = 100 - donHang.getPhanTramGiam();
				thanhTien = (donHang.getSoLuong() * donHang.getGia()) * (phatramGiam / 100);
			} else {
				thanhTien = (donHang.getSoLuong() * donHang.getGia());
			}
			SanPhamThanhTien sanPhamThanhTien = new SanPhamThanhTien();
			sanPhamThanhTien.setTenSanPham(donHang.getTenSanPham());
			sanPhamThanhTien.setGia(thanhTien);
			sanPhamThanhTien.setSoLuong(donHang.getSoLuong());
			sanPhamThanhTiens.add(sanPhamThanhTien);

			tong += thanhTien;
		}
		output.setSanPhamThanhTiens(sanPhamThanhTiens);
		output.setTongCong(tong);

		return output;
	}

	@Override
	public List<ChiTietDonHangOutput> getTransactionByDate(LocalDate fromDate, LocalDate toDate) {
		List<GiaoDich> giaoDichList = transactionRepository.getTransactionByDate(fromDate, toDate);
		return convertToChiTietDonHangOutput(giaoDichList);
	}

	@Override
	public List<ChiTietDonHangOutput> findByTenKhachHang(String tenKhachHang) {
		List<GiaoDich> giaoDichList = transactionRepository.findByTenKhachHangContainingIgnoreCase(tenKhachHang);
		return convertToChiTietDonHangOutput(giaoDichList);
	}

	@Override
	public List<GiaoDich> findByIdKhachHang(long idKhachHang) {
		return transactionRepository.findByIdKhachHang(idKhachHang);
	}

	@Override
	public boolean checkTonKho(long idKhachHang) {
		if(transactionRepository.countGiaoDichAccept(idKhachHang) == donHangRepository.findByIdNguoiGiaoDich(idKhachHang).size()){
			return true;
		}
		return false;
	}

	private List<ChiTietDonHangOutput> convertToChiTietDonHangOutput(List<GiaoDich> giaoDichList){
		List<ChiTietDonHangOutput> outputList = new ArrayList<>();
		for (GiaoDich gd : giaoDichList) {
			ChiTietDonHangOutput output = new ChiTietDonHangOutput();
			output.setIdGiaoDich(gd.getIdGiaoDich());
			output.setTenNguoiDung(gd.getTenKhachHang());
			output.setEmail(gd.getEmail());
			output.setDiaChi(gd.getDiaChiGiaoHang());
			output.setSoDienThoai(gd.getSoDienThoai());
			output.setTongCong(gd.getSoTien());
			output.setTrangThai(gd.getTrangThai());
			output.setNgayMua(gd.getNgayTao());
			List<SanPhamByDonHang> sanPhamByDonHangs = donHangRepository.findByIdGiaoDich(gd.getIdGiaoDich());
			List<SanPhamThanhTien> sanPhamThanhTienList = new ArrayList<>();
			for (SanPhamByDonHang sp:sanPhamByDonHangs) {
				SanPhamThanhTien sanPhamThanhTien = new SanPhamThanhTien();
				sanPhamThanhTien.setTenSanPham(sp.getTenSanPham());
				sanPhamThanhTien.setSoLuong(sp.getSoLuong());
				sanPhamThanhTien.setGia(sp.getTien());
				sanPhamThanhTienList.add(sanPhamThanhTien);
			}
			output.setSanPhamThanhTiens(sanPhamThanhTienList);
			outputList.add(output);
		}
		return outputList;
	}

	private void  sendMailDonHang(GiaoDich giaoDich)throws MessagingException {
        final Locale locale = Locale.getDefault();

        // Prepare the evaluation context
        final Context ctx = new Context(locale);
        ctx.setVariable("giaoDich", giaoDich);
		ctx.setVariable("soTien", formatMoney(giaoDich.getSoTien()));
		ctx.setVariable("sanPhams", getDongHangByIdNguoiDung(giaoDich.getIdKhachHang()));

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailConfig.getJavaMailSender().createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8"); // true = multipart
        message.setSubject("Thông tin đơn hàng #" + giaoDich.getIdGiaoDich() + " tại BookStore");
        message.setTo(giaoDich.getEmail());

        // Create the HTML body using Thymeleaf
		// doc html va do du lieu
        final String htmlContent = this.springMailConfig.emailTemplateEngine().process("sendEmailOrder", ctx);
        message.setText(htmlContent, true); // true = isHtml

        // Send mail
        this.mailConfig.getJavaMailSender().send(mimeMessage);
    }

    private List<DonHangOutput> getDongHangByIdNguoiDung(long idNguoiDung){
		LocalDate toDay = LocalDate.now();
		List<DonHangOutput> outputs = new ArrayList<>();
		List<ChiTietDonHang> chiTietDonHang = transactionRepository.getListChiTietDonHang(idNguoiDung);
		for (ChiTietDonHang donHang: chiTietDonHang) {
			double thanhTien = 0;
			DonHangOutput donHangOutput = new DonHangOutput();

			//giảm sl nếu đã mua thành công
			long idSP = donHang.getIdSanPham();
			int sl = donHang.getSoLuong();
			sanPhamRepository.updateSoLuongByIdSanPham(idSP, sl);
			donHangOutput.setTenSanPham(donHang.getTenSanPham());
			donHangOutput.setSoLuong(donHang.getSoLuong());
			if ((donHang.getNgayBatDau() != null && donHang.getNgayBatDau().compareTo(toDay) < 0) &&
					(donHang.getNgayKetThuc() !=  null && donHang.getNgayKetThuc().compareTo(toDay) > 0)
					&&  donHang.getPhanTramGiam() != 0) {
				double phatramGiam = 100 - donHang.getPhanTramGiam();
				thanhTien = (donHang.getSoLuong() * donHang.getGia()) * (phatramGiam / 100);
				donHangOutput.setThanhTien(formatMoney(thanhTien));
			} else {
				thanhTien = (donHang.getSoLuong() * donHang.getGia());
				donHangOutput.setThanhTien(formatMoney(thanhTien));
			}
			outputs.add(donHangOutput);
		}
		return outputs;
	}

    private String formatMoney(double tien){
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		return formatter.format(tien) +"đ";
	}
}
