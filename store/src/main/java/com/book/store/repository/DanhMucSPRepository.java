package com.book.store.repository;

import java.util.List;

import com.book.store.model.DanhMucSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucSPRepository extends JpaRepository<DanhMucSanPham, Long>{
	@Query(value ="SELECT c FROM DanhMucSanPham c WHERE c.idDanhMucSP = :id")
	List<DanhMucSanPham> findId(@Param("id")long id);
}
