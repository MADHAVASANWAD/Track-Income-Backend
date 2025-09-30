package com.finance.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private  long userid;

    private String name;

    private String phone;

    private String address;

    private String role;  // admin or user

    private String username;

    private String password;

    private byte[] img;

    private MultipartFile file;

    private String base64String;
}
