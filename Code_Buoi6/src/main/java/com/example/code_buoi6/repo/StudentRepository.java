package com.example.code_buoi6.repo;

import com.example.code_buoi6.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Tạo 1 danh sách trả về và được phân trang
    List<Student> findAllByName(String name, Pageable pageable);
}
