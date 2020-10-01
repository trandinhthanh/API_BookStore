package com.book.store.repository;

import com.book.store.model.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Long>{

}
