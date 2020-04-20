package com.example.gestorfinanceiro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.viewmodels.BancoUsuariosViewModel
import kotlinx.android.synthetic.main.fragment_criar_conta.*
import java.lang.RuntimeException


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


        btn_Crie_Conta.setOnClickListener {
            if(edTxt_Usuario.text.toString().isNullOrBlank() || edTxt_Senha.text.toString().isNullOrBlank()
                || edTxt_CPF.text.toString().isNullOrBlank()){
                Toast.makeText(activity?.baseContext, "Preencha todos campos!", Toast.LENGTH_LONG).show()
            }
            else{
                try{
                    usuarioViewModel!!.bancoDeUsuarios!!.addUsuario(
                        edTxt_Usuario.text.toString(),
                        edTxt_Senha.text.toString(),
                        edTxt_CPF.text.toString())
                    Toast.makeText(activity?.baseContext, "Conta criada!", Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.login_dest)

                }
                catch (ex : Throwable){
                    Toast.makeText(activity!!.baseContext, ex.message, Toast.LENGTH_LONG).show()
                }

            }

            }
    }
}
