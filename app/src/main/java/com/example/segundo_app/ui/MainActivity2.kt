package com.example.segundo_app.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.segundo_app.repository.CuriosityRepository
import com.example.segundo_app.R
import com.example.segundo_app.databinding.ActivityMain2Binding
import com.example.segundo_app.viewModel.MainViewModel2

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMain2Binding

    private lateinit var mainVM: MainViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mainVM = ViewModelProvider(this).get(MainViewModel2::class.java)
        setObserver()

        SharedPreferencesManager.init(this)

        binding.gerarButton.setOnClickListener(this)
        binding.cat.setOnClickListener(this)
        binding.dog.setOnClickListener(this)

        mainVM.recoverName()
    }

    private fun setObserver() {
        mainVM.getName().observe(this, Observer {
            binding.TextNome.text = "${getString(R.string.hello)}, $it!"
        })

        mainVM.getSelected().observe(this, Observer{
            if (it == 1) {
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

        })

        mainVM.getCuriosity().observe(this, Observer {
            binding.TextCuriosidade.text = it
        })
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.gerarButton -> {
                mainVM.updateCuriosity()
                Toast.makeText(applicationContext, R.string.nova_gerada, Toast.LENGTH_SHORT).show()
            }

            R.id.dog -> {
                mainVM.selectDog()
            }

            R.id.cat -> {
                mainVM.selectCat()
            }
        }
    }

}