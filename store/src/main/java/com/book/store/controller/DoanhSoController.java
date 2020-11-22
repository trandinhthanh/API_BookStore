package com.book.store.controller;

import com.book.store.model.DoanhSo;
import com.book.store.modelConvert.ChiTietDonHangOutput;
import com.book.store.service.DoanhSoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RestController
@RequestMapping("danhSo")
@CrossOrigin(origins = "*")
public class DoanhSoController {
    @Autowired
    private DoanhSoService doanhSoService;

    @GetMapping("/getDoanhSo")
    public ResponseEntity<DoanhSo> getDoanhSo(){
        return new ResponseEntity<DoanhSo>(doanhSoService.getDoanhSo(null, null), HttpStatus.OK);
    }

    @GetMapping("/getDoanhSoByDate/{formDate}/{toDate}")
    public ResponseEntity<DoanhSo> getDoanhSoByDate(@PathVariable("formDate") String formDate, @PathVariable("toDate")String toDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DoanhSo doanhSo = doanhSoService.getDoanhSo(LocalDate.parse(formDate, formatter), LocalDate.parse(toDate, formatter));
        return new ResponseEntity<>(doanhSo, HttpStatus.OK);
    }
}
