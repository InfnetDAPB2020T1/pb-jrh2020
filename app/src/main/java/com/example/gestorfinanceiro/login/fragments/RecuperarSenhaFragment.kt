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

        var db =
            Room.databaseBuilder(requireContext(), AppDataBase::class.java, "appDatabase.sql").allowMainThreadQueries().build()

        btn_Recuperar.setOnClickListener{
                Toast.makeText(activity?.baseContext, "DEBUG", Toast.LENGTH_LONG).show()
        }


    }
}
