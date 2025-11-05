package com.example.segundo_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.segundo_app.databinding.ActivityMainBinding
import kotlin.apply

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = applicationContext.getSharedPreferences("CHAVE_ACESSO", Context.MODE_PRIVATE)


        binding.buttonGuardar.setOnClickListener(this)

        val nomeObtido = sp.getString("NOME", "")
        if(nomeObtido != ""){
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }


    override fun onClick(view: View) {
        if (view.id == R.id.buttonGuardar) {
            val nome = binding.EditTextNome.text.toString()
            if (nome == "") {
                Toast.makeText(applicationContext, R.string.nome_valido, Toast.LENGTH_SHORT).show()
            }
            else {
                sp.edit().putString("NOME",nome ).apply()
                val nomeObtido = sp.getString("NOME", "")
                Toast.makeText(applicationContext, "Nome salvo: $nomeObtido", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity2::class.java))
                finish()
            }
        }
    }

}
