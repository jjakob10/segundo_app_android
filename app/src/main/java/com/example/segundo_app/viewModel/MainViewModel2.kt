package com.example.segundo_app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.segundo_app.repository.catApi.CatClientRetrofit
import com.example.segundo_app.repository.catApi.CatCuriosityEntity
import com.example.segundo_app.repository.catApi.CatCuriosityService
import com.example.segundo_app.repository.dogApi.DogClientRetrofit
import com.example.segundo_app.repository.dogApi.DogCuriosityEntity
import com.example.segundo_app.repository.dogApi.DogCuriosityService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel2(application: Application) : AndroidViewModel(application) {
    private var name = MutableLiveData<String>()
    private var selected = MutableLiveData(0)
    private var curiosity = MutableLiveData<String>()

    private lateinit var dogCuriosity: String
    private lateinit var catCuriosity: String

    val apiCat = CatClientRetrofit.createService(CatCuriosityService::class.java)
    val apiDog = DogClientRetrofit.createService(DogCuriosityService::class.java)

    init {
        selectCat()
    }
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
        selected.value = 1
        if (!this::dogCuriosity.isInitialized) {
            updateCuriosity()
        }
        else {
            curiosity.value = dogCuriosity
        }
    }

    fun selectCat(){
        selected.value = 0
        if (!this::catCuriosity.isInitialized) {
            updateCuriosity()
        }else {
            curiosity.value = catCuriosity
        }
    }


    fun updateCuriosity() {

        if (selected.value == 0) {

            // ==========================
            //         CAT API
            // ==========================
            val resp: Call<CatCuriosityEntity> = apiCat.getCatCuriosity()

            resp.enqueue(object : Callback<CatCuriosityEntity> {

                override fun onResponse(
                    call: Call<CatCuriosityEntity>,
                    response: Response<CatCuriosityEntity>
                ) {

                    if (response.isSuccessful) {
                        curiosity.value = response.body()?.fact ?: "Resposta de gato inválida"
                        catCuriosity = curiosity.value!!
                        return
                    }

                    // Tratamento de erros HTTP
                    when (response.code()) {
                        404 -> curiosity.value = "Gato não encontrado (404)"
                        500 -> curiosity.value = "Erro no servidor da API de gatos (500)"
                        else -> curiosity.value = "Erro ${response.code()} na API de gatos"
                    }
                }

                override fun onFailure(call: Call<CatCuriosityEntity>, t: Throwable) {
                    curiosity.value = "Falha de rede na API de gatos: ${t.localizedMessage}"
                }
            })

        } else {

            // ==========================
            //        DOG API
            // ==========================
            val resp: Call<DogCuriosityEntity> = apiDog.getDogCuriosity()

            resp.enqueue(object : Callback<DogCuriosityEntity> {

                override fun onResponse(
                    call: Call<DogCuriosityEntity>,
                    response: Response<DogCuriosityEntity>
                ) {

                    if (response.isSuccessful) {
                        curiosity.value = response.body()
                            ?.data
                            ?.getOrNull(0)
                            ?.attributes
                            ?.body
                            ?: "Resposta de cachorro inválida"

                        dogCuriosity = curiosity.value!!
                        return
                    }

                    // Tratamento de erros HTTP
                    when (response.code()) {
                        404 -> curiosity.value = "Cachorro não encontrado (404)"
                        500 -> curiosity.value = "Erro no servidor da API de cachorros (500)"
                        else -> curiosity.value = "Erro ${response.code()} na API de cachorros"
                    }
                }

                override fun onFailure(call: Call<DogCuriosityEntity>, t: Throwable) {
                    curiosity.value = "Falha de rede na API de cachorros: ${t.localizedMessage}"
                }
            })
        }
    }

}