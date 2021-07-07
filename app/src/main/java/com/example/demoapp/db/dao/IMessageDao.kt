package com.example.demoapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.demoapp.models.MessageEntity

@Dao
interface IMessageDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(list: List<MessageEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun insert(data: MessageEntity)

    @Update
    suspend fun update(data: MessageEntity)

    @Delete
    suspend fun delete(data: MessageEntity)

    @Query("DELETE FROM ${MessageEntity.TABLE_NAME}")
    suspend fun nukeTable()

    @Query("SELECT * FROM ${MessageEntity.TABLE_NAME}")
    fun getAllRecords(): LiveData<List<MessageEntity>>
}
