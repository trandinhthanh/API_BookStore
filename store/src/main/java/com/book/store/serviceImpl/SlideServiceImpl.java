package com.book.store.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.book.store.model.Slide;
import com.book.store.repository.SlideRepository;
import com.book.store.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class SlideServiceImpl implements SlideService {
	@Autowired
	private SlideRepository slideRepository;
	
	@Override
	public List<Slide> getAllSlide() {
		
		return slideRepository.findAll();
	}

	@Override
	public Slide createSlide(Slide slide) {
		
		return slideRepository.save(slide);
	}

	@Override
	public Slide Update(Slide slide) {
		
		return slideRepository.save(slide);
	}

	@Override
	public void deleteSlideById(long id) {
		
		slideRepository.deleteById(id);
	}

	@Override
	public Optional<Slide> findById(long id) {
		
		return slideRepository.findById(id);
	}

}
