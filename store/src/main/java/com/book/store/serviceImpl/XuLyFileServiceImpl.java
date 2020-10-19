package com.book.store.serviceImpl;

import com.book.store.service.XuLyFileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class XuLyFileServiceImpl implements XuLyFileService {
    private static final String URL = System.getProperty("user.dir") + "\\src\\main\\resources\\image\\";
    @Override
    public byte[] getFile(String id) {
        Path path = Paths.get(URL + id);
        try {
            byte[] fileImage = Files.readAllBytes(path);
            return fileImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveFile(File f) {
        return false;
    }
}
