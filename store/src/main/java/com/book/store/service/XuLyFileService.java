package com.book.store.service;

import java.io.File;

public interface XuLyFileService {
    byte[] getFile(String id);
    boolean saveFile(File f);
}
