package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> getById(Long id);

    ResponseEntity<Page<User>> getAll(Pageable pageable);

    ResponseEntity<String> createUser(User user);

    ResponseEntity<String> updateUser(Long id, User user);

    ResponseEntity<String> deleteUser(Long id);
}
