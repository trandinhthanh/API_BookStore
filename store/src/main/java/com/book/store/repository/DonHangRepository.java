package com.book.store.repository;

import com.book.store.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Long>{

}
