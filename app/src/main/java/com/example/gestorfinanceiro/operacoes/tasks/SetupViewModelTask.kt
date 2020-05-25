package com.example.gestorfinanceiro.operacoes.tasks

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import com.example.gestorfinanceiro.database.DbBuilder
import com.example.gestorfinanceiro.entidades.Categoria
import com.example.gestorfinanceiro.operacoes.fragments.ExibirFragment
import com.example.gestorfinanceiro.operacoes.viewmodels.CategoriaViewModel

class SetupViewModelTask(val context : Context, val id : Int) : AsyncTask<Void, Void, Categoria>(){

    override fun doInBackground(vararg params: Void?): Categoria {
        val db = DbBuilder.getInstance(context)
        return db.categoriaDAO().selectId(id)
    }



}