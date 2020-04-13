package com.example.gestorfinanceiro.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.gestorfinanceiro.OperacoesActivity

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
        var intent = Intent(activity!!.baseContext, OperacoesActivity::class.java)
        btn_Entrar.setOnClickListener {
            if (edTxt_Usuario.text.toString().isNullOrBlank() || edTxt_Senha.text.toString().isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha todos campos", Toast.LENGTH_LONG).show()
            }
            if(!usuariosViewModel!!.bancoDeUsuarios!!.checkUser(edTxt_Usuario.text.toString())){
                Toast.makeText(activity!!.baseContext, "Usuario nao encontrado", Toast.LENGTH_LONG).show()
            }
            else{
                if(usuariosViewModel!!.bancoDeUsuarios!!.autentica(edTxt_Usuario.text.toString(), edTxt_Senha.text.toString())){
                    intent.putExtra("usuario", usuariosViewModel!!.bancoDeUsuarios!!.getUser(edTxt_Usuario.text.toString()))
                    startActivity(intent)

                }
                else{
                    Toast.makeText(activity!!.baseContext, "Senha incorreta", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}
