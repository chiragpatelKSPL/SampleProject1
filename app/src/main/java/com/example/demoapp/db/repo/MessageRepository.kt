package com.example.demoapp.db.repo

import androidx.lifecycle.LiveData
import com.example.demoapp.db.dao.IMessageDao
import com.example.demoapp.models.MessageEntity

class MessageRepository(private val messageDao: IMessageDao) {
    val allData: LiveData<List<MessageEntity>> = messageDao.getAllRecords()

    suspend fun insert(data: MessageEntity) {
        messageDao.insert(data)
    }
    suspend fun insertAll(messageList: List<MessageEntity>) {
        messageDao.insertAll(messageList)
    }
    suspend fun nukeTable() {
        messageDao.nukeTable()
    }
}