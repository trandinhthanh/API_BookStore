package com.book.store.repository;

import com.book.store.model.GiaoDich;
import com.book.store.model.NguoiDung;
import com.book.store.modelConvert.ChiTietDonHang;
import com.book.store.modelConvert.DoanhThuSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<GiaoDich, Long>{
    @Query(value ="SELECT nd from NguoiDung nd WHERE nd.idNguoiDung = :id")
    NguoiDung getChiTietKhachHangInterface(@Param("id")long id);

    @Query(value ="SELECT dh.idDonHang AS idDonHang, dh.idSanPham AS idSanPham, dh.soLuong AS soLuong, sp.gia AS gia, sp.tenSanPham AS tenSanPham, gi.phanTramGiam  AS phanTramGiam, " +
            " gi.ngayBatDau AS ngayBatDau , gi.ngayKetThuc AS ngayKetThuc " +
            " FROM DonHang dh LEFT JOIN SanPham sp on dh.idSanPham = sp.idSanPham " +
            " LEFT JOIN GiamGia gi on  sp.idGiamGia = gi.idGiamGia " +
            " WHERE dh.trangThai = '0' AND dh.idNguoiGiaoDich = :idNguoiGiaoDich")
    List<ChiTietDonHang> getListChiTietDonHang(@Param("idNguoiGiaoDich")long idNguoiGiaoDich);

    @Transactional
    @Modifying
    @Query(value ="UPDATE GiaoDich SET trangThai = :trangThai WHERE idGiaoDich = :idGiaoDich")
    Integer updateByTrangThai(@Param("idGiaoDich")long idGiaoDich, @Param("trangThai")String trangThai );

    @Query(value ="SELECT COUNT(g.idGiaoDich) FROM GiaoDich g WHERE g.idKhachHang = :idKhachHang AND g.trangThai ='5' ")
    Integer getGiaoDichCancel(@Param("idKhachHang")long idKhachHang);

    @Query(value = "select IFNULL(count(g.id_giao_dich),0) from giao_dich g where g.trang_thai not in ('3','5')", nativeQuery = true)
    Integer countGiaoDich();

    @Query(value = "select IFNULL(count(g.id_giao_dich),0) from giao_dich g where g.trang_thai not in ('3','5') and g.ngay_tao between :fromDate and :toDate", nativeQuery = true)
    Integer countGiaoDichByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value = "select IFNULL(sum(dh.tien - (sp.gia_goc * dh.so_luong)),0) from san_pham sp, don_hang dh, giao_dich gd \n" +
            "where sp.id_san_pham = dh.id_san_pham \n" +
            "and dh.id_giao_dich =gd.id_giao_dich \n" +
            "and gd.trang_thai = '2'", nativeQuery = true)
    Double sumTienLoi();

    @Query(value = "select IFNULL(sum(dh.tien - (sp.gia_goc * dh.so_luong)),0) from san_pham sp, don_hang dh, giao_dich gd \n" +
            "where sp.id_san_pham = dh.id_san_pham \n" +
            "and dh.id_giao_dich =gd.id_giao_dich \n" +
            "and gd.trang_thai = '2'\n" +
            "and gd.ngay_tao between :fromDate and :toDate", nativeQuery = true)
    Double sumTienLoiByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value = "select IFNULL(sum(gd.so_tien),0) from giao_dich gd where gd.trang_thai = '2' ", nativeQuery = true)
    Double sumTienThuVe();

    @Query(value = "select IFNULL(sum(gd.so_tien),0) from giao_dich gd \n" +
            "where gd.trang_thai = '2'\n" +
            "and gd.ngay_tao between :fromDate and :toDate", nativeQuery = true)
    Double sumTienThuVeByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value = "select sp.ten_san_pham as tenSanPham , \n" +
            "(select dmsp .ten_danh_muc from danh_muc_san_pham dmsp where dmsp.id_danh_mucsp = sp.id_danh_mucsp ) as loai, \n" +
            "dh.so_luong as soLuong , gia_goc * dh.so_luong  as tienVon, \n" +
            "dh.tien - (gia_goc * dh.so_luong) as tienLoi, dh.tien as tienThuVe \n" +
            "from san_pham sp left join don_hang dh on dh.id_san_pham = sp.id_san_pham \n" +
            "left join giao_dich gd on gd.id_giao_dich = dh.id_giao_dich\n" +
            "where gd.trang_thai = 2", nativeQuery = true)
    List<DoanhThuSanPham> getDoanhThuSP();

    @Query(value = "select sp.ten_san_pham as tenSanPham , \n" +
            "(select dmsp .ten_danh_muc from danh_muc_san_pham dmsp where dmsp.id_danh_mucsp = sp.id_danh_mucsp ) as loai, \n" +
            "dh.so_luong as soLuong , gia_goc * dh.so_luong  as tienVon, \n" +
            "dh.tien - (gia_goc * dh.so_luong) as tienLoi, dh.tien as tienThuVe \n" +
            "from san_pham sp left join don_hang dh on dh.id_san_pham = sp.id_san_pham \n" +
            "left join giao_dich gd on gd.id_giao_dich = dh.id_giao_dich\n" +
            "where gd.trang_thai = 2 and gd.ngay_tao between :fromDate and :toDate", nativeQuery = true)
    List<DoanhThuSanPham> getDoanhThuSPByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value ="SELECT gd from GiaoDich gd WHERE gd.ngayTao between :fromDate and :toDate")
    List<GiaoDich> getTransactionByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    List<GiaoDich> findByTenKhachHangContainingIgnoreCase(String tenKhachHang);

    @Query(value ="SELECT gd from GiaoDich gd WHERE gd.idKhachHang = :idKhachHang ORDER BY idGiaoDich DESC")
    List<GiaoDich> findByIdKhachHang(@Param("idKhachHang") long idKhachHang);

    @Query(value ="select count(dh.id_giao_dich) from don_hang dh, san_pham sp \n" +
            "where dh.id_san_pham = sp.id_san_pham \n" +
            "and sp.so_luong >= dh.so_luong \n" +
            "and dh.trang_thai = '0' \n" +
            "and dh.id_nguoi_giao_dich =:idKhachHang ", nativeQuery = true)
    Integer countGiaoDichAccept(@Param("idKhachHang") long idKhachHang);

}
