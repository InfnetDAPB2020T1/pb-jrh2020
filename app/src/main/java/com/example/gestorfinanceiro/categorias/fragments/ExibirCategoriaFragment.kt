package com.example.gestorfinanceiro.categorias.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.categorias.tasks.MakeRecyclerViewTask
import com.example.gestorfinanceiro.categorias.viewmodels.CategoriaViewModel
import kotlinx.android.synthetic.main.fragment_exibir_categoria.*

/**
 * A simple [Fragment] subclass.
 */
class ExibirCategoriaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exibir_categoria, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var categoriaViewModel:CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)
        }
        var mes_nav = categoriaViewModel.mes
        MakeRecyclerViewTask(requireContext(), rcVw_Categoria, categoriaViewModel.navegador, mes_nav).execute()
        if (categoriaViewModel.navegador == true){
            btn_gg.text = "Ganhos ${categoriaViewModel.getMesNome(mes_nav)}"
        }else{
            btn_gg.text = "Gastos ${categoriaViewModel.getMesNome(mes_nav)}"
        }
        if(mes_nav == 0){
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav+1)
        }
        else if(mes_nav == 11){
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav-1)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav)
        }
        else{
            btn_mAnterior.text = categoriaViewModel.getMesNome(mes_nav-1)
            btn_mProximo.text = categoriaViewModel.getMesNome(mes_nav+1)
        }
        btn_mProximo.setOnClickListener {
            if (mes_nav == 11){
                Toast.makeText(activity?.baseContext, "Não há mês posterior a dezembro", Toast.LENGTH_SHORT).show()
            }
            else{
                categoriaViewModel.incrementar_mes()
                findNavController().navigate(R.id.exibirCategoriaFragment)
            }


        }
        btn_mAnterior.setOnClickListener {
            if (mes_nav == 0){
                Toast.makeText(activity?.baseContext, "Não há mês anterior a janeiro", Toast.LENGTH_SHORT).show()
            }
            else{
                categoriaViewModel.decrementar_mes()
                findNavController().navigate(R.id.exibirCategoriaFragment)
            }

        }
        btn_gg.setOnClickListener {
            if (categoriaViewModel.navegador == true){
                categoriaViewModel.navegador = false
                Toast.makeText(requireContext(), categoriaViewModel.navegador.toString(), Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.exibirCategoriaFragment)

            }else{
                categoriaViewModel.navegador = true
                Toast.makeText(requireContext(), categoriaViewModel.navegador.toString(), Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.exibirCategoriaFragment)
            }
        }
    }


}
