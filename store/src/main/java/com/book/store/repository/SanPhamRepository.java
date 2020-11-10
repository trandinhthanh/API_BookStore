package com.book.store.repository;

import com.book.store.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
	@Query(value = "SELECT p.* FROM san_pham p, danh_muc_san_pham d WHERE p.id_danh_mucsp = d.id_danh_mucsp AND d.link_danh_muc = ?1",
		countQuery = "SELECT count(*) FROM san_pham p, danh_muc_san_pham d WHERE p.id_danh_mucsp = d.id_danh_mucsp AND d.link_danh_muc = ?1",
		nativeQuery = true)
	Page<SanPham> findByIdDanhMucSP(String linkDanhMuc, Pageable pageable);

	@Query(value ="SELECT p FROM SanPham p WHERE p.soLuong > 0 ")
	List<SanPham> getSanPhamVoiSoLuong();
	
	@Query(value ="SELECT p FROM SanPham p WHERE p.idDanhMucSP = :idDanhMucSP ")
	List<SanPham> getSanPhamTheoDanhMuc(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT * FROM san_pham ORDER BY luot_xem DESC LIMIT 10" , nativeQuery = true)
	List<SanPham> sanPhamNoiBat();
	
	@Query(value ="SELECT * FROM san_pham WHERE id_danh_mucsp  = :idDanhMucSP ORDER BY luot_xem DESC LIMIT 5 ", nativeQuery = true)
	List<SanPham> sanPhamLienQuan(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT idSanPham, tenSanPham FROM SanPham")
	List<SanPham> getTenSanPham();

	@Transactional
	@Modifying
	@Query(value ="UPDATE DonHang SET soLuong = (soLuong - :soLuongGiam) WHERE idSanPham = :idSanPham")
	Integer updateSoLuongByIdSanPham(@Param("idSanPham")long idSanPham, @Param("soLuongGiam")long soLuongGiam);

	List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);

}
