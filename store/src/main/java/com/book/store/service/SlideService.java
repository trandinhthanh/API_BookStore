package com.book.store.service;

import com.book.store.model.Slide;

import java.util.List;
import java.util.Optional;


public interface SlideService {
	List<Slide> getAllSlide();
	Slide createSlide(Slide slide);
	Slide Update(Slide slide);
	void deleteSlideById(long id);
	Optional<Slide> findById(long id);
}
