package com.example.projetoroblox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Densenvolvido para o cp3
class MainActivity : AppCompatActivity() {

    lateinit var ButtonAbrirCadastro: Button
    lateinit var btnEntrar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ButtonAbrirCadastro = findViewById(R.id.btn_cadastro)
        ButtonAbrirCadastro.setOnClickListener {

            val navegadorCadastro = Intent(this, TelaCadastro::class.java)
            startActivity(navegadorCadastro)
        }
        btnEntrar = findViewById(R.id.btn_entrar)
        btnEntrar.setOnClickListener{
            val navegarCadastrar = Intent(this, TelaCadastrar::class.java)
            startActivity(navegarCadastrar)
        }
    }
}