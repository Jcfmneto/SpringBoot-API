package com.streaming.project.demo.exception;

public class CredenciaisInvalidas extends RuntimeException{
    public CredenciaisInvalidas(){
        super("E-mail ou senha não incorretos");
    }
}
