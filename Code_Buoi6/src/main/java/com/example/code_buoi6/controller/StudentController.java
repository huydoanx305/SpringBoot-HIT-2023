package com.example.code_buoi6.controller;

import com.example.code_buoi6.dto.StudentDTO;
import com.example.code_buoi6.model.Student;
import com.example.code_buoi6.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_new_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO.getName(),
                studentDTO.getAddress());
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping("/get_all_student_page")
    public ResponseEntity<?> pageableFindAll(@RequestParam(name = "page", required = false) int page,
                                             @RequestParam(name = "size", required = false) int size) {
        if (page < 0) return ResponseEntity.ok(studentRepository.findAll());
        else {
            Page<Student> students = studentRepository.findAll(PageRequest.of(page, size));
            return ResponseEntity.ok(students.getContent());
        }
    }

    @GetMapping("/get_all_student")
    public ResponseEntity<?> pageableFindAll() {
        return ResponseEntity.ok(studentRepository.findAll());
    }


    @GetMapping("/searchByName")
    public ResponseEntity<?> searchByName(@RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "page", required = false) int page,
                                          @RequestParam(name = "size", required = false) int size) {
        if (page < 0) {
            page = 0;
        }
        List<Student> students = studentRepository.findAllByName(name, PageRequest.of(page, size));
        return ResponseEntity.ok(students);
    }
}
