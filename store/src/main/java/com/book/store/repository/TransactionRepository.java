package com.book.store.repository;

import com.book.store.model.GiaoDich;
import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.ChiTietDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<GiaoDich, Long>{
    @Query(value ="SELECT nd from NguoiDung nd WHERE nd.idNguoiDung = :id")
    NguoiDung getChiTietKhachHangInterface(@Param("id")long id);

    @Query(value ="SELECT dh.soLuong AS soLuong, sp.gia AS gia, sp.tenSanPham AS tenSanPham, gi.phanTramGiam  AS phanTramGiam, " +
            " gi.ngayBatDau AS ngayBatDau , gi.ngayKetThuc AS ngayKetThuc " +
            " FROM DonHang dh LEFT JOIN SanPham sp on dh.idSanPham = sp.idSanPham " +
            " LEFT JOIN GiamGia gi on  sp.idGiamGia = gi.idGiamGia " +
            " WHERE dh.trangThai = '0' AND dh.idNguoiGiaoDich = :id")
    List<ChiTietDonHang> getListChiTietDonHang(@Param("id")long id);
}
