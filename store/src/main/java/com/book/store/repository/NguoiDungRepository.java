package com.book.store.repository;

import com.book.store.model.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{
    @Query(value ="SELECT n FROM NguoiDung n WHERE n.email  = :email AND n.matKhau = :matKhau")
    NguoiDung kiemTraDangNhap(@Param("email")String email, @Param("matKhau")String matKhau);

    @Transactional
    @Modifying
    @Query(value ="UPDATE NguoiDung SET trangThai = :trangThai WHERE idNguoiDung = :idNguoiDung AND laQuanLy = false ")
    Integer blockUser(@Param("idNguoiDung")long idNguoiDung, @Param("trangThai") String trangThai);

    @Query(value = "select IFNULL(count(nd.id_nguoi_dung),0) from nguoi_dung nd where nd.la_quan_ly = 0", nativeQuery = true)
    Integer countUser();

    @Query(value = "select IFNULL(count(nd.id_nguoi_dung),0) from nguoi_dung nd where nd.la_quan_ly = 0 and nd.ngay_tao between :fromDate and :toDate", nativeQuery = true)
    Integer countUserByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

    @Query(value ="SELECT n.* FROM nguoi_dung n WHERE n.la_quan_ly = :laQuanLy", nativeQuery = true)
    List<NguoiDung> locTaiKhoan(@Param("laQuanLy")int laQuanLy);

    @Transactional
    @Modifying
    @Query(value ="UPDATE NguoiDung SET matKhau = soDienThoai WHERE email = :email AND laQuanLy = :laQuanLy")
    Integer quenMatKhau(@Param("email") String email, @Param("laQuanLy") boolean laQuanLy);

    List<NguoiDung> findByTenNguoiDungContainingIgnoreCase(String tenNguoiDung);
}
