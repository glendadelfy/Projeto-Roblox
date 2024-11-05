package com.example.projetoroblox

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoroblox.databinding.ActivityTelaCadastrarBinding
import com.google.firebase.auth.FirebaseAuth

class TelaCadastrar : AppCompatActivity() {
    private val binding by lazy{
        ActivityTelaCadastrarBinding.inflate(layoutInflater)
    }
    val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onStart() {
        super.onStart()
        verificarUsuarioLogado()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCadastrar.setOnClickListener {
            cadastrarUsuario()
        }
    }
        private fun cadastrarUsuario(){
            val email  = binding.editEmailCadastro.text.toString()
            val senha = binding.editSenhaCadastro.text.toString()


            //Passar os paramentros para criação do usuario $email e $senha
            autenticacao.createUserWithEmailAndPassword(email,senha)
                .addOnSuccessListener { authResult->
                    AlertDialog.Builder(this)
                        .setTitle("SUCESSO!!!")
                        .setMessage("Sucesso ao criar conta!!")
                        .setPositiveButton("Fechar") { dialog, posicao ->
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        .setCancelable(false).create().show()

                }.addOnFailureListener{exception ->
                    val mensagemErro = exception.message
                    AlertDialog.Builder(this)
                        .setTitle("ERRO")
                        .setMessage("Erro ao criar conta")
                        .setPositiveButton("Fechar"){dialog, posicao->}
                        .create().show()

                }
        }
        private fun verificarUsuarioLogado() {
            val usuario = autenticacao.currentUser
            if (usuario != null) {
                startActivity(
                    Intent(this, TelaDev::class.java)
                )
            }
        }
}