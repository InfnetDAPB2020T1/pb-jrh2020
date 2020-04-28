package com.example.gestorfinanceiro.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.database.AppDataBase
import com.example.gestorfinanceiro.viewmodels.BancoUsuariosViewModel
import kotlinx.android.synthetic.main.fragment_recuperar_senha.*
import kotlin.math.log


class RecuperarSenhaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recuperar_senha, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var usuariosViewModel : BancoUsuariosViewModel? = null
        activity?.let {
            usuariosViewModel = ViewModelProviders.of(it).get(BancoUsuariosViewModel::class.java)
        }
        var db =
            Room.databaseBuilder(activity!!.applicationContext, AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()
        fun debugdb(){
            var tmp_str = ""
            var tmp_i = 1
            var getList = db.usuarioDao().selectAll()
            for (usuario in getList) {
                tmp_str = usuario.login + " " + usuario.senha
                Log.d("Usuario: " + tmp_i, tmp_str)
                tmp_i++
            }

        }
        btn_Recuperar.setOnClickListener{
            var login = edTxt_Usuario.text.toString()
            var cpf = edTxt_CPF.text.toString()
            if (login.isNullOrBlank() || cpf.isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha todos campos", Toast.LENGTH_LONG).show()
            }
            if(usuariosViewModel!!.bancoDeUsuarios!!.checkUser(login) == false){
                Toast.makeText(activity!!.baseContext, "Usuario nao encontrado", Toast.LENGTH_LONG).show()
                debugdb()
            }
            else{
                Toast.makeText(activity!!.baseContext,usuariosViewModel!!.bancoDeUsuarios!!.getUser(login).recuperarSenha(login, cpf),
                    Toast.LENGTH_LONG).show()

            }
        }

    }
}
