package com.example.gestorfinanceiro.operacoes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gestorfinanceiro.entidades.Categoria

class CategoriaViewModel : ViewModel() {
    var categoria : Categoria? = null
    var navegador = 0
    var mes = 0

    fun incrementar_mes(){
        mes++
    }
    fun decrementar_mes(){
        mes--
    }


}