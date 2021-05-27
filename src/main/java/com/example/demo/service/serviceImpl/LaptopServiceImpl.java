package com.example.demo.service.serviceImpl;

import com.example.demo.model.Laptop;
import com.example.demo.model.User;
import com.example.demo.repository.LaptopRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LaptopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private final LaptopRepository laptopRepository;
    private final UserRepository userRepository;

    public LaptopServiceImpl(LaptopRepository laptopRepository, UserRepository userRepository) {
        this.laptopRepository = laptopRepository;
        this.userRepository = userRepository;
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

    @Override
    public ResponseEntity<String> create(Laptop laptop) {
        laptopRepository.save(laptop);
        return ResponseEntity.ok("Laptop created");
    }

    @Override
    public ResponseEntity<String> update(Long id, Laptop rLaptop) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("laptop with " + id + " not exist"));
        rLaptop.setId(laptop.getId());
        laptopRepository.save(rLaptop);
        return ResponseEntity.ok("Laptop updated");
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("laptop with " + id + " not exist"));
        laptopRepository.delete(laptop);
        return ResponseEntity.ok("Laptop deleted");
    }
}
