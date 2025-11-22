package com.example.segundo_app.repository.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Curiosity")
class CuriosityModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id: Int = 0

    @ColumnInfo(name="curiosity_text")
    var curiosity_text: String = ""


}