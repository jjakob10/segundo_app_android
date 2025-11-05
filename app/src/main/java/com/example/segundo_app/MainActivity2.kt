package com.example.segundo_app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.segundo_app.databinding.ActivityMain2Binding
import com.example.segundo_app.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMain2Binding;
    private var generator: CuriosityGenerator = CuriosityGenerator()
    private var selected: Int = 0

    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sp = applicationContext.getSharedPreferences("CHAVE_ACESSO", Context.MODE_PRIVATE)


        binding.gerarButton.setOnClickListener(this)
        binding.cat.setOnClickListener(this)
        binding.dog.setOnClickListener(this)


        binding.TextNome.text = "Olá, ${sp.getString("NOME", "")}"


        updateTopMenu()
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.gerarButton -> {
                updateCuriosity()
                Toast.makeText(applicationContext, R.string.nova_gerada, Toast.LENGTH_SHORT).show()
            }

            R.id.dog -> {
                if (selected == 0) {
                    selected = 1
                    updateTopMenu()
                }
            }

            R.id.cat -> {
                if (selected == 1) {
                    selected = 0
                    updateTopMenu()
                }
            }
        }
    }

    fun updateTopMenu() {
        if (selected == 1) {
            binding.cat.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.dog.setColorFilter(
                ContextCompat.getColor(
                    this,
                    R.color.md_theme_surfaceContainerHighest_mediumContrast
                )
            )
        } else {
            binding.dog.setColorFilter(ContextCompat.getColor(this, R.color.white))
            binding.cat.setColorFilter(
                ContextCompat.getColor(
                    this,
                    R.color.md_theme_surfaceContainerHighest_mediumContrast
                )
            )

        }
        binding.TextCuriosidade.text = generator.getCuriosidade(selected)
    }

    fun updateCuriosity() {
        generator.nextCuriosidade(selected)
        binding.TextCuriosidade.text = generator.getCuriosidade(selected)
    }

}