package com.example.code_buoi6.controller;

import com.example.code_buoi6.dto.SubjectDTO;
import com.example.code_buoi6.model.Student;
import com.example.code_buoi6.model.Subject;
import com.example.code_buoi6.repo.StudentRepository;
import com.example.code_buoi6.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {

        //C1 : Trả về nếu không tìm thấy subject by id
        /*
       Student student = studentRepository.findById(subjectDTO.getStudent_id())
                .orElseThrow(()->{
                    throw new RuntimeException("Not found student with id: " + subjectDTO.getStudent_id());
                });

       */
        //c2 : Sử dụng đối tượng Optional : có thể lưu trữ được cả Object trong trường hợp nó null.
        Optional<Student> studentFindId = studentRepository.findById(subjectDTO.getStudent_id());
        if (studentFindId.isEmpty()) {
            return ResponseEntity.ok("Not found student with id : " + subjectDTO.getStudent_id());
        }
        Subject subject = new Subject(subjectDTO.getName(), studentFindId.get());
        return ResponseEntity.ok(subjectRepository.save(subject));
    }

    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(subjectRepository.findAll());
    }
}
