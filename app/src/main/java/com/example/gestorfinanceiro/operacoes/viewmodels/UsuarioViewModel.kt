package com.example.gestorfinanceiro.operacoes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gestorfinanceiro.entidades.Usuario

class UsuarioViewModel : ViewModel() {
    var usuario : Usuario? = null
    var navegador = 0
}