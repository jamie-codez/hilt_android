package com.code.hiltadroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():AppDao
    companion object{
        private var db_instance:AppDatabase?=null
        fun getAppDatabase(context: Context):AppDatabase{
            if (db_instance==null){
                db_instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Hilt_db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return db_instance!!
        }
    }
}