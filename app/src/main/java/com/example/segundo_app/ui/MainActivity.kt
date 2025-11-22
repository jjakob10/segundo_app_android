package com.example.segundo_app.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.segundo_app.R
import com.example.segundo_app.databinding.ActivityMainBinding
import com.example.segundo_app.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var mainVM: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainVM = ViewModelProvider(this).get(MainViewModel::class.java)
        setObserver()

        SharedPreferencesManager.init(this)
        binding.buttonGuardar.setOnClickListener(this)
        mainVM.recoverName()
    }

    private fun setObserver() {
        mainVM.getName().observe(this, Observer {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        })
    }


    override fun onClick(view: View) {
        if (view.id == R.id.buttonGuardar) {
            val nome = binding.EditTextNome.text.toString()
            if (nome == "") {
                Toast.makeText(applicationContext, R.string.nome_valido, Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "${getString(R.string.saved)}: $nome", Toast.LENGTH_SHORT).show()
                mainVM.saveName(nome)
            }
        }
    }

}
