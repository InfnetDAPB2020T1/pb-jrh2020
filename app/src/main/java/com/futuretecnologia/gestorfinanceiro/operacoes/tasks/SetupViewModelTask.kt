package com.futuretecnologia.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import com.futuretecnologia.gestorfinanceiro.database.DbBuilder

class SetupViewModelTask(val context : Context, val id : Int) : AsyncTask<Void, Void, com.futuretecnologia.gestorfinanceiro.entidades.Categoria>(){

    override fun doInBackground(vararg params: Void?): com.futuretecnologia.gestorfinanceiro.entidades.Categoria {
        val db = DbBuilder.getInstance(context)
        return db.categoriaDAO().selectId(id)
    }



}