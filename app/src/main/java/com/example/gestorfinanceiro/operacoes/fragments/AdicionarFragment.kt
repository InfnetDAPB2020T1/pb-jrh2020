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
import com.example.gestorfinanceiro.excecoes.InvalidOperacaoException
import com.example.gestorfinanceiro.operacoes.tasks.AddOperacaoTask
import com.example.gestorfinanceiro.operacoes.viewmodels.CategoriaViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.*

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
        lateinit var categoriaViewModel: CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)

        }


        btn_Add.setOnClickListener {
            try{
                AddOperacaoTask(requireContext(), edTxt_Descricao.text.toString(), edTxt_Valor.text.toString().toDouble(), categoriaViewModel.categoria!!.id).execute()
                findNavController().navigate(R.id.fragment_Exibir)
            }
            catch (ex : InvalidOperacaoException){
                Toast.makeText(activity?.baseContext, ex.message, Toast.LENGTH_LONG).show()
            }
        }



    }


}
