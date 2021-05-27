package com.example.demo.service;

import com.example.demo.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LaptopService {

    ResponseEntity<Laptop> getById(Long id);

    ResponseEntity<Page<Laptop>> getAll(Pageable pageable);

    ResponseEntity<String> create(Laptop laptop);

    ResponseEntity<String> update(Long id, Laptop laptop);

    ResponseEntity<String> delete(Long id);
}
