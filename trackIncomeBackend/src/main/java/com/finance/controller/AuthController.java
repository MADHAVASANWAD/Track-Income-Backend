package com.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.finance.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenHelper jwtHepler;

    @Autowired
    private CustomeUserDetailsService userDetailsService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody JWTRequest loginRequest){
        Authentication authentication;
        try {
            System.out.println("Login Request username : "+loginRequest.getUsername());
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        }
        catch(AuthenticationException e) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

     //   CustomeUserDetails userDetails = (CustomeUserDetails) authentication.getPrincipal();

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        String jwtToken = jwtHepler.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());

        Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        CustomeUserDetails principal = (CustomeUserDetails) authentication1.getPrincipal();

//        JWTResponse response = new JWTResponse(jwtToken,principal.getUser());
        JWTResponse response = new JWTResponse(jwtToken);
        System.out.println("this is generated token : "+response);



        return ResponseEntity.ok(response);
    }
}
