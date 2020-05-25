package com.example.gestorfinanceiro.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gestorfinanceiro.database.daos.CategoriaDAO;
import com.example.gestorfinanceiro.database.daos.OperacaoDAO;
import com.example.gestorfinanceiro.entidades.Categoria;
import com.example.gestorfinanceiro.entidades.Operacao;


@Database(entities = {Operacao.class, Categoria.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {


    public abstract OperacaoDAO operacaoDAO();

    public abstract CategoriaDAO categoriaDAO();

}
