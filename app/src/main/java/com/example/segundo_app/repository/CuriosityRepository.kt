package com.example.segundo_app.repository

import android.content.Context
import com.example.segundo_app.repository.data.dao.CuriosityDAO

class CuriosityRepository (val dogDb: CuriosityDAO, val catDb: CuriosityDAO){

    private var indiceGato = 1
    private var indiceCachorro = 1

    fun nextCuriosidade(tipo: Int){

        if(tipo == 0){
            val qtd = catDb.getQtd()
            if(qtd != 0)
                indiceGato = (indiceGato + 1) % qtd
        }else{
            val qtd = dogDb.getQtd()
            if(qtd != 0)
                indiceCachorro = (indiceCachorro + 1) % qtd
        }
    }

    fun getCuriosidade(tipo: Int): String {
        val c = when (tipo) {
            0 -> {
                catDb.getById(indiceGato)
            }
            else -> {
                dogDb.getById(indiceGato)
            }
        }
        if(c==null)
            return ""

        return c.curiosity_text
    }
}