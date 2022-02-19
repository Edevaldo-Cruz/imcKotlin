package com.example.imcapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
            // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        pesoEDT?.doOnTextChanged { text, _, _, _->
            // titleTXT, text = text
        }
        botaoBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

         if (peso != null && altura != null) {

            val imc = peso / (altura * altura)
            titleTXT.text = "Seu IMC é: ${imc}".format(imc)
        } else {
            titleTXT.text = "Por favor preencha os campos de Altura e Peso. "
        }
        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            var result = " "
            when {
                imc < 18.4 -> {
                    result = "Abaixo do peso"
                    resultTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.nivel1))
                }
                imc in 18.5..24.9 -> {
                    result = "Peso normal"
                    resultTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.nivel2))
                }
                imc in 25.0..29.9 -> {
                    result = "Excesso de peso"
                    resultTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.nivel3))
                }
                imc in 30.0..35.9 -> {
                    result = "Obesidade"
                    resultTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.nivel4))
                }
                imc > 35 -> {
                    result = "Super obesidade"
                    resultTXT.setBackgroundColor(ContextCompat.getColor(this, R.color.nivel5))
                }
                else -> {
                    resultTXT.text = "Valores invalidado!"
                    resultTXT.setTextColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            resultTXT.text = "Segundo os padrões internacionais você foi considerado com $result."

        } else {
            resultTXT.text = "Por favor preencha os campos de Altura e Peso. "
        }



    }
}