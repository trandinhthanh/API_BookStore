package com.book.store.repository;

import com.book.store.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
	
	@Query(value ="SELECT p FROM SanPham p WHERE p.soLuong > 0 ")
	List<SanPham> getSanPhamVoiSoLuong();
	
	@Query(value ="SELECT p FROM SanPham p WHERE p.idDanhMucSP = :idDanhMucSP ")
	List<SanPham> getSanPhamTheoDanhMuc(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT * FROM SanPham ORDER BY view DESC LIMIT 10" , nativeQuery = true)
	List<SanPham> sanPhamNoiBat();
	
	@Query(value ="SELECT * FROM SanPham WHERE idDanhMucSP  = :idDanhMucSP ORDER BY view DESC LIMIT 10 ", nativeQuery = true)
	List<SanPham> sanPhamLienQuan(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT id, tenSanPham FROM SanPham")
	List<SanPham> getTenSanPham();
	
}
