package com.example.gestorfinanceiro.entidades

import androidx.room.Embedded
import androidx.room.Relation

data class UsuarioEOperacao(
    @Embedded val usuario: Usuario,
    @Relation(parentColumn = "id", entityColumn = "userOwnerId")
    var operacao: Operacao?

)
