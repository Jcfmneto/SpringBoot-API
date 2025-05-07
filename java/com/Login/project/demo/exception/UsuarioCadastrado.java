package com.streaming.project.demo.exception;

public class UsuarioCadastrado extends RuntimeException {
    public UsuarioCadastrado(){
        super("Usuario já está cadastrado");
    }
}
