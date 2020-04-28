package com.example.gestorfinanceiro.entidades;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.gestorfinanceiro.excecoes.InvalidUserException;

import java.io.Serializable;

@Entity(tableName = "usuarios")
public class Usuario implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id = null;
    private String login;
    private String senha;
    @Ignore
    private OperacoesMensais operacoesMensais = new OperacoesMensais();
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

    public OperacoesMensais getMensais() {
        return operacoesMensais;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
