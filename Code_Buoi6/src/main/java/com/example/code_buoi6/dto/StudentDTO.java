package com.example.code_buoi6.dto;

public class StudentDTO {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public StudentDTO(){}
    public StudentDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
