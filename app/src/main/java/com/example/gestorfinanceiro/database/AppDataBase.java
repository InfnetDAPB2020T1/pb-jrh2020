package com.example.gestorfinanceiro.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gestorfinanceiro.daos.UsuarioDAO;
import com.example.gestorfinanceiro.entidades.Usuario;


@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UsuarioDAO usuarioDao();

}
