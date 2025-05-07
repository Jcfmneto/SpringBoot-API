package com.streaming.project.demo.service;

import com.streaming.project.demo.dto.LoginDTO;
import com.streaming.project.demo.dto.RegisterDTO;
import com.streaming.project.demo.entity.User;
import com.streaming.project.demo.exception.CredenciaisInvalidas;
import com.streaming.project.demo.exception.UsuarioCadastrado;
import com.streaming.project.demo.repository.UserRepository;
import com.streaming.project.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtService jwtService;

    public String login(LoginDTO usuario) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(usuario.email(), usuario.senha());
            var auth = authenticationManager.authenticate(usernamePassword);
            return jwtService.GenerateToken((User) auth.getPrincipal());
        } catch (AuthenticationException e) {
            throw new CredenciaisInvalidas();
        }
    }
    public void register(RegisterDTO usuario){
        if(repository.findByEmail(usuario.email()) != null){
            throw new UsuarioCadastrado();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.senha());
        User newUser = new User(usuario.nome(), usuario.email(), encryptedPassword);
        repository.save(newUser);
    }

}