package com.example.code_buoi6.repo;

import com.example.code_buoi6.model.Phone;
import com.example.code_buoi6.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
}
