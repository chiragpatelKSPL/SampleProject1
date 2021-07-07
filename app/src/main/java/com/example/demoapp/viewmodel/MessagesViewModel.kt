package com.example.demoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.viewModelScope
import com.example.demoapp.R
import com.example.demoapp.db.AppDatabase
import com.example.demoapp.db.RoomDbBuilder
import com.example.demoapp.db.repo.MessageRepository
import com.example.demoapp.models.MessageEntity
import com.example.demoapp.models.UserEntity
import kotlinx.coroutines.launch

class MessagesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MessageRepository
    val allMessages: LiveData<List<MessageEntity>>
    val favUsers: MediatorLiveData<List<UserEntity>> = MediatorLiveData()

    init {
        val messageDao = RoomDbBuilder.getInstance(application.applicationContext).getMessageDao()
        repository = MessageRepository(messageDao)
        nukeTable()
        allMessages = repository.allData
    }

    fun insert(messageData: MessageEntity) = viewModelScope.launch {
        repository.insert(messageData)
    }

    fun insertAll(messageList: ArrayList<MessageEntity>) = viewModelScope.launch {
        repository.insertAll(messageList)
    }

    fun nukeTable() = viewModelScope.launch {
        repository.nukeTable()
    }

    fun addMessages(){
        val messagesList : ArrayList<MessageEntity> = ArrayList()
        messagesList.add(MessageEntity("Anastasia", "How are you?", "Sun", R.drawable.avatar1 ))
        messagesList.add(MessageEntity("Gustavo", "Doing super. Thank you!", "Fri", R.drawable.avatar2 ))
        messagesList.add(MessageEntity("David", "How is all there?", "01 Mar", R.drawable.avatar3 ))
        messagesList.add(MessageEntity("John", "Thank you!", "29 Feb", R.drawable.avatar4 ))
        messagesList.add(MessageEntity("Albert", "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.", "25 Feb", R.drawable.avatar2 ))
        messagesList.add(MessageEntity("Calvin", "A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.", "23 Feb", R.drawable.avatar3 ))
        messagesList.add(MessageEntity("Douglas", "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born", "20 Feb", R.drawable.avatar1 ))
        insertAll(messagesList)
    }

    fun addFavUsers(){
        val favUserList : ArrayList<UserEntity> = ArrayList()
        favUserList.add(UserEntity(R.drawable.user1,"Bozenka Malina"))
        favUserList.add(UserEntity(R.drawable.user2,"Anastasia Ziemkowska"))
        favUserList.add(UserEntity(R.drawable.user3,"Magdalena Pomorska"))
        favUserList.add(UserEntity(R.drawable.user1,"Douglas"))
        favUsers.value = favUserList
    }
}
