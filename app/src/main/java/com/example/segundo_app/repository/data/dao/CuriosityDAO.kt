package com.example.segundo_app.repository.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.segundo_app.repository.data.model.CuriosityModel

@Dao
interface CuriosityDAO {

    @Insert
    fun insert(p: CuriosityModel): Long

    @Update
    fun update(p: CuriosityModel): Int

    @Delete
    fun delete(p: CuriosityModel)

    @Query("SELECT * FROM Curiosity WHERE id = :id")
    fun getById(id: Int): CuriosityModel

    @Query("SELECT * FROM Curiosity")
    fun getAll(): List<CuriosityModel>

    @Query("SELECT count(*) FROM Curiosity")
    fun getQtd(): Int


}