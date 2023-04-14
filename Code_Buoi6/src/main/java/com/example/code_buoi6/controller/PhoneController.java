package com.example.code_buoi6.controller;

import com.example.code_buoi6.dto.PhoneDTO;
import com.example.code_buoi6.model.Phone;
import com.example.code_buoi6.model.Student;
import com.example.code_buoi6.repo.PhoneRepository;
import com.example.code_buoi6.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_new_phone")
    public ResponseEntity<?> createNewSubject(@RequestBody PhoneDTO phoneDTO) {

        Student student = studentRepository.findById(phoneDTO.getStudent_id())
                .orElseThrow(() -> {
                    throw new RuntimeException("Not found student with id: " + phoneDTO.getStudent_id());
                });
        Phone phone = new Phone(phoneDTO.getName(), phoneDTO.getBrand(), student);
        return ResponseEntity.ok(phoneRepository.save(phone));
    }

    @GetMapping("/get_all_phone")
    public ResponseEntity<?> getAllPhone(@RequestParam(name = "page", required = false) int page,
                                         @RequestParam(name = "size", required = false , defaultValue = "5") int size) {
        if (page < 0) {
            return ResponseEntity.ok(phoneRepository.findAll());
        }
        //Phân trang nhưng có sắp xếp trang theo brand giảm dần
        Page<Phone> phones = phoneRepository.
                findAll(PageRequest.of(page, size, Sort.by("brand").descending()));
        return ResponseEntity.ok(phones.getContent());
    }
}
