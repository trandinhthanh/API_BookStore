package com.book.store.controller;

import java.util.List;
import java.util.Optional;

import com.book.store.model.Slide;
import com.book.store.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("slide")
@CrossOrigin(origins = "*")
public class SlideController {
	@Autowired
	private SlideService slideService;
	
	@GetMapping("/listSlide")
	public ResponseEntity<List<Slide>>  getAllSlide(){
		List<Slide> list = slideService.getAllSlide();
		return new ResponseEntity<List<Slide>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createSlide(@RequestBody Slide slide, UriComponentsBuilder ucBuilder){
		slideService.createSlide(slide);
		HttpHeaders headers = new HttpHeaders();
	    headers.setLocation(ucBuilder.path("/Slide/{id}").buildAndExpand(slide.getId()).toUri());
	    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//Sua
	@PostMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Void> update(@RequestBody Slide slide){
		Optional<Slide> listSlide = slideService.findById(slide.getId());
		if (!listSlide.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else {
			slideService.Update(slide);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
    }
	//delete
	@GetMapping("/delete/{id}")
	public ResponseEntity<Slide> delete(@PathVariable("id") long id){
		Optional<Slide> listSlide = slideService.findById(id);
		if (!listSlide.isPresent()) {
			return new ResponseEntity<Slide>(HttpStatus.NOT_FOUND);
		}
		else 
			slideService.deleteSlideById(id);
		return new ResponseEntity<Slide>(HttpStatus.NO_CONTENT);
	}
}
