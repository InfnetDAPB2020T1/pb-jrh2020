package com.example.gestorfinanceiro.gastos.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.entidades.Usuario
import com.example.gestorfinanceiro.gastos.viewmodels.UsuarioViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_operacoes.*
import kotlinx.android.synthetic.main.fragment_adicionar.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*

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
            btnAdd.text = "Adicionar gasto"
            btnRedirect.text = "Gastos"
        }
        else{
            btnAdd.text = "Adicionar ganho"
            btnRedirect.text = "Ganhos"

        }
        usuarioViewModel.usuario = activity?.intent!!.getSerializableExtra("usuario") as Usuario
        if(usuarioViewModel.navegador == 0){
            btnAdd.setOnClickListener {
                usuarioViewModel.usuario!!.addGasto(edTxtValor.text.toString().toInt(), edTxtTitle.text.toString())
            }
        }
        else{
            btnAdd.setOnClickListener {
                usuarioViewModel.usuario!!.addGanho(edTxtValor.text.toString().toInt(), edTxtTitle.text.toString())
            }
        }

        btnRedirect.setOnClickListener {
            if(usuarioViewModel.navegador == 0){
                usuarioViewModel.navegador = 1
            }
            else{
                usuarioViewModel.navegador = 0
            }
            findNavController().navigate(R.id.adicionarFragment)
        }


    }


}
