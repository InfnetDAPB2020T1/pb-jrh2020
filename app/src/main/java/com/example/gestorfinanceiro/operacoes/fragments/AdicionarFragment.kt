package com.example.gestorfinanceiro.operacoes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.entidades.Usuario
import com.example.gestorfinanceiro.excecoes.InvalidOperacaoException
import com.example.gestorfinanceiro.excecoes.InvalidUserException
import com.example.gestorfinanceiro.operacoes.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.*
import java.lang.RuntimeException

class AdicionarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var usuarioViewModel: UsuarioViewModel
        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)

        }
        if(usuarioViewModel.navegador == 0){
            btn_Add.text = "Adicionar gasto"
            btn_Redirect.text = "Gastos"
        }
        else{
            btn_Add.text = "Adicionar ganho"
            btn_Redirect.text = "Ganhos"
        }
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
            btn_Add.setOnClickListener {
                try{
                    usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).adicionarGasto(
                        edTxt_Valor.text.toString().toInt(), edTxt_Descricao.text.toString())
                    Toast.makeText(activity!!.baseContext, "Gasto adicionado", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.fragment_Exibir)
                }
                catch (ex : InvalidOperacaoException){
                    Toast.makeText(activity!!.baseContext, ex.message, Toast.LENGTH_LONG).show()
                }
            }
        }
        else{
            btn_Add.setOnClickListener {
                try {
                    usuarioViewModel.usuario!!.mensais.operacoesMensais.get(mes_nav).adicionarGanho(
                        edTxt_Valor.text.toString().toInt(),edTxt_Descricao.text.toString())
                        Toast.makeText(activity!!.baseContext, "Ganho adicionado", Toast.LENGTH_LONG).show()
                        findNavController().navigate(R.id.fragment_Exibir)

                }
                catch (ex : InvalidOperacaoException){
                    Toast.makeText(activity!!.baseContext, ex.message, Toast.LENGTH_LONG).show()
                }
            }
        }
        btn_Redirect.setOnClickListener {
            if(usuarioViewModel.navegador == 0){
                usuarioViewModel.navegador = 1
            }
            else{
                usuarioViewModel.navegador = 0
            }
            findNavController().navigate(R.id.fragment_Adicionar)
        }

        btn_mProximo.setOnClickListener {
            if (mes_nav == 11){
                Toast.makeText(activity!!.baseContext, "Não mês posterior a dezembro", Toast.LENGTH_SHORT).show()
            }
            else{
                usuarioViewModel.incrementar_mes()
                findNavController().navigate(R.id.fragment_Adicionar)
            }


        }
        btn_mAnterior.setOnClickListener {
            if (mes_nav == 0){
                Toast.makeText(activity!!.baseContext, "Não mês anterior a janeiro", Toast.LENGTH_SHORT).show()
            }
            else{
                usuarioViewModel.decrementar_mes()
                findNavController().navigate(R.id.fragment_Adicionar)
            }

        }


    }


}
