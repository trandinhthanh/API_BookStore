package com.book.store.repository;

import com.book.store.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Long>{
    @Query(value ="SELECT h FROM HinhAnh h WHERE h.idSanPham = :idSanPham ")
    List<HinhAnh> getHinhAnhByIdSanPham(@Param("idSanPham")long idSanPham);
}
