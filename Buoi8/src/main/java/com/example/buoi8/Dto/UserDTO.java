package com.example.buoi8.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotNull(message = "Name is not null")
    String name;
    
    //    @NotBlank : NotNull + NotEmpty
        @NotBlank(message = "Address is not empty")
    String address;

//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ,
//            message = "Email is not format")
//    String email;

//    @Min(value = 1)
//    @Max(value = 100)
//@Size(min = 2, max = 100)
//private int age;
    MultipartFile multipartFile;
}
