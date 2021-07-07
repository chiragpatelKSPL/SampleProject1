package com.example.demoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demoapp.models.MessageEntity
import com.example.demoapp.db.dao.IMessageDao


const val DB_VERSION = 1

@Database(
    entities = [MessageEntity::class],
    version = DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMessageDao(): IMessageDao
}
