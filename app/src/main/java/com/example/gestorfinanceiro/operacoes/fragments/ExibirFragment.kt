package com.example.gestorfinanceiro.operacoes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.database.AppDataBase
import com.example.gestorfinanceiro.entidades.Usuario
import com.example.gestorfinanceiro.operacoes.adapters.OperacaoAdapter
import com.example.gestorfinanceiro.operacoes.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_exibir.*

/**
 * A simple [Fragment] subclass.
 */
class ExibirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exibir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var usuarioViewModel:UsuarioViewModel
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }
        var db =
            Room.databaseBuilder(activity!!.applicationContext, AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()
        var userlogin = activity?.intent!!.getStringExtra("usuario")
        usuarioViewModel.usuario = db.usuarioDao().selectLogin(userlogin)
        var mes_nav = usuarioViewModel.mes
        txtVw_Mes.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).mes
        if(mes_nav == 0){
            btn_mAnterior.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).mes
            btn_mProximo.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav+1).mes
        }
        else if(mes_nav == 11){
            btn_mAnterior.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav-1).mes
            btn_mProximo.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).mes
        }
        else{
            btn_mAnterior.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav-1).mes
            btn_mProximo.text = usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav+1).mes
        }
        if(usuarioViewModel.navegador == 0){
            btn_Redirect.text = "Gastos"
            var gastoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).gastos)
            rcVw_Exibir.adapter = gastoAdapter
            rcVw_Exibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de gastos mensais: R$" + usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).gastosTotais
        }
        else{
            btn_Redirect.text = "Ganhos"
            var ganhoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).ganhos)
            rcVw_Exibir.adapter = ganhoAdapter
            rcVw_Exibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de ganhos mensais: R$" + usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).ganhosTotais
        }
        btn_Redirect.setOnClickListener {
            if(usuarioViewModel.navegador == 0){
                usuarioViewModel.navegador = 1
            }
            else{
                usuarioViewModel.navegador = 0
            }
             findNavController().navigate(R.id.fragment_Exibir)
        }
        btn_mProximo.setOnClickListener {
            if (mes_nav == 11){
                Toast.makeText(activity!!.baseContext, "Não mês posterior a dezembro", Toast.LENGTH_SHORT).show()
            }
            else{
                usuarioViewModel.incrementar_mes()
                findNavController().navigate(R.id.fragment_Exibir)
            }


        }
        btn_mAnterior.setOnClickListener {
            if (mes_nav == 0){
                Toast.makeText(activity!!.baseContext, "Não mês anterior a janeiro", Toast.LENGTH_SHORT).show()
            }
            else{
                usuarioViewModel.decrementar_mes()
                findNavController().navigate(R.id.fragment_Exibir)
            }

        }


    }


}
