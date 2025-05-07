package com.streaming.project.demo.controller;


import com.streaming.project.demo.dto.LoginDTO;
import com.streaming.project.demo.dto.LoginResponseDTO;
import com.streaming.project.demo.dto.RegisterDTO;
import com.streaming.project.demo.entity.User;
import com.streaming.project.demo.repository.UserRepository;
import com.streaming.project.demo.security.JwtService;
import com.streaming.project.demo.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    UserRepository repository;


    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody @Valid LoginDTO usuario){
        var token = authenticationService.login(usuario);
    return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO usuario){
        authenticationService.register(usuario);
    return ResponseEntity.ok().build();
    }

}
