package com.book.store.controller;

import com.book.store.service.XuLyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
@CrossOrigin(origins = "*")
public class XuLyFileController {

    @Autowired
    private XuLyFileService xuLyFileService;

    @RequestMapping("/img/{id}")
    public HttpEntity<byte[]> getArticleImage(@PathVariable String id) {
        byte[] image = xuLyFileService.getFile(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new HttpEntity<byte[]>(image, headers);
    }

}
