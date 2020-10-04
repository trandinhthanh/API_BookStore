package com.book.store.repository;

import com.book.store.model.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, Long> {
}
