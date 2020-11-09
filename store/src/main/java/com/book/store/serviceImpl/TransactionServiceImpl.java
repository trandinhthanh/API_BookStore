package com.book.store.serviceImpl;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import com.book.store.config.MailConfig;
import com.book.store.config.SpringMailConfig;
import com.book.store.model.GiaoDich;
import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.ChiTietDonHang;
import com.book.store.modelConvert.ChiTietDonHangOutput;
import com.book.store.modelConvert.DonHangOutput;
import com.book.store.modelConvert.SanPhamThanhTien;
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
	public List<GiaoDich> getAllTransaction() {
		
		return transactionRepository.findAll();
	}

	@Override
	public boolean createTransaction(GiaoDich giaoDich) {
		try {
				giaoDich.setTrangThai("0");
				giaoDich.setNgayTao(LocalDate.now());
				GiaoDich giaoDichOutput = transactionRepository.save(giaoDich);
				sendMailDonHang(giaoDichOutput);
				donHangRepository.updateByIdNguoiGiaoDich(giaoDich.getIdKhachHang());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
	public ChiTietDonHangOutput chiTietNguoiDung(long idNguoiGiaoDich) {
		NguoiDung nguoiDung = transactionRepository.getChiTietKhachHangInterface(idNguoiGiaoDich);
		List<ChiTietDonHang> chiTietDonHang = transactionRepository.getListChiTietDonHang(idNguoiGiaoDich);

		ChiTietDonHangOutput output = new ChiTietDonHangOutput();
		output.setTenNguoiDung(nguoiDung.getTenNguoiDung());
		output.setDiaChi(nguoiDung.getDiaChi());
		output.setEmail(nguoiDung.getEmail());
		output.setSoDienThoai(nguoiDung.getSoDienThoai());

		List<SanPhamThanhTien> sanPhamThanhTiens = new ArrayList<>();

		double thanhTien = 0;
		double tong = 0;
		LocalDate toDay = LocalDate.now();
		for (ChiTietDonHang donHang: chiTietDonHang) {

			if ((donHang.getNgayBatDau() != null && donHang.getNgayBatDau().compareTo(toDay) > 0) &&
					(donHang.getNgayKetThuc() !=  null && donHang.getNgayKetThuc().compareTo(toDay) <0)
					&&  donHang.getPhanTramGiam() != 0) {
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
			sanPhamRepository.updateSoLuongByIdSanPham(donHang.getIdSanPham(), donHang.getSoLuong());
			donHangOutput.setTenSanPham(donHang.getTenSanPham());
			donHangOutput.setSoLuong(donHang.getSoLuong());
			if ((donHang.getNgayBatDau() != null && donHang.getNgayBatDau().compareTo(toDay) > 0) &&
					(donHang.getNgayKetThuc() !=  null && donHang.getNgayKetThuc().compareTo(toDay) <0)
					&&  donHang.getPhanTramGiam() != 0) {
				thanhTien = (donHang.getSoLuong() * donHang.getGia()) * (donHang.getPhanTramGiam() / 100);
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
		return formatter.format(tien) +" đ";
	}
}
