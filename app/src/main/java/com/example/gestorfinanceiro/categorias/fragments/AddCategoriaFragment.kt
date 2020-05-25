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
import com.example.gestorfinanceiro.categorias.tasks.AddCategoriaTask
import com.example.gestorfinanceiro.categorias.viewmodels.CategoriaViewModel
import com.example.gestorfinanceiro.database.DbBuilder
import com.example.gestorfinanceiro.entidades.Categoria
import kotlinx.android.synthetic.main.fragment_add_categoria.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class AddCategoriaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_categoria, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var categoriaViewModel: CategoriaViewModel
        activity?.let {
            categoriaViewModel = ViewModelProviders.of(it).get(CategoriaViewModel::class.java)
        }
        var mes_nav = categoriaViewModel.mes
        var navegador = categoriaViewModel.navegador
        if (navegador == true){
            btn_gg.text = "Ganhos"
        }else{
            btn_gg.text = "Gastos"
        }
        btn_gg.setOnClickListener {
            if (navegador == true){
                navegador = false
                btn_gg.text = "Gastos"
            }else{
                navegador = true
                btn_gg.text = "Ganhos"
            }
        }

        btn_AddCategoria.setOnClickListener {
            AddCategoriaTask(requireContext(), edTxt_categoria.text.toString(), categoriaViewModel.navegador, mes_nav).execute()
            findNavController().navigate(R.id.exibirCategoriaFragment)
        }
    }


}
