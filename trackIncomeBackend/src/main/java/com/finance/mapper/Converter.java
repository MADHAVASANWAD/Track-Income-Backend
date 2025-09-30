package com.finance.mapper;

import com.finance.DTO.UserDTO;
import com.finance.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Converter {

    private final PasswordEncoder passwordEncoder;

    public Converter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User userDtoToUser(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhone(dto.getPhone());
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setRole(dto.getRole());
        try {
            user.setImg(dto.getFile().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static UserDTO userToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserid(user.getUserid());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setAddress(user.getAddress());
        dto.setRole(user.getRole());
        dto.setPhone(user.getPhone());
        dto.setName(user.getName());
        dto.setBase64String(Base64.getEncoder().encodeToString(user.getImg()));
        return dto;
    }





}
