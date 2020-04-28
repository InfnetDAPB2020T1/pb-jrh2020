package com.example.gestorfinanceiro.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.example.gestorfinanceiro.ACPActivity
import com.example.gestorfinanceiro.OperacoesActivity

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.database.AppDataBase
import com.example.gestorfinanceiro.viewmodels.BancoUsuariosViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.RuntimeException


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
        var db =
            Room.databaseBuilder(activity!!.applicationContext, AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()
        var intent = Intent(activity!!.baseContext, OperacoesActivity::class.java)
        btn_Entrar.setOnClickListener {
            if (edTxt_Usuario.text.toString().isNullOrBlank() || edTxt_Senha.text.toString().isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha todos campos", Toast.LENGTH_LONG).show()
            }
            else{
                if (edTxt_Usuario.text.toString().equals("admin") && edTxt_Senha.text.toString().equals("123")){
                    var a_intent = Intent(activity!!.baseContext, ACPActivity::class.java)
                    startActivity(a_intent)
                }
                else{
                    var user = db.usuarioDao().selectLogin(edTxt_Usuario.text.toString())
                    var autentica : Boolean = user.senha.equals(edTxt_Senha.text.toString())
                    if(autentica){
                        intent.putExtra("usuario", edTxt_Usuario.text.toString())
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(activity!!.baseContext, "Dados incorretos", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

}
