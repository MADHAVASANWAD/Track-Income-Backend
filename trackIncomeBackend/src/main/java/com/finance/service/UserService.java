package com.finance.service;

import com.finance.DTO.UserDTO;
import com.finance.exception.ResourceNotFoundException;
import com.finance.mapper.Converter;
import com.finance.config.CustomeUserDetails;
import com.finance.model.User;
import com.finance.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> allUsers() {
        return userRepository.findAll().stream().map(Converter::userToUserDTO).toList();
    }

    public UserDTO insertUser(UserDTO dto) {
        Converter c = new Converter(passwordEncoder);
        User user1 = c.userDtoToUser(dto);
        System.out.println(user1);
        return Converter.userToUserDTO(userRepository.save(user1));
    }


    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }

    public UserDTO updateUser(long id, UserDTO dto) {
        User user = new Converter(passwordEncoder).userDtoToUser(dto);
        User s = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));

        if (!user.getUsername().isEmpty()) {
            s.setUsername(user.getUsername());
        } else if (!user.getPassword().isEmpty()) {
            s.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return Converter.userToUserDTO(userRepository.save(s));
    }

    public UserDTO profile() {
        return Converter.userToUserDTO(getUser());
    }

    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomeUserDetails userDetails = (CustomeUserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }


    public User  getUserById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user","id",id));
        return user;
    }




}
