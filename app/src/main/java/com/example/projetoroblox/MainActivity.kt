package com.example.projetoroblox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var ButtonAbrirCadastro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ButtonAbrirCadastro = findViewById(R.id.btn_cadastro)
        ButtonAbrirCadastro.setOnClickListener {

            val navegadorCadastro = Intent(this, TelaCadastro::class.java)
            startActivity(navegadorCadastro)
        }
    }
}