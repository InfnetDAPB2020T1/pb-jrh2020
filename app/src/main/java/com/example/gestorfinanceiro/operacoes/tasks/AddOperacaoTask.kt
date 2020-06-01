package com.example.gestorfinanceiro.operacoes.tasks

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import com.example.gestorfinanceiro.api.CotacaoService
import com.example.gestorfinanceiro.database.DbBuilder
import com.example.gestorfinanceiro.entidades.Cotacao
import com.example.gestorfinanceiro.entidades.Operacao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddOperacaoTask(val context: Context, val nome:String, val valor:Double, val id : Int, val moeda : Double) : AsyncTask<Void, Void, String>(){

    override fun doInBackground(vararg params: Void?): String {
     val db = DbBuilder.getInstance(context)
      db.operacaoDAO().armazenarOp(Operacao(valor, nome, id, moeda))
     return "Ganho adicionado"
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        Toast.makeText(context, result, Toast.LENGTH_LONG).show()
    }







}