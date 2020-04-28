package com.example.gestorfinanceiro.acp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.room.Room

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.acp.viewmodels.UsuarioViewModel
import com.example.gestorfinanceiro.database.AppDataBase
import kotlinx.android.synthetic.main.fragment_manage.*


class ManageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var usuario : UsuarioViewModel? = null
        activity?.let {
            usuario = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }
        var db =
            Room.databaseBuilder(activity!!.applicationContext, AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()

        txtVw_acpm_user.text = usuario!!.user!!.login
        txtVw_acpm_cpf.text = usuario!!.user!!.cpf
        btn_acpm_delete.setOnClickListener {
            Toast.makeText(activity!!.baseContext, "Usuario: " + usuario!!.user!!.login + " deletado", Toast.LENGTH_LONG).show()
            db.usuarioDao().delete(usuario!!.user)
            findNavController().navigate(R.id.panelFragment)
        }
        btn_acpm_edit.setOnClickListener {
            val newuser = edTxt_acpm_login.text.toString()
            val newpass = edTxt_acpm_password.text.toString()
            val newcpf = edTxt_acpm_cpf.text.toString()

            if (edTxt_acpm_login.text.isNullOrBlank() && edTxt_acpm_password.text.isNullOrBlank() && edTxt_acpm_cpf.text.isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha pelo menos um dos campos", Toast.LENGTH_LONG).show()
            }
            else{
                if (!newuser.isNullOrBlank()){
                    db.usuarioDao().updateLogin(usuario!!.user!!.id, newuser)
                }
                if (!newpass.isNullOrBlank()){
                    db.usuarioDao().updatePassword(usuario!!.user!!.id, newpass)
                }
                if (!newcpf.isNullOrBlank()){
                    db.usuarioDao().updateCpf(usuario!!.user!!.id, newcpf)

                }
            }
            Toast.makeText(activity!!.baseContext, "Usuario: " + usuario!!.user!!.login + " atualizado", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.panelFragment)
        }

    }


}
