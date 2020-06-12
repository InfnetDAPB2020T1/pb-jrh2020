package com.futuretecnologia.gestorfinanceiro.operacoes.viewmodels

import androidx.lifecycle.ViewModel

class CategoriaViewModel : ViewModel() {
    var categoria : com.futuretecnologia.gestorfinanceiro.entidades.Categoria? = null
    var navegador = 0
    var mes = 0

    fun incrementar_mes(){
        mes++
    }
    fun decrementar_mes(){
        mes--
    }


}