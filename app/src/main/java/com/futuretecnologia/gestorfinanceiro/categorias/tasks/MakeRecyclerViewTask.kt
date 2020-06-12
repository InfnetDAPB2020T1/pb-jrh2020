package com.futuretecnologia.gestorfinanceiro.categorias.tasks

import android.content.Context
import android.os.AsyncTask
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.futuretecnologia.gestorfinanceiro.categorias.adapter.CategoriaAdapter
import com.futuretecnologia.gestorfinanceiro.database.DbBuilder

class MakeRecyclerViewTask(val context: Context, val recyclerview : RecyclerView, val status : Boolean, val mes : Int, val userOwnerId : String) : AsyncTask<Void, Void, MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Categoria>>(){


    override fun doInBackground(vararg params: Void?): MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Categoria> {
        return DbBuilder.getInstance(context).categoriaDAO().selectAllByStatusAndMonth(status, mes, userOwnerId)
    }

    override fun onPostExecute(result: MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Categoria>) {
        super.onPostExecute(result)
        recyclerview.adapter =
            CategoriaAdapter(
                result,
                context
            )
        recyclerview.layoutManager = LinearLayoutManager(context)
    }


}