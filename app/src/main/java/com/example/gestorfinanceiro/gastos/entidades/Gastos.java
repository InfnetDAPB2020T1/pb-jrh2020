package com.example.gestorfinanceiro.gastos.entidades;

import java.util.ArrayList;

public class Gastos {

    private ArrayList<Operacao> gastos = new ArrayList<>();

    public ArrayList<Operacao> getGastos() {
        return gastos;
    }
    public void addGasto(int valor, String descricao){
        gastos.add(new Operacao(valor, descricao));
    }
}
