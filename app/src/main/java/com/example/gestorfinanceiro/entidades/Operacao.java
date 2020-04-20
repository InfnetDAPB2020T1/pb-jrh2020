package com.example.gestorfinanceiro.entidades;

import com.example.gestorfinanceiro.excecoes.InvalidOperacaoException;
import com.example.gestorfinanceiro.excecoes.InvalidUserException;

public class Operacao {
    private Integer valor;
    private String descricao;

    public Operacao(Integer valor, String descricao) {
        if(descricao.length() > 60){
            throw new InvalidOperacaoException("A descrição deve ter menos de 60 caracteres");
        }
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
