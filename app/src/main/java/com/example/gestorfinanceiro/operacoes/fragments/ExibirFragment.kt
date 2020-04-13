package com.example.gestorfinanceiro.operacoes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.gestorfinanceiro.R
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
        usuarioViewModel.usuario = activity?.intent!!.getSerializableExtra("usuario") as Usuario
        if(usuarioViewModel.navegador == 0){
            btn_Redirect.text = "Gastos"
            var gastoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.gastos)
            rcVw_Exibir.adapter = gastoAdapter
            rcVw_Exibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de gastos mensais: R$" + usuarioViewModel.usuario!!.gastosTotais
        }
        else{
            btn_Redirect.text = "Ganhos"
            var ganhoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.ganhos)
            rcVw_Exibir.adapter = ganhoAdapter
            rcVw_Exibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de ganhos mensais: R$" + usuarioViewModel.usuario!!.ganhosTotais
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


    }


}
