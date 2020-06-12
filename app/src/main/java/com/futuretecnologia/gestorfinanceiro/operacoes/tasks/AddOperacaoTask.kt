package com.futuretecnologia.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import com.futuretecnologia.gestorfinanceiro.database.DbBuilder

class AddOperacaoTask(val context: Context, val nome:String, val valor:Double, val id : Int, val moeda : Double) : AsyncTask<Void, Void, String>(){

    override fun doInBackground(vararg params: Void?): String {
     val db = DbBuilder.getInstance(context)
      db.operacaoDAO().armazenarOp(
          com.futuretecnologia.gestorfinanceiro.entidades.Operacao(
              valor,
              nome,
              id,
              moeda
          )
      )
     return "Ganho adicionado"
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Toast.makeText(context, result, Toast.LENGTH_LONG).show()
    }







}