package com.example.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import com.example.gestorfinanceiro.database.DbBuilder
import com.example.gestorfinanceiro.entidades.Operacao
import com.example.gestorfinanceiro.operacoes.fragments.ExibirFragment
import com.example.gestorfinanceiro.operacoes.viewmodels.CategoriaViewModel

class SetupListTask(val context: Context, val fragment : ExibirFragment, val id:Int) : AsyncTask<Void, Void, MutableList<Operacao>>() {

    override fun doInBackground(vararg params: Void?): MutableList<Operacao> {
        return DbBuilder.getInstance(context).operacaoDAO().selectOpsByUserId(id)
    }

    override fun onPostExecute(result: MutableList<Operacao>) {
        super.onPostExecute(result)
        fragment.setList(result)
    }
}