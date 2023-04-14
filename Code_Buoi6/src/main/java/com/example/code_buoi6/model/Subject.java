package com.example.code_buoi6.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    //@JsonBackReference
    //EAGER : Load data của chính entity gốc và những thằng liên quan
    //LAZY  : Cái nào được gọi thì chỉ được load mình data của cái đó , k load các thằng liên quan
    //tìm hiểu tại sao để LAZY ở thằng Many to one lại lỗi ?
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Subject(String name, Student student) {
        this.name = name;
        this.student = student;
    }

}
