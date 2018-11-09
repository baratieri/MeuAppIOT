package br.com.eduardo.meuappiot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        mAuth = FirebaseAuth.getInstance()

        BotaoCriarConta.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        botaoConectar.setOnClickListener {
            mAuth.signInWithEmailAndPassword(
                    email.text.toString(),
                    senha.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    vaiParaProximaTela()
                }else {
                    exibeErro()
                }
            }
        }
    }

    private fun exibeErro(){
        Toast.makeText(this,"Email/senha Invalido", Toast.LENGTH_SHORT).show()
    }

    private fun vaiParaProximaTela(){
        startActivity(Intent(this,
                ControlActivity::class.java))
        finish()
    }

}
