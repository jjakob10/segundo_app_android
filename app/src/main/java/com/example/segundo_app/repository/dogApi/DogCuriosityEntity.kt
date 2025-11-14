package com.example.segundo_app.repository.dogApi

import com.google.gson.annotations.SerializedName

class DogCuriosityEntity {
    @SerializedName("data")
    var data: List<DataItem> = emptyList()
}

class DataItem {

    @SerializedName("id")
    var id: String = ""

    @SerializedName("type")
    var type: String = ""

    @SerializedName("attributes")
    var attributes: Attributes? = null
}

class Attributes {

    @SerializedName("body")
    var body: String = ""
}
