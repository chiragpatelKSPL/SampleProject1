package com.example.demoapp.db

import android.content.Context
import androidx.room.Room

object  RoomDbBuilder {

    private val DB_NAME = "demoapp.db"
    private var databseInstance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (databseInstance == null) {
            synchronized(AppDatabase::class) {
                databseInstance = buildRoomDB(context)
            }
        }
        return databseInstance!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        ).build()
}