package com.example.segundo_app.viewModel

import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.segundo_app.R
import com.example.segundo_app.repository.CuriosityRepository

class MainViewModel2(application: Application) : AndroidViewModel(application) {

    private var generator: CuriosityRepository = CuriosityRepository()
    private var name = MutableLiveData<String>()
    private var selected = MutableLiveData(0)
    private var curiosity = MutableLiveData<String>()

    fun getCuriosity(): LiveData<String> {
        return curiosity
    }

    fun getSelected(): LiveData<Int> {
        return selected
    }
    fun getName(): LiveData<String> {
        return name
    }

    fun recoverName(){
        val n = SharedPreferencesManager.getString("NOME", "")
        if(n != "") {
            name.value = n
        }
    }

    fun selectDog(){
        if (selected.value == 0) {
            selected.value = 1
        }
        curiosity.value = selected.value?.let { generator.getCuriosidade(it) }
    }

    fun selectCat(){
        if (selected.value == 1) {
            selected.value = 0
        }
        curiosity.value = selected.value?.let { generator.getCuriosidade(it) }
    }


    fun updateCuriosity() {
        selected.value?.let { generator.nextCuriosidade(it)
        curiosity.value = generator.getCuriosidade(it) }
    }

}