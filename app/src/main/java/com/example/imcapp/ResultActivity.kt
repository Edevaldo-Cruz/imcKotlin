package com.example.imcapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.imcapp.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*
import java.text.DecimalFormat

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Função recover é inicializada junto com a construção da tela.
        recoverData()

        // Botão de fechar
        btnClose.setOnClickListener {
            closeBtn()
        }
    }
    @SuppressLint("SetTextI18n")
    private fun recoverData() {
        // set configuração da casa decimais.
        val dec = DecimalFormat("###.00")

        //Converte imc de string para float
        val imc = intent.getFloatExtra("imc",0.00f)

        // Formarta o val imc conforme a val dec.
        val imcFormat = dec.format(imc)
        binding.resultIMC.text = imcFormat.toString()
        var result = "result"
        //Condicionais para construir a tela.
        when {
            imc in 16.0..16.9 -> {
                result = getString(R.string.label_imc_16)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel5
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_16)
                binding.titleHelp.text = getString(R.string.label_increase_BMI)
                binding.txtHelp.text = getString(R.string.label_text_increase_BMI)
            }
            imc in 17.0..18.4 -> {
                result = getString(R.string.label_imc_17)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel1
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_17)
                binding.titleHelp.text = getString(R.string.label_increase_BMI)
                binding.txtHelp.text = getString(R.string.label_text_increase_BMI)
            }
            imc in 18.5..24.9 -> {
                result = getString(R.string.label_imc_18_5)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel2
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_18_5)
                binding.titleHelp.text = null
                binding.txtHelp.text = null
            }
            imc in 24.91..29.9 -> {
                result = getString(R.string.label_imc_25)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel3
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_25)
                binding.titleHelp.text = getString(R.string.label_download_BMI)
                binding.txtHelp.text = getString(R.string.label_text_download_BMI)
            }
            imc in 29.91..34.9 -> {
                result = getString(R.string.label_imc_30)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel4
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_30)
                binding.titleHelp.text = getString(R.string.label_download_BMI)
                binding.txtHelp.text = getString(R.string.label_text_download_BMI)
            }
            imc in 34.91..40.0 -> {
                result = getString(R.string.label_imc_35)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel5
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_35)
                binding.titleHelp.text = getString(R.string.label_download_BMI)
                binding.txtHelp.text = getString(R.string.label_text_download_BMI)
            }
            imc > 40.1 -> {
                result = getString(R.string.label_imc_40_1)
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this,
                    R.color.nivel5
                ))
                binding.textResult.text = getString(R.string.label_Symptoms_40)
                binding.titleHelp.text = getString(R.string.label_download_BMI)
                binding.txtHelp.text = getString(R.string.label_text_download_BMI)
            }
            else -> {
                binding.resultIMC.text = getString(R.string.label_imc_Invalid)
                binding.resultYour.setTextColor(ContextCompat.getColor(this, R.color.white))
                binding.resultYour.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                binding.textResult.text =  "Os valores digitado não se enquadram nos paranmentros do calculo do IMC."
                binding.titleHelp.text = null
                binding.txtHelp.text = "Revise os números digitado."
                binding.subtitleResult.text = null
                binding.sourceHelp.text = null
            }
        }
        binding.resultYour.text = "Segundo os padrões internacionais você foi considerado como $result."
    }

    //Retorna para activity main
    private fun closeBtn() {
       finish()
    }


}