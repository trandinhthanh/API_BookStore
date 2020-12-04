package com.book.store.repository;

import com.book.store.model.GiamGia;
import com.book.store.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, Long> {
    @Query(value ="SELECT g FROM GiamGia g WHERE SYSDATE() BETWEEN ngayBatDau AND ngayKetThuc")
    List<GiamGia> getGiamGiaHoatDong();

    @Query(value = "SELECT CAST(g.id_giam_gia AS CHAR) FROM giam_gia g WHERE DATE_FORMAT(SYSDATE(), '%Y-%m-%d') " +
            "BETWEEN g.ngay_bat_dau AND g.ngay_ket_thuc ORDER BY g.phan_tram_giam DESC LIMIT 5", nativeQuery = true)
    List<String> getListGiamGiaHoatDong();

    List<GiamGia> findByTrangThaiContainingIgnoreCase(String trangThai);

    List<GiamGia> findByTenGiamGiaContainingIgnoreCase(String tenGiamGia);
}
