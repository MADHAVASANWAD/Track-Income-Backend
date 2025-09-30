package com.finance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(length = 50)
    private String name;

    @Column(length = 10)
    private String phone;

    @Column(length = 150)
    private String address;

    @Column(length = 10)
    private String role;  // admin or user

    @Column(length = 50)
    private String username;

    @Column(length = 200)
    private String password;

    @Lob
    private byte[] img;

}
