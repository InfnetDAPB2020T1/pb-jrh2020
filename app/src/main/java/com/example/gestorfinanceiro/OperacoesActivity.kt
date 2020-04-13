package com.example.gestorfinanceiro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gestorfinanceiro.operacoes.viewmodels.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_operacoes.*

class   OperacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacoes)
        var usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)
        navigation_op_adc.setupWithNavController(findNavController(R.id.fragment_operacoes_mensais))
    }
    var tmp = 0
    override fun onBackPressed() {
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var restante = millisUntilFinished
                Toast.makeText(applicationContext, "Deslogando em " + restante/1000 + " segundos", Toast.LENGTH_LONG).show()

            }
            override fun onFinish() {
                finishAffinity()
            }
        }
        if (tmp == 0){
            timer.start()
            tmp++
        }
    }
}
