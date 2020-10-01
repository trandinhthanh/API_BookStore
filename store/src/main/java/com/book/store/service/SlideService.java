package com.book.store.service;

import com.book.store.model.Slide;

import java.util.List;
import java.util.Optional;


public interface SlideService {
	public List<Slide> getAllSlide();
	public Slide createSlide(Slide slide);
	public Slide Update(Slide slide);
	public void deleteSlideById(long id);
	public Optional<Slide> findById(long id);
}
