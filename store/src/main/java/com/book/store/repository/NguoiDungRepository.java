package com.book.store.repository;

import com.book.store.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{
    @Query(value ="SELECT n FROM NguoiDung n WHERE n.email  = :email AND n.matKhau = :matKhau")
    NguoiDung kiemTraDangNhap(@Param("email")String email, @Param("matKhau")String matKhau);
}
