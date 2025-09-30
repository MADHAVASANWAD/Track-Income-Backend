package com.finance.config;

import com.finance.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTResponse {

    private String token;

//    private User user;

}

