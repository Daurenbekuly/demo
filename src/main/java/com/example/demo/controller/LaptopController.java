package com.example.demo.controller;

import com.example.demo.model.Laptop;
import com.example.demo.service.LaptopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/laptop")
public class LaptopController {

    private final LaptopService laptopService;

    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptop(@PathVariable Long id) {
        return laptopService.getById(id);
    }

    @GetMapping
    public ResponseEntity<Page<Laptop>> getAll(Pageable pageable) {
        return laptopService.getAll(pageable);
    }


}
