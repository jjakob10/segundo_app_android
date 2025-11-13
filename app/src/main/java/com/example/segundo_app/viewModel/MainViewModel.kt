package com.example.segundo_app.viewModel

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var name = MutableLiveData<String>()


    fun getName(): LiveData<String> {
        return name
    }

    fun recoverName(){
        val n = SharedPreferencesManager.getString("NOME", "")
        if(n != "") {
            name.value = n
        }
    }
    fun saveName(n: String){
        SharedPreferencesManager.saveString("NOME", n)
        name.value = n
    }

}