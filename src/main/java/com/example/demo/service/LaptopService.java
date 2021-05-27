package com.example.demo.service;

import com.example.demo.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LaptopService {

    ResponseEntity<Laptop> getById(Long id);

    ResponseEntity<Page<Laptop>> getAll(Pageable pageable);
}
