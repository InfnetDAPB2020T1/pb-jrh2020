package com.example.gestorfinanceiro.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class OperacoesMensais implements Serializable {

    private ArrayList<Operacoes> operacoesMensais = new ArrayList<>();

    public OperacoesMensais(){
        for (int i = 1; i <= 12; i++) {
            operacoesMensais.add(new Operacoes(i));
        }
    }

    public ArrayList<Operacoes> getOperacoesMensais() {
        return operacoesMensais;
    }



}
