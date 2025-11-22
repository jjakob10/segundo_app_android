package com.example.segundo_app.repository.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundo_app.repository.data.dao.CuriosityDAO
import com.example.segundo_app.repository.data.model.CuriosityModel

@Database(entities = [CuriosityModel::class], version = 1)
abstract class DogAppDatabase(): RoomDatabase() {

    abstract fun CuriosityDAO(): CuriosityDAO
    companion object {
        private lateinit var INSTANCE: DogAppDatabase
        fun getDatabase(context: Context): DogAppDatabase {

            if(!::INSTANCE.isInitialized) {

                synchronized(DogAppDatabase::class) {

                    INSTANCE = Room.databaseBuilder(context, DogAppDatabase::class.java, "dog.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
