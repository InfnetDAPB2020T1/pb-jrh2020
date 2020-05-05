package com.example.gestorfinanceiro.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.gestorfinanceiro.entidades.Operacao;

import java.util.List;

@Dao
public interface OperacaoDAO {

    @Insert
    void armazenarOp(Operacao op);

    @Insert
    void armazenarops(Operacao... op);

    @Update
    void updateOp(Operacao op);


    @Delete
    void deleteOp(Operacao op);

    @Query("SELECT * FROM operacoes")
    List<Operacao> selectAll();


    @Query("SELECT * FROM operacoes WHERE id =:id")
    Operacao selectId(int id);

    @Query("SELECT * FROM operacoes WHERE userOwnerId =:userOwnerId AND mes =:mes")
    List<Operacao> selectOpByUserIdAndMonth(int userOwnerId, int mes);
}
