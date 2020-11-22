package com.book.store.repository;

import com.book.store.model.DonHang;
import com.book.store.modelConvert.SanPhamByDonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long>{

    @Transactional
    @Modifying
    @Query(value ="UPDATE DonHang SET soLuong = :soLuong WHERE trangThai = '0' AND idNguoiGiaoDich = :idNguoiGiaoDich AND idSanPham = :idSanPham")
    Integer updateSoLuong(@Param("soLuong")int soLuong, @Param("idNguoiGiaoDich")long idNguoiGiaoDich, @Param("idSanPham")long idSanPham);

    @Transactional
    @Modifying
    @Query(value ="DELETE FROM DonHang WHERE trangThai = '0' AND idNguoiGiaoDich = :#{#dh.idNguoiGiaoDich} AND idSanPham = :#{#dh.idSanPham}")
    Integer deleteDongHang(@Param("dh")DonHang dh);

    @Transactional
    @Modifying
    @Query(value ="UPDATE DonHang SET trangThai = '1', idGiaoDich = :idGiaoDich, tien = :tien WHERE trangThai = '0' AND idDonHang = :idDonHang")
    Integer updateByIdDoHang(@Param("idDonHang")long idDonHang, @Param("idGiaoDich")long idGiaoDich,  @Param("tien")double tien );

    @Query(value ="select sp.tenSanPham as tenSanPham, dh.soLuong as soLuong, dh.tien as tien from DonHang dh , SanPham sp where dh.idSanPham = sp.idSanPham and dh.idGiaoDich = :idGiaoDich")
    List<SanPhamByDonHang> findByIdGiaoDich(@Param("idGiaoDich")long idGiaoDich);

    List<DonHang> findByIdNguoiGiaoDich(long idNguoiGiaoDich);
}
