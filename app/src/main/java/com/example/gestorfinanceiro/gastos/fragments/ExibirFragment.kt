package com.example.gestorfinanceiro.gastos.fragments


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
import com.example.gestorfinanceiro.gastos.adapters.OperacaoAdapter
import com.example.gestorfinanceiro.gastos.viewmodels.UsuarioViewModel
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
            btnRedirect.text = "Gastos"
            var gastoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.gastos)
            rcVwExibir.adapter = gastoAdapter
            rcVwExibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de gastos mensais: R$" + usuarioViewModel.usuario!!.gastosTotais
        }
        else{
            btnRedirect.text = "Ganhos"
            var ganhoAdapter = OperacaoAdapter(usuarioViewModel.usuario!!.ganhos)
            rcVwExibir.adapter = ganhoAdapter
            rcVwExibir.layoutManager = LinearLayoutManager(activity!!.baseContext)
            txtVwTotal.text = "Total de ganhos mensais: R$" + usuarioViewModel.usuario!!.ganhosTotais
        }
        btnRedirect.setOnClickListener {
            if(usuarioViewModel.navegador == 0){
                usuarioViewModel.navegador = 1
            }
            else{
                usuarioViewModel.navegador = 0
            }
             findNavController().navigate(R.id.exibirFragment)
        }


    }


}
