package com.example.gestorfinanceiro.acp.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room

import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.acp.adapters.AcpAdapter
import com.example.gestorfinanceiro.acp.viewmodels.UsuarioViewModel
import com.example.gestorfinanceiro.database.AppDataBase
import com.example.gestorfinanceiro.entidades.Usuario
import kotlinx.android.synthetic.main.acp_recycle.*
import kotlinx.android.synthetic.main.fragment_exibir.*
import kotlinx.android.synthetic.main.fragment_panel.*


class PanelFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_panel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var usuario : UsuarioViewModel? = null
        activity?.let {
            usuario = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }
        var db =
            Room.databaseBuilder(activity!!.applicationContext, AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()
        val usersList = db.usuarioDao().selectAll()
        var userAdapter = AcpAdapter(usersList)
        rcVw_ACP.adapter = userAdapter
        rcVw_ACP.layoutManager = LinearLayoutManager(activity!!.baseContext)
        btn_acp_sair.setOnClickListener{
            activity!!.finish()
        }
        btn_acp_edit.setOnClickListener{
            if(edTxt_acp_id.text.isNullOrBlank()){
                Toast.makeText(activity!!.baseContext, "Preencha o campo ID", Toast.LENGTH_LONG).show()
            }
            else{
                findNavController().navigate(R.id.manageFragment)
                usuario!!.user = db.usuarioDao().selectId(edTxt_acp_id.text.toString().toInt())
            }

        }

    }




}
