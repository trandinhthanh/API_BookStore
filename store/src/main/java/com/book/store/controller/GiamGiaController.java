package com.book.store.controller;

import com.book.store.model.GiamGia;
import com.book.store.service.GiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("giamGia")
@CrossOrigin(origins = "*")
public class GiamGiaController {
    @Autowired
    private GiamGiaService giamGiaService;

    @GetMapping("/listGiamGia")
    public ResponseEntity<List<GiamGia>> getAllGiamGia(){
        List<GiamGia> list = giamGiaService.getAllGiamGia();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getGiamGiaHoatDong")
    public ResponseEntity<List<GiamGia>> getGiamGiaHoatDong(){
        return new ResponseEntity<>(giamGiaService.getGiamGiaHoatDong(), HttpStatus.OK);
    }

    @GetMapping("/getGiamGiaById/{idGiamGia}")
    public ResponseEntity<GiamGia> getGiamGiaById(@PathVariable("idGiamGia") long idGiamGia){
        return new ResponseEntity<>(giamGiaService.getGiamGiaById(idGiamGia), HttpStatus.OK);
    }

    @PostMapping(value="/create",headers="Accept=application/json")
    public ResponseEntity<GiamGia> createGiamGia(@RequestBody GiamGia giamGia){
        GiamGia output = giamGiaService.create(giamGia);
        if(output != null){
            return new ResponseEntity<>(output, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //Sua
    @PostMapping(value="/update",headers="Accept=application/json")
    public ResponseEntity<GiamGia> update(@RequestBody GiamGia giamGia){
        GiamGia output = giamGiaService.update(giamGia);
        if (output != null) {
            return new ResponseEntity<>(output, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    //delete
    @PostMapping(value="/delete/{idGiamGia}",headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("idGiamGia") long idGiamGia){
        if (giamGiaService.delete(idGiamGia)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
