package com.book.store.repository;

import java.util.List;

import com.book.store.model.DanhMucSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DanhMucSPRepository extends JpaRepository<DanhMucSanPham, Long>{
	@Query(value ="SELECT c FROM DanhMucSanPham c WHERE c.idDanhMucSP = :id")
	DanhMucSanPham findId(@Param("id")long id);

	@Query(value ="SELECT d FROM DanhMucSanPham d WHERE d.trangThai = '1' ")
	List<DanhMucSanPham> getDanhMucSPHoatDong();

	List<DanhMucSanPham> findByTenDanhMucContainingIgnoreCase(String tenDanhMuc);

	@Transactional
	@Modifying
	@Query(value ="UPDATE DanhMucSanPham SET trangThai = :trangThai WHERE idDanhMucSP = :idDanhMucSP")
	Integer updateTrangThaiById(@Param("idDanhMucSP")long idDanhMucSP,@Param("trangThai") String trangThai);
}
