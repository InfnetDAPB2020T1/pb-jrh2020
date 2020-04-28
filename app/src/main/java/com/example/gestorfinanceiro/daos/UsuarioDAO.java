package com.example.gestorfinanceiro.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gestorfinanceiro.entidades.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {

    @Insert
     void armazenar(Usuario u);

    @Insert
    void armazenarsuarios(Usuario... u);

    @Update
    void update(Usuario u);

    @Query("UPDATE usuarios SET senha = :senha WHERE id = :id")
    void updatePassword(int id, String senha);

    @Query("UPDATE usuarios SET cpf = :cpf WHERE id = :id")
    void updateCpf(int id, String cpf);

    @Query("UPDATE usuarios SET login = :login WHERE id = :id")
    void updateLogin(int id, String login);

    @Delete
    void delete(Usuario u);

    @Query("SELECT * FROM usuarios")
    List<Usuario> selectAll();

    @Query("SELECT * FROM usuarios WHERE login =:login")
    Usuario selectLogin(String login);

    @Query("SELECT * FROM usuarios WHERE id =:id")
    Usuario selectId(int id);


}
