package com.example.gestorfinanceiro.entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class BancoUsuarios implements Serializable {

    private ArrayList<Usuario> bancoDeUsuarios = new ArrayList<>();



    public void addUsuario(String login, String senha, String cpf){
        bancoDeUsuarios.add(new Usuario(login, senha, cpf));
    }

    public Usuario getUser(String login){
        for (Usuario u: bancoDeUsuarios) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public boolean autentica(String login, String senha){
        for (Usuario u: bancoDeUsuarios) {
            if (u.getLogin().equals(login)) {
                if (u.getSenha().equals(senha)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkUser(String login){
        for (Usuario u: bancoDeUsuarios) {
            if (u.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public void debug(){
        for (Usuario u:bancoDeUsuarios) {
            System.out.println(u.getLogin());
        }
    }


}
