package com.example.gestorfinanceiro.excecoes;

public class InvalidOperacaoException extends RuntimeException {

    public InvalidOperacaoException(String msg){
        super(msg);

    }

}
