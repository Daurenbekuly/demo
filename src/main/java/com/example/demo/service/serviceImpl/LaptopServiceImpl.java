package com.example.demo.service.serviceImpl;

import com.example.demo.model.Laptop;
import com.example.demo.repository.LaptopRepository;
import com.example.demo.service.LaptopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public ResponseEntity<Laptop> getById(Long id) {
        Optional<Laptop> op = laptopRepository.findById(id);
        return op.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.unprocessableEntity().build());
    }

    @Override
    public ResponseEntity<Page<Laptop>> getAll(Pageable pageable) {
        return ResponseEntity.ok(laptopRepository.findAll(pageable));
    }
}
