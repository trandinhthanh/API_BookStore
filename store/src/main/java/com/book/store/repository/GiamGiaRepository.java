package com.book.store.repository;

import com.book.store.model.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, Long> {
    @Query(value ="SELECT g FROM GiamGia g WHERE SYSDATE() BETWEEN ngayBatDau AND ngayKetThuc")
    List<GiamGia> getGiamGiaHoatDong();
}
