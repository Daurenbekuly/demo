package com.example.demo.service.serviceImpl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.unprocessableEntity().build());
    }

    @Override
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        return ResponseEntity.ok(userRepository.findAll(pageable));
    }

    @Override
    public ResponseEntity<String> createUser(User user) {
        Optional<User> op = userRepository.findByName(user.getName());
        if (op.isPresent()) {
            throw new IllegalArgumentException("User name taken");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User created");
    }

    @Override
    public ResponseEntity<String> updateUser(Long id, User rUser) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("User with " + id + " not exist"));
        rUser.setId(user.getId());
        userRepository.save(rUser);
        return ResponseEntity.ok("User updated");
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("User with " + id + " not exist"));
        userRepository.delete(user);
        return ResponseEntity.ok("User deleted");
    }
}
