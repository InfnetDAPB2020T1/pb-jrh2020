package com.example.gestorfinanceiro.entidades;

import com.example.gestorfinanceiro.excecoes.InvalidUserException;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    private String login;
    private String senha;
    private ArrayList<Operacao> ganhos = new ArrayList<>();
    private ArrayList<Operacao> gastos = new ArrayList<>();


    private String cpf;


    public Usuario(String login, String senha, String cpf) {
        if(login.length() > 20){
            throw new InvalidUserException("Usuario maior que 20 caracteres");
        }
        if(senha.length() > 15){
            throw new InvalidUserException("Senha maior que 15 caracteres");
        }
        if(cpf.length() > 11){
            throw new InvalidUserException("CPF inválido");
        }
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;

    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String recuperarSenha(String login, String cpf){
        if(this.login.equals(login) && this.cpf.equals(cpf)){
            return senha;
        }
        return "Dados incorretos";
    }
    public void addGanho(int valor, String descricao){
        ganhos.add(new Operacao(valor, descricao));
    }
    public ArrayList<Operacao> getGanhos() {
        return ganhos;
    }
    public double getGanhosTotais(){
        double total = 0;
        for (Operacao op: ganhos) {
            total += op.getValor();
        }
        return total;
    }
    public void addGasto(int valor, String descricao){
            gastos.add(new Operacao(valor, descricao));
    }
    public ArrayList<Operacao> getGastos() {
        return gastos;
    }

    public double getGastosTotais(){
        double total = 0;
        for (Operacao op: gastos) {
            total += op.getValor();
        }

        return total;
    }



}
