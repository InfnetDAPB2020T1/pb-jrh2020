package com.example.gestorfinanceiro.excecoes;

public class InvalidCategoriaException extends RuntimeException {

    public InvalidCategoriaException(String msg){
        super(msg);
    }
}
