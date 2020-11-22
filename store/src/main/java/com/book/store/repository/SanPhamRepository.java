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
	@Query(value = "SELECT p.* FROM san_pham p, danh_muc_san_pham d WHERE p.id_danh_mucsp = d.id_danh_mucsp AND d.link_danh_muc = ?1 ORDER BY p.ngay_tao DESC",
		countQuery = "SELECT count(*) FROM san_pham p, danh_muc_san_pham d WHERE p.id_danh_mucsp = d.id_danh_mucsp AND d.link_danh_muc = ?1",
		nativeQuery = true)
	Page<SanPham> findByIdDanhMucSP(String linkDanhMuc, Pageable pageable);

	@Query(value ="SELECT p FROM SanPham p WHERE p.soLuong > 0 ")
	List<SanPham> getSanPhamVoiSoLuong();
	
	@Query(value ="SELECT p FROM SanPham p WHERE p.idDanhMucSP = :idDanhMucSP ORDER BY ngayTao ASC")
	List<SanPham> getSanPhamTheoDanhMuc(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT * FROM san_pham ORDER BY luot_xem DESC LIMIT 10" , nativeQuery = true)
	List<SanPham> sanPhamNoiBat();
	
	@Query(value ="SELECT * FROM san_pham WHERE id_danh_mucsp  = :idDanhMucSP ORDER BY luot_xem DESC LIMIT 5 ", nativeQuery = true)
	List<SanPham> sanPhamLienQuan(@Param("idDanhMucSP")int idDanhMucSP);
	
	@Query(value ="SELECT idSanPham, tenSanPham FROM SanPham")
	List<SanPham> getTenSanPham();

	@Transactional
	@Modifying
	@Query(value ="UPDATE SanPham SET soLuong = (soLuong - :soLuongGiam) WHERE idSanPham = :idSanPham")
	Integer updateSoLuongByIdSanPham(@Param("idSanPham")long idSanPham, @Param("soLuongGiam")int soLuongGiam);

	@Query(value = "SELECT s.* FROM san_pham s WHERE s.id_giam_gia = " +
			"(SELECT g.id_giam_gia FROM giam_gia g WHERE DATE_FORMAT(SYSDATE(), '%Y-%m-%d') " +
			"BETWEEN g.ngay_bat_dau AND g.ngay_ket_thuc ORDER BY g.phan_tram_giam DESC LIMIT 5) LIMIT 5", nativeQuery = true)
	List<SanPham> getListSanPhamGiamGia();

	@Transactional
	@Modifying
	@Query(value ="UPDATE SanPham SET luotXem = (luotXem + 1) WHERE idSanPham = :idSanPham")
	Integer updateLuotXemByIdSanPham(@Param("idSanPham")long idSanPham);

	@Transactional
	@Modifying
	@Query(value ="UPDATE SanPham SET luotThich = (luotThich + 1) WHERE idSanPham = :idSanPham")
	Integer updatePlusLike(@Param("idSanPham")long idSanPham);

	@Transactional
	@Modifying
	@Query(value ="UPDATE SanPham SET luotThich = (luotThich - 1) WHERE idSanPham = :idSanPham")
	Integer updateMinusLike(@Param("idSanPham")long idSanPham);

	List<SanPham> findByTenSanPhamContainingIgnoreCase(String tenSanPham);

}
