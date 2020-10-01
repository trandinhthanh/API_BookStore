package com.book.store.serviceImpl;
import com.book.store.model.HinhAnh;
import com.book.store.repository.HinhAnhRepository;
import com.book.store.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HinhAnhServiceImpl implements HinhAnhService {

	@Autowired
    private HinhAnhRepository hinhAnhRepository;

    public boolean save(List<HinhAnh> dshinhAnh) {
        dshinhAnh.forEach(hinhAnh -> hinhAnhRepository.save(hinhAnh));
        return true;
    }

    public Optional<HinhAnh> getFile(long id){
        return hinhAnhRepository.findById(id);
    }
}