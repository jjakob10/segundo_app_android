package com.example.segundo_app

class CuriosityGenerator {
    companion object {
        private val curiosidadesGatos = listOf(
            "Os gatos dormem cerca de 70% da vida.",
            "Gatos não sentem o sabor doce.",
            "Um grupo de gatos é chamado de 'clowder'.",
            "Os gatos podem fazer mais de 100 sons diferentes.",
            "O ronronar do gato pode ajudar na cura de ossos e tecidos.",
            "Os gatos domésticos compartilham 95,6% de seu DNA com tigres.",
            "Gatos têm cinco dedos nas patas dianteiras e quatro nas traseiras.",
            "A maioria dos gatos odeia água porque sua pelagem demora a secar.",
            "Os gatos têm uma visão noturna seis vezes melhor que a dos humanos.",
            "Os bigodes dos gatos são extremamente sensíveis e ajudam na navegação."
        )

        private val curiosidadesCachorros = listOf(
            "Os cães têm um olfato cerca de 40 vezes mais potente que o dos humanos.",
            "Cães conseguem entender até 250 palavras e gestos.",
            "O nariz de cada cachorro é único, como uma impressão digital.",
            "Os cães sonham, assim como os humanos.",
            "Cães podem ouvir sons em frequências até duas vezes mais altas que humanos.",
            "O Basenji é uma raça de cachorro que não late.",
            "Filhotes de cachorro nascem cegos, surdos e sem dentes.",
            "O sentido mais aguçado dos cães é o olfato.",
            "Os cães suam apenas pelas patas.",
            "O focinho úmido ajuda os cães a absorver melhor os cheiros."
        )
    }

    private var indiceGato = 0
    private var indiceCachorro = 0

    fun nextCuriosidade(tipo: Int){
        if(tipo == 0){
            indiceGato = (indiceGato + 1) % curiosidadesGatos.size
        }else{
            indiceCachorro = (indiceCachorro + 1) % curiosidadesCachorros.size
        }
    }

    fun getCuriosidade(tipo: Int): String {
        return when (tipo) {
            0 -> {
               curiosidadesGatos[indiceGato]

            }
            1 -> {
                 curiosidadesCachorros[indiceCachorro]

            }
            else -> "Tipo inválido! Use 0 para gato ou 1 para cachorro."
        }
    }
}