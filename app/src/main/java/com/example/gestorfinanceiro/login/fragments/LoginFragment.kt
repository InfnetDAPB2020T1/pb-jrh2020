package com.example.gestorfinanceiro.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.viewmodels.BancoUsuariosViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var usuariosViewModel : BancoUsuariosViewModel? = null
        activity?.let {
            usuariosViewModel = ViewModelProviders.of(it).get(BancoUsuariosViewModel::class.java)
        }

        botao_logar.setOnClickListener {
            if (editText_nome.text.toString().isNullOrBlank() || editText_senha.text.toString().isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha todos campos", Toast.LENGTH_LONG).show()
            }
            if(!usuariosViewModel!!.bancoDeUsuarios!!.checkUser(editText_nome.text.toString())){
                Toast.makeText(activity!!.baseContext, "Usuario nao encontrado", Toast.LENGTH_LONG).show()
            }
            else{
                if(usuariosViewModel!!.bancoDeUsuarios!!.autentica(editText_nome.text.toString(), editText_senha.text.toString())){
                    Toast.makeText(activity!!.baseContext, "Login feito com sucesso!", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(activity!!.baseContext, "Senha incorreta", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
