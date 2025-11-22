package com.example.segundo_app.repository.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundo_app.repository.data.dao.CuriosityDAO
import com.example.segundo_app.repository.data.model.CuriosityModel

@Database(entities = [CuriosityModel::class], version = 1)
abstract class CatAppDatabase(): RoomDatabase() {

    abstract fun CuriosityDAO(): CuriosityDAO
    companion object {
        private lateinit var INSTANCE: CatAppDatabase
        fun getDatabase(context: Context): CatAppDatabase {

            if(!::INSTANCE.isInitialized) {

                synchronized(CatAppDatabase::class) {

                    INSTANCE = Room.databaseBuilder(context, CatAppDatabase::class.java, "cat.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
