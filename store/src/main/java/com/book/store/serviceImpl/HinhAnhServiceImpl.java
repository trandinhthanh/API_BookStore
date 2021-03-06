package com.book.store.serviceImpl;
import com.book.store.model.HinhAnh;
import com.book.store.repository.HinhAnhRepository;
import com.book.store.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Transactional
@Service
public class HinhAnhServiceImpl implements HinhAnhService {

    @Autowired
    HinhAnhRepository hinhAnhRepository;

    private static final String URL = "image/";
    @Override
    public byte[] getImg(String id) {
        if(id != null) {
            try {
                java.net.URL res = getClass().getClassLoader().getResource(URL + id);
                Path path = Paths.get(res.toURI());
                byte[] fileImage = Files.readAllBytes(path);
                return fileImage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean saveImg(long idSanPham, List<MultipartFile> images) {
        int i = hinhAnhRepository.getSapXep(idSanPham);
        for (MultipartFile file : images) {
            if (file.isEmpty()) {
                continue; //next pls
            }
            try {
                byte[] bytes = file.getBytes();
                java.net.URL checkRes = getClass().getClassLoader().getResource(URL + file.getOriginalFilename());
                if(checkRes == null) {
                    URI uri = ClassLoader.getSystemResource(URL).toURI();
                    String mainPath = Paths.get(uri).toString();
                    Path path = Paths.get(mainPath ,file.getOriginalFilename());
                    Files.write(path, bytes);
                }
                HinhAnh hinhAnh = new HinhAnh();
                hinhAnh.setIdSanPham(idSanPham);
                hinhAnh.setLink(file.getOriginalFilename());
                hinhAnh.setSapXep(i++);
                hinhAnhRepository.save(hinhAnh);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean deleteByLink(long idSanPham, String link) {
        if(hinhAnhRepository.deleteByIdSanPham(idSanPham, link) > 0){
            return true;
        }
        return false;
    }
}