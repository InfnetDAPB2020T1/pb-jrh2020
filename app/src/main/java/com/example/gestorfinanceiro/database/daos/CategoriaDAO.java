package com.example.gestorfinanceiro.database.daos;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gestorfinanceiro.entidades.Categoria;

import java.util.List;

@Dao
public interface CategoriaDAO {

    @Insert
    void armazenar(Categoria ctg);

    @Insert
    void armazenarvar(Categoria... ctg);

    @Update
    void update(Categoria ctg);


    @Delete
    void delete(Categoria ctg);

    @Query("SELECT * FROM categorias")
    List<Categoria> selectAll();


    @Query("SELECT * FROM categorias WHERE id =:id")
    Categoria selectId(int id);

    @Query("SELECT * FROM categorias WHERE nome =:nome")
    Categoria selectByName(String nome);

    @Query("SELECT * FROM categorias WHERE status =:status AND mes=:mes")
    List<Categoria> selectAllByStatusAndMonth(Boolean status, int mes);


}
