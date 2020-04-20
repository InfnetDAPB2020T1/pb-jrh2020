package com.example.gestorfinanceiro

import android.content.Context
import com.example.gestorfinanceiro.entidades.Operacao
import com.example.gestorfinanceiro.entidades.Usuario
import com.example.gestorfinanceiro.excecoes.InvalidOperacaoException
import com.example.gestorfinanceiro.excecoes.InvalidUserException
import org.junit.Test

import org.junit.Assert.*
import java.lang.RuntimeException
import kotlin.math.log

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTests {
    lateinit var usuario : Usuario
    lateinit var operacao : Operacao

    @Test
    fun user_name_isValid() {
        try{
            usuario = Usuario("jjjjjjjjjjjjjjjjjjjjjjjj1", "123", "190")
            assertTrue(false)
        }
        catch (ex : InvalidUserException){
            print(ex.message)
            assertEquals("Usuario maior que 20 caracteres", ex.message)
        }

    }

    @Test
    fun user_password_isValid() {
       try{
           usuario = Usuario("j", "12345678911111111", "190")
           assertTrue(false)
       }
       catch (ex : RuntimeException){
           print(ex.message)
           assertEquals("Senha maior que 15 caracteres", ex.message)
       }

    }

    @Test
    fun user_cpf_isValid() {
        try{
            usuario = Usuario("j", "123", "555555555555555")
            assertTrue(false)
        }
        catch (ex : InvalidUserException){
            print(ex.message)
            assertEquals("CPF inválido", ex.message)
        }

    }

    @Test
    fun operacao_categoria_isValid() {
        try{
            operacao = Operacao(500, "1111111111111111111111111111111111111111111111111111111111111")
            assertTrue(false)
        }
        catch (ex : InvalidOperacaoException){
            print(ex.message)
            assertEquals("A descrição deve ter menos de 60 caracteres", ex.message)
        }

    }

    @Test
    fun usuario_m_getGanhosTotais() {
        usuario = Usuario("j", "123", "123")
        usuario.addGanho(1500, "T")
        usuario.addGanho(1500, "T")
        var total = usuario.ganhosTotais
        assertEquals(total, 3000.0, 0.0001)
    }

    @Test
    fun usuario_m_getGastosTotais() {
        usuario = Usuario("j", "123", "123")
        usuario.addGasto(2000, "T")
        usuario.addGasto(2000, "T")
        var total = usuario.gastosTotais
        assertEquals(total, 4000.0, 0.0001)
    }


}
