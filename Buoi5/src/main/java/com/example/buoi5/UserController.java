package com.example.buoi5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/user")
  public ResponseEntity<?> createUser(@RequestBody User user) {
    User userCreate = userRepository.save(user);
    return ResponseEntity.ok().body(userCreate);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<?> getUserById(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);
    return ResponseEntity.ok().body(user);
  }

  @PatchMapping("/user/{id}")
  public ResponseEntity<?> updateUser(@PathVariable Long id,
                                      @RequestBody User user) {
    Optional<User> currentUser = userRepository.findById(id);
    if (user.getUsername() != null) {
      currentUser.get().setUsername(user.getUsername());
    }
    if (user.getPassword() != null) {
      currentUser.get().setPassword(user.getPassword());
    }
    if (user.getFullName() != null) {
      currentUser.get().setFullName(user.getFullName());
    }
    userRepository.save(currentUser.get());
    return ResponseEntity.ok().body(currentUser.get());
  }

}