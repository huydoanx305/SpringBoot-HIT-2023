package com.example.buoi8.controller;

import com.example.buoi8.Dto.UserDTO;
import com.example.buoi8.service.UserService;
import com.example.buoi8.utils.UploadFileCloudinary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UploadFileCloudinary uploadFileCloudinary;
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<?> createNewUser(@RequestParam String name,
                                           @RequestParam String address,
                                           @RequestParam MultipartFile file)
            throws IOException {
        return ResponseEntity.ok(userService.create(name, address, file));
    }

    @PostMapping("/create_user2")
    public ResponseEntity<?> createNewUser(@Valid @ModelAttribute UserDTO userDTO,
                                           BindingResult bindingResult)
            throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String errorMsg = "";
            for (String key : errors.keySet()) {
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }
            return ResponseEntity.ok(errorMsg);
        }
        return ResponseEntity.ok(userService.create2(userDTO));
    }

    @PostMapping("/create_user3")
    public ResponseEntity<?> createNewUser3(@RequestParam String name,
                                            @RequestParam String address,
                                            @RequestParam MultipartFile file
    ) {
        return ResponseEntity.ok(userService.createNewUser3(name, address, file));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteImageByUrl(@RequestParam String url) throws Exception {
        return ResponseEntity.ok(uploadFileCloudinary.removeFileToUrl(url));
    }

}
