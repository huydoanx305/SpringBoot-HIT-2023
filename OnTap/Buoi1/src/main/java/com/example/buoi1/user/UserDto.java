package com.example.buoi1.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private Long id;
    private String email;
    private String fullName;
}
