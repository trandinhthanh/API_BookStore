package com.book.store.repository;

import com.book.store.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SlideRepository extends JpaRepository<Slide, Long> {

}
