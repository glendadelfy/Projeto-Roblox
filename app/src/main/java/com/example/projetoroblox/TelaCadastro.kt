package com.example.projetoroblox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaCadastro : AppCompatActivity() {

    lateinit var buttonVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_cadastro)

        buttonVoltar = findViewById(R.id.btnVoltar)
        buttonVoltar.setOnClickListener{
            val navegadorVoltar = Intent(this, MainActivity::class.java)
            startActivity(navegadorVoltar)
        }
        lateinit var buttonEntrar: Button
        buttonEntrar = findViewById(R.id.btnEntrar2)
        buttonEntrar.setOnClickListener{
            val navegadorDev = Intent(this, TelaDev:: class.java)
            startActivity(navegadorDev)
        }

    }
}