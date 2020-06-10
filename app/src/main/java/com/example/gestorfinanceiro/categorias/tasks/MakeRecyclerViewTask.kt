package com.example.gestorfinanceiro.categorias.tasks

import android.content.Context
import android.os.AsyncTask
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorfinanceiro.categorias.adapter.CategoriaAdapter
import com.example.gestorfinanceiro.database.DbBuilder
import com.example.gestorfinanceiro.entidades.Categoria

class MakeRecyclerViewTask(val context: Context, val recyclerview : RecyclerView, val status : Boolean, val mes : Int, val userOwnerId : String) : AsyncTask<Void, Void, MutableList<Categoria>>(){


    override fun doInBackground(vararg params: Void?): MutableList<Categoria> {
        return DbBuilder.getInstance(context).categoriaDAO().selectAllByStatusAndMonth(status, mes, userOwnerId)
    }

    override fun onPostExecute(result: MutableList<Categoria>) {
        super.onPostExecute(result)
        recyclerview.adapter = CategoriaAdapter(result, context)
        recyclerview.layoutManager = LinearLayoutManager(context)
    }


}