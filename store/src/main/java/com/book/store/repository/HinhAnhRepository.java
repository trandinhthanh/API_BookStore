package com.book.store.repository;

import com.book.store.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Long>{
    @Query(value ="SELECT h FROM HinhAnh h WHERE h.idSanPham = :idSanPham ORDER BY sapXep ASC ")
    List<HinhAnh> getHinhAnhByIdSanPham(@Param("idSanPham")long idSanPham);

    @Query(value = "SELECT IFNULL(MAX(sap_xep), 0) + 1  FROM hinh_anh WHERE id_san_pham =:idSanPham ", nativeQuery = true)
    Integer getSapXep(@Param("idSanPham")long idSanPham);

    @Transactional
    @Modifying
    @Query(value ="DELETE FROM HinhAnh WHERE idSanPham = :idSanPham AND link =:link")
    Integer deleteByIdSanPham(@Param("idSanPham")long idSanPham, @Param("link")String link);
}
