package com.example.gestorfinanceiro.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Operacoes implements Serializable {

    private ArrayList<Operacao> ganhos = new ArrayList<>();
    private ArrayList<Operacao> gastos = new ArrayList<>();
    private String mes;


    public Operacoes(int i) {
        switch (i) {
            case 1:
                mes = "Janeiro";
                break;
            case 2:
                mes = "Fevereiro";
                break;
            case 3:
                mes = "Março";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Maio";
                break;
            case 6:
                mes = "Junho";
                break;
            case 7:
                mes = "Julho";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Setembro";
                break;
            case 10:
                mes = "Outubro";
                break;
            case 11:
                mes = "Novembro";
                break;
            case 12:
                mes = "Dezembro";
                break;

        }

    }


    public void adicionarGanho(int valor, String descricao) {
        ganhos.add(new Operacao(valor, descricao));
    }
    public void removerGanho(String descricao) {
        for (Operacao operacao : ganhos) {
            if(operacao.getDescricao().equals(descricao)) {
                ganhos.remove(operacao);
                break;
            }
        }
    }

    public void adicionarGasto(int valor, String descricao) {
        gastos.add(new Operacao(valor, descricao));
    }
    public void removerGasto(String descricao) {
        for (Operacao operacao : gastos) {
            if(operacao.getDescricao().equals(descricao)) {
                gastos.remove(operacao);
                break;
            }
        }
    }

    public double getGastosTotais() {
        double gastos = 0;
        for (Operacao operacao : this.gastos) {
            gastos+= operacao.getValor();
        }
        return gastos;
    }
    public double getGanhosTotais() {
        double ganhos = 0;
        for (Operacao operacao : this.ganhos) {
            ganhos+= operacao.getValor();
        }
        return ganhos;
    }

    public double getSaldo() {
        double ganhos = 0, gastos = 0;
        for (Operacao operacao : this.ganhos) {
            ganhos+= operacao.getValor();
        }
        for (Operacao operacao : this.gastos) {
            gastos+= operacao.getValor();
        }
        return ganhos - gastos;
    }

    public String getMes() {
        return mes;
    }

    public ArrayList<Operacao> getGanhos() {
        return ganhos;
    }
    public ArrayList<Operacao> getGastos() {
        return gastos;
    }
}
