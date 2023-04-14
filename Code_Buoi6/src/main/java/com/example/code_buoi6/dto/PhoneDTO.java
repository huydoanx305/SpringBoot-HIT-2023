package com.example.code_buoi6.dto;

public class PhoneDTO {
    private String name;
    private String brand;
    private int student_id;

    public PhoneDTO() {
    }

    public PhoneDTO(String name, String brand, int student_id) {
        this.name = name;
        this.brand = brand;
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
}
