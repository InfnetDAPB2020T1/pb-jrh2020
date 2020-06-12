package com.futuretecnologia.gestorfinanceiro.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.futuretecnologia.gestorfinanceiro.database.daos.CategoriaDAO;
import com.futuretecnologia.gestorfinanceiro.database.daos.OperacaoDAO;
import com.futuretecnologia.gestorfinanceiro.entidades.Categoria;
import com.futuretecnologia.gestorfinanceiro.entidades.Operacao;


@Database(entities = {Operacao.class, Categoria.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {


    public abstract OperacaoDAO operacaoDAO();

    public abstract CategoriaDAO categoriaDAO();

}
