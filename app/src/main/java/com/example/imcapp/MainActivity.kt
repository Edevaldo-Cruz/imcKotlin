package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.imcapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        botaoBtn.setOnClickListener {
          setListeners()
        }

        /*
            Primeira parte da função de navegação:
                Selecionado o elemento para ação de navegação
         */
        aboutBtn.setOnClickListener {
            clickAbout()
        }
        info.setOnClickListener {
            clickAbout()
        }
    }
        /*
            Segunda parte da função de navegação:
                Criando função para executar determinda ação
         */
    private fun clickAbout() {
            val about = Intent( this,
                AboutActivity::class.java)
            startActivity(about)
    }

    private fun setListeners() {

        binding.alturaEdt.doAfterTextChanged { text ->
            // Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.pesoEdt.doOnTextChanged { text, _, _, _->
            // titleTXT, text = text
        }

        binding.botaoBtn.setOnClickListener {
            calcularIMC(binding.pesoEdt.text.toString(),
                binding.alturaEdt.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

         if (peso != null && altura != null) {

            val imc = peso / (altura * altura)

             val intent = Intent(this, ResultActivity::class.java)
             intent.putExtra("imc", imc)
             startActivity(intent)
         } else {
             binding.titleApp.text = getString(R.string.label_warning)
         }
    }
}