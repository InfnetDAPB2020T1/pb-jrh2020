package com.example.gestorfinanceiro.operacoes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.entidades.Operacao
import kotlinx.android.synthetic.main.gasto_recycle.view.*
import java.util.ArrayList

class OperacaoAdapter (val operacoes : ArrayList<Operacao>?) : RecyclerView.Adapter<OperacaoAdapter.GastoViewHolder>(){

    class GastoViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val titulo = view.txtVwTitulo
        val texto = view.txtVwTexto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.gasto_recycle,parent,false)
        val usuarioViewHolder = GastoViewHolder(v)
        return usuarioViewHolder
    }

    override fun getItemCount(): Int = operacoes!!.size

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        val operacao = operacoes!![position]
        holder.titulo.text = operacao.descricao
        holder.texto.text = "R$" + operacao.valor.toString()
    }

}