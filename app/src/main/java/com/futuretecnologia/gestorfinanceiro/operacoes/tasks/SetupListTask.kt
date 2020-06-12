package com.futuretecnologia.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import com.futuretecnologia.gestorfinanceiro.database.DbBuilder
import com.futuretecnologia.gestorfinanceiro.operacoes.fragments.ExibirFragment

class SetupListTask(val context: Context, val fragment : ExibirFragment, val id:Int) : AsyncTask<Void, Void, MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Operacao>>() {

    override fun doInBackground(vararg params: Void?): MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Operacao> {
        return DbBuilder.getInstance(context).operacaoDAO().selectOpsByUserId(id)
    }

    override fun onPostExecute(result: MutableList<com.futuretecnologia.gestorfinanceiro.entidades.Operacao>) {
        super.onPostExecute(result)
        fragment.setList(result)
    }
}