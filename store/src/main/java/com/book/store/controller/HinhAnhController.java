package com.book.store.controller;

import com.book.store.model.NguoiDung;
import com.book.store.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("file")
@CrossOrigin(origins = "*")
public class HinhAnhController {

	@Autowired
    private HinhAnhService hinhAnhService;

    @RequestMapping("/img/{id}")
    public HttpEntity<byte[]> getArticleImage(@PathVariable String id) {
        byte[] image = hinhAnhService.getImg(id);

        HttpHeaders headers = new HttpHeaders();
        if(image != null) {
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentLength(image.length);
        }
        return new HttpEntity<byte[]>(image, headers);
    }

    @PostMapping("/img/upload")
    public ResponseEntity<Boolean> uploadFileMulti(
            @RequestParam("idSanPham") long idSanPham,
            @RequestParam("files") MultipartFile[] uploadfiles) {
        if(uploadfiles.length == 0 || hinhAnhService.saveImg(idSanPham, Arrays.asList(uploadfiles))){
            return new ResponseEntity<>(true ,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    //delete
    @GetMapping("/delete/{idSanPham}/{link}")
    public ResponseEntity<NguoiDung> delete(
            @PathVariable("idSanPham") long idSanPham,
            @PathVariable("link") String link){
        if (hinhAnhService.deleteByLink(idSanPham, link)) {
            return new ResponseEntity<NguoiDung>(HttpStatus.OK);
        }
        return new ResponseEntity<NguoiDung>(HttpStatus.NOT_FOUND);
    }
}
