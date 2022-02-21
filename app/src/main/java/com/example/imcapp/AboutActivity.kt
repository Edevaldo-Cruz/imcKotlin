package com.example.imcapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        returnBtn.setOnClickListener {
            //back()
            finish()
        }
    }
    /*
        Função de navegação desativada, para usar função do sistema

    private fun back() {
       val btn_back = Intent( this, MainActivity::class.java)
        startActivity(btn_back)
    }
     */
}