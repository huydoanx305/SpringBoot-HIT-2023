package com.example.buoi4.controller;

import com.example.buoi4.User;
import com.example.buoi4.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

  static List<User> users = new ArrayList<>();

  static {
    users.add(new User(1L, "admin1", "1"));
    users.add(new User(2L, "admin2", "1"));
    users.add(new User(3L, "admin3", "1"));
    users.add(new User(4L, "admin4", "1"));
    users.add(new User(5L, "admin5", "1"));
  }

  @GetMapping("test")
  public ResponseEntity<?> test() {
    int a[] = {1,2,4,5};
    System.out.println(a[10]);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<?> getUser(@PathVariable Long id) {
    User response = null;
    for(User user : users) {
      if(user.getId().equals(id)) {
        response = user;
      }
    }
    if(response == null) {
      throw new NotFoundException("Không tìm thấy người dùng có id là " + id);
    }
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/user")
  public ResponseEntity<?> getUser(@RequestParam(name = "username", required = false, defaultValue = "admin2") String username,
                                   @RequestParam String password) {
    User response = null;
    for(User user : users) {
      if(user.getUsername().equals(username)
          && user.getPassword().equals(password)) {
        response = user;
      }
    }
    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/body/user")
  public ResponseEntity<?> createUser(@RequestBody User user) {
    return ResponseEntity.ok().body(user);
  }

  @PostMapping("/model/user")
  public ResponseEntity<?> createUserModel(@ModelAttribute User user) {
    return ResponseEntity.ok().body(user);
  }

}
