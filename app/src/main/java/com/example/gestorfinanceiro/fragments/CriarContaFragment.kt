package com.example.gestorfinanceiro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.viewmodels.BancoUsuariosViewModel
import kotlinx.android.synthetic.main.fragment_criar_conta.*


class CriarContaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_criar_conta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var usuarioViewModel: BancoUsuariosViewModel? = null

        activity?.let {
            usuarioViewModel = ViewModelProviders.of(it)
                .get(BancoUsuariosViewModel::class.java)

        }

        botao_criar.setOnClickListener {
            if(editText_nome.text.toString().isNullOrBlank() || editText_senha.text.toString().isNullOrBlank()
                || editText_cpf.text.toString().isNullOrBlank()){
                Toast.makeText(activity?.baseContext, "Preencha todos campos!", Toast.LENGTH_LONG).show()
            }
            else{
                usuarioViewModel!!.bancoDeUsuarios!!.addUsuario(
                    editText_nome.text.toString(),
                    editText_senha.text.toString(),
                    editText_cpf.text.toString())
                Toast.makeText(activity?.baseContext, "Conta criada!", Toast.LENGTH_LONG).show()
                usuarioViewModel!!.bancoDeUsuarios.debug()

            }

            }
    }
}
