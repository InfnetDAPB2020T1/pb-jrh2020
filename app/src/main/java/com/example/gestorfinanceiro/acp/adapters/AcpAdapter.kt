package com.example.gestorfinanceiro.acp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.gestorfinanceiro.ACPActivity
import com.example.gestorfinanceiro.R
import com.example.gestorfinanceiro.acp.fragments.ManageFragment
import com.example.gestorfinanceiro.entidades.Usuario
import kotlinx.android.synthetic.main.acp_recycle.view.*

class AcpAdapter (val users : List<Usuario>?) : RecyclerView.Adapter<AcpAdapter.AcpViewHolder>(){


    class AcpViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val userid = view.txtVw_acp_id
        val username = view.txtVw_acp_user


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcpViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.acp_recycle,parent,false)
        val usuarioViewHolder = AcpViewHolder(v)
        return usuarioViewHolder
    }

    override fun getItemCount(): Int = users!!.size

    override fun onBindViewHolder(holder: AcpViewHolder, position: Int) {
        val user = users!![position]
        holder.username.text = user.login
        holder.userid.text = user.id.toString()



    }
}